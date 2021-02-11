package com.zf.mo.exception;

import javax.security.sasl.AuthenticationException;

public class VerificationCodeException extends AuthenticationException {

    public VerificationCodeException(){
        super("图形验证码校验失败");
    }

}
