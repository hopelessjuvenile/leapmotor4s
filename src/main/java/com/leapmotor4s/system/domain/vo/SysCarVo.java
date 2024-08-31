package com.leapmotor4s.system.domain.vo;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.leapmotor4s.common.annotation.ExcelDictFormat;
import com.leapmotor4s.common.convert.ExcelDictConvert;
import lombok.Data;
import java.util.Date;

import java.io.Serializable;

/**
 * 汽车表单视图对象 sys_car
 *
 * @author leapmotor4s
 * @date 2023-11-06
 */
@Data
@ExcelIgnoreUnannotated
@TableName("sys_car")
public class SysCarVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 业务关联id
     */
    @ExcelProperty(value = "业务关联id")
    private Long serviceId;

    /**
     * 车牌号
     */
    @ExcelProperty(value = "车牌号")
    private String licensePlate;

    /**
     * 保养单号
     */
    @ExcelProperty(value = "保养单号")
    private String orderNumber;

    /**
     * 经办人
     */
    @ExcelProperty(value = "经办人")
    private String agentName;

    /**
     * 保养日期
     */
    @ExcelProperty(value = "保养日期")
    private Date createTime;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;


}
