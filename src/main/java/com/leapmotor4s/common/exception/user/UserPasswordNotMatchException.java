package com.leapmotor4s.common.exception.user;

/**
 * 用户密码不正确或不符合规范异常类
 *
 * @author leapmotor4s
 */
public class UserPasswordNotMatchException extends UserException {
    private static final long serialVersionUID = 1L;

    public UserPasswordNotMatchException() {
        super("user.password.not.match");
    }
}
