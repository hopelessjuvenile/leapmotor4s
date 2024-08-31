package com.leapmotor4s.system.service;

import com.leapmotor4s.system.domain.OssFile;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * OssTemplate抽象API
 *
 * @author leapmotor4s
 */
public interface OssTemplate {

    /**
     * 存储桶是否存在
     *
     * @param bucketName 存储桶名称
     * @return boolean
     */
    boolean bucketExists(String bucketName);


    /**
     * 获取文件信息
     *
     * @param fileName 存储桶文件名称
     * @return InputStream
     */
    OssFile getOssInfo(String fileName);

    /**
     * 上传文件
     *
     * @param folderName 上传的文件夹名称
     * @param fileName   上传文件名
     * @param file       上传文件类
     * @return BladeFile
     */
    OssFile upLoadFile(String folderName, String fileName, String direction, String licensePlate, MultipartFile file);

    /**
     * 上传文件
     *
     * @param folderName 上传的文件夹名称
     * @param fileName   存储桶对象名称
     * @param attrMap    参数map
     * @param stream     文件流
     * @return BladeFile
     */
    OssFile upLoadFile(String folderName, String fileName, Map<String, String> attrMap, InputStream stream);

    /**
     * 删除文件
     *
     * @param fileName 存储桶对象名称
     */
    boolean removeFile(String fileName);

    /**
     * 批量删除文件
     *
     * @param fileNames 存储桶对象名称集合
     */
    boolean removeFiles(List<String> fileNames);

    /**
     * @Description: 下载文件
     * @Param response: 响应
     * @Param fileName: 文件名
     * @Param filePath: 文件路径
     * @return: void
     */
    void downloadFile(HttpServletResponse response, String fileName, String filePath);
}
