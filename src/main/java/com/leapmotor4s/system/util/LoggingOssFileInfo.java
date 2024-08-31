package com.leapmotor4s.system.util;

import com.leapmotor4s.system.domain.OssFile;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggingOssFileInfo {
    public static void loggingOssFileInfo(OssFile storageFile){
        log.info("FilePath: " + storageFile.getFilePath());
        log.info("Domain: " + storageFile.getDomain());
        log.info("Name: " + storageFile.getName());
        log.info("contentType: " + storageFile.getContentType());
        log.info("hash: " + storageFile.getHash());
        log.info("originalName: " + storageFile.getOriginalName());
        log.info("putTime: " + storageFile.getPutTime().toString());
        log.info("size: " + Double.toString(storageFile.getSize()));
        log.info("direction: " + storageFile.getDirection());
        log.info("licensePlate: " + storageFile.getLicensePlate());
    }
}
