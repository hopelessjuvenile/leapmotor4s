package com.leapmotor4s.common.exception.user;

import com.leapmotor4s.common.exception.base.BaseException;

/**
 * 用户信息异常类
 *
 * @author leapmotor4s
 */
public class UserException extends BaseException {
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object... args) {
        super("user", code, args, null);
    }
}
