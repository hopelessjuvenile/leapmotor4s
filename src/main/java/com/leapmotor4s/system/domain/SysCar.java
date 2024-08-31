package com.leapmotor4s.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.leapmotor4s.common.core.domain.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 汽车表单对象 sys_car
 *
 * @author badmf
 * @date 2023-11-06
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_car")
public class SysCar extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 业务关联id
     */
    @TableId(value = "service_id", type = IdType.AUTO)
    private Long serviceId;
    /**
     * 车牌号
     */
    private String licensePlate;
    /**
     * 保养单号
     */
    private String orderNumber;
    /**
     * 经办人
     */
    private String agentName;
    /**
     * 保养日期
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date createTime;
    /**
     * 备注
     */
    private String remark;

}
