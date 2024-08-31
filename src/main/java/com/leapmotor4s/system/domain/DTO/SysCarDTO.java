package com.leapmotor4s.system.domain.DTO;

import com.leapmotor4s.system.domain.OssFile;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@ToString
public class SysCarDTO {

    private String licensePlate;

    private String orderNumber;

    private String agentName;

    private String name;

    private String filePath;

    private Date putTime;

    private String remark;

    /**
     * OssFile关联表中的两个字段
     */
    private String domain;

    private String direction;

    /**
     * 文件列表 用于接下来的一对多映射查询
     */
    private List<OssFile> sysFileList;

    /**
     * 文件对象 用于接下来的一对一映射查询
     */
    private List<OssFile> sysFiles;
}
