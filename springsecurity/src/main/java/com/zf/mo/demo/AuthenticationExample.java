//package com.zf.mo.demo;
//
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.ProviderManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class AuthenticationExample {
//
//    private static AuthenticationManager am = new SampleAuthenticationManager();
//
//    public static void main(String[] args) {
//
//        Authentication request = new UsernamePasswordAuthenticationToken("zhoufei", "123123");
//        Authentication result = am.authenticate(request);
//        SecurityContextHolder.getContext().setAuthentication(result);
//        System.out.println("Successfully authenticated. Security context contains: " + SecurityContextHolder.getContext().getAuthentication());
//        System.out.println("request.getAuthorities():"+result.getAuthorities());
//        System.out.println("result.getDetails():"+result.getDetails());
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println("SecurityContextHolder.getContext().getAuthentication():"+SecurityContextHolder.getContext().getAuthentication());
//
//    }
//
//    private static class SampleAuthenticationManager implements AuthenticationManager{
//       static final List<GrantedAuthority>  AUTHORITIES = new ArrayList<>();
//       static{
//           AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_USER"));
//       }
//        @Override
//        public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//            System.out.println("getPrincipal:"+authentication.getPrincipal());
//            System.out.println("getCredentials:"+authentication.getCredentials());
//            if(authentication.getName().equals(authentication.getPrincipal())){
//                return new UsernamePasswordAuthenticationToken(authentication.getPrincipal(),authentication.getCredentials(),AUTHORITIES);
//            }
//            throw new RuntimeException("bad credentials");
//        }
//    }
//
//}
