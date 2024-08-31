package com.leapmotor4s.system.domain.bo;

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
 * 汽车表单业务对象 sys_car
 *
 * @author badmf
 * @date 2023-11-06
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class SysCarBo extends BaseEntity {

    /**
     * 业务关联id
     */
    @NotNull(message = "业务关联id不能为空", groups = { EditGroup.class })
    private Long serviceId;

    /**
     * 车牌号
     */
    @NotBlank(message = "车牌号不能为空", groups = { AddGroup.class, EditGroup.class })
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
    private Date createTime;

    /**
     * 备注
     */
    private String remark;


}
