package com.leapmotor4s.system.domain.vo;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.leapmotor4s.common.annotation.ExcelDictFormat;
import com.leapmotor4s.common.convert.ExcelDictConvert;
import lombok.Data;
import java.util.Date;

import java.io.Serializable;

/**
 * 汽车表单视图对象 oss_file
 *
 * @author leapmotor4s
 * @date 2023-11-06
 */
@Data
@ExcelIgnoreUnannotated
public class OssFileVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 业务关联id
     */
    @ExcelProperty(value = "业务关联id")
    private Long fileId;
    /**
     * 文件地址
     */
    @ExcelProperty(value = "文件地址")
    private String filePath;
    /**
     * 域名地址
     */
    @ExcelProperty(value = "域名地址")
    private String domain;
    /**
     * 文件名
     */
    @ExcelProperty(value = "文件名")
    private String name;
    /**
     * 原始文件名
     */
    @ExcelProperty(value = "原始文件名")
    private String originalName;
    /**
     * 文件hash值
     */
    @ExcelProperty(value = "文件hash值")
    public String hash;
    /**
     * 文件大小
     */
    @ExcelProperty(value = "文件大小")
    private Long size;
    /**
     * 文件上传时间
     */
    @ExcelProperty(value = "文件上传时间")
    private Date putTime;
    /**
     * 文件contentType
     */
    @ExcelProperty(value = "文件contentType")
    private String contentType;
    /**
     * 照片方位
     */
    @ExcelProperty(value = "照片方位")
    private String direction;
    /**
     * 车牌号
     */
    @ExcelProperty(value = "车牌号")
    private String licensePlate;
}

