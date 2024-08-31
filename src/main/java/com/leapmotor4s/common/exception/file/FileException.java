package com.leapmotor4s.common.exception.file;

import com.leapmotor4s.common.exception.base.BaseException;

/**
 * 文件信息异常类
 *
 * @author leapmotor4s
 */
public class FileException extends BaseException {
    private static final long serialVersionUID = 1L;

    public FileException(String code, Object[] args) {
        super("file", code, args, null);
    }

}
