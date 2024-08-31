package com.leapmotor4s.system.util;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class ByteToMultipartFileConverter {

    public static MultipartFile convert(byte[] bytes, String fileName) throws IOException {
        // 创建一个ByteArrayResource
        ByteArrayResource resource = new ByteArrayResource(bytes);

        // 使用MockMultipartFile创建MultipartFile对象
        MultipartFile multipartFile = new MockMultipartFile(fileName, fileName, "application/octet-stream", resource.getInputStream());

        return multipartFile;
    }
}
