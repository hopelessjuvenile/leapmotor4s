package com.leapmotor4s.system.domain.bo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.leapmotor4s.common.core.validate.AddGroup;
import com.leapmotor4s.common.core.validate.EditGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.*;

import java.util.Date;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.leapmotor4s.common.core.domain.BaseEntity;

/**
 * 汽车表单业务对象 oss_file
 *
 * @author leapmotor4s
 * @date 2023-11-06
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class OssFileBo extends BaseEntity {

    /**
     * 业务关联id
     */
    @NotNull(message = "id不能为空", groups = { EditGroup.class })
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

