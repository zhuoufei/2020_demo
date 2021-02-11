package com.zf.mo.config;

import com.zf.mo.exception.VerificationCodeException;
import com.zf.mo.handler.MyAuthenticationFailureHandler;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class VerificationCodeFilter extends OncePerRequestFilter {

    private AuthenticationFailureHandler authenticationFailureHandler = new MyAuthenticationFailureHandler();
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {

        System.out.println("httpServletRequest.getRequestURI():"+httpServletRequest.getRequestURI());
        if(!"/auth/form".equals(httpServletRequest.getRequestURI())){
            filterChain.doFilter(httpServletRequest,httpServletResponse);
        }else{
            try {
                verificationCode(httpServletRequest);
                filterChain.doFilter(httpServletRequest,httpServletResponse);
            } catch (AuthenticationException e) {
                authenticationFailureHandler.onAuthenticationFailure(httpServletRequest,httpServletResponse,e);
            }
        }
    }

    public void verificationCode(HttpServletRequest request) throws VerificationCodeException {
        String requestCode = request.getParameter("captcha");
        HttpSession session = request.getSession();
        String saveCode = (String)session.getAttribute("captcha");
        if(!StringUtils.isEmpty(saveCode)){
            session.removeAttribute("captcha");
        }
        //校验不通过，抛出异常
        if(StringUtils.isEmpty(requestCode) || StringUtils.isEmpty(saveCode)){
            throw new VerificationCodeException();
        }

    }
}
