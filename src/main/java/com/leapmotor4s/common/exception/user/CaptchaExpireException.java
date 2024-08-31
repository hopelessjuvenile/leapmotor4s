package com.leapmotor4s.common.exception.user;

/**
 * 验证码失效异常类
 *
 * @author leapmotor4s
 */
public class CaptchaExpireException extends UserException {
    private static final long serialVersionUID = 1L;

    public CaptchaExpireException() {
        super("user.jcaptcha.expire");
    }
}
