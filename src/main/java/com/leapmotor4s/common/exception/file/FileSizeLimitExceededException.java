package com.leapmotor4s.common.exception.file;

/**
 * 文件名大小限制异常类
 *
 * @author leapmotor4s
 */
public class FileSizeLimitExceededException extends FileException {
    private static final long serialVersionUID = 1L;

    public FileSizeLimitExceededException(long defaultMaxSize) {
        super("upload.exceed.maxSize", new Object[]{defaultMaxSize});
    }
}
