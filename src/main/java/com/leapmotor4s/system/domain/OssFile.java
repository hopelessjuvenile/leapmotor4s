package com.leapmotor4s.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.annotation.TableName;
import com.leapmotor4s.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * OssFile
 *
 * @author leapmotor4s
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("oss_file")
public class OssFile extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 业务关联id
     */
    @TableId(value = "file_id")
    private Long fileId;
    /**
     * 文件地址
     */
    private String filePath;
    /**
     * 域名地址
     */
    private String domain;
    /**
     * 文件名
     */
    private String name;
    /**
     * 原始文件名
     */
    private String originalName;
    /**
     * 文件hash值
     */
    public String hash;
    /**
     * 文件大小
     */
    private Long size;
    /**
     * 文件上传时间
     */
    private Date putTime;
    /**
     * 文件contentType
     */
    private String contentType;
    /**
     * 照片方位
     */
    private String direction;
    /**
     * 车牌号
     */
    private String licensePlate;
}