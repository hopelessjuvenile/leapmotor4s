package com.leapmotor4s.common.encrypt.encryptor;

import com.leapmotor4s.common.encrypt.EncryptContext;
import com.leapmotor4s.common.enums.AlgorithmType;
import com.leapmotor4s.common.enums.EncodeType;
import com.leapmotor4s.common.utils.EncryptUtils;

/**
 * Base64算法实现
 *
 * @author leapmotor4s
 */
public class Base64Encryptor extends AbstractEncryptor {

    public Base64Encryptor(EncryptContext context) {
        super(context);
    }

    /**
     * 获得当前算法
     */
    @Override
    public AlgorithmType algorithm() {
        return AlgorithmType.BASE64;
    }

    /**
     * 加密
     *
     * @param value      待加密字符串
     * @param encodeType 加密后的编码格式
     */
    @Override
    public String encrypt(String value, EncodeType encodeType) {
        return EncryptUtils.encryptByBase64(value);
    }

    /**
     * 解密
     *
     * @param value      待加密字符串
     */
    @Override
    public String decrypt(String value) {
        return EncryptUtils.decryptByBase64(value);
    }
}
