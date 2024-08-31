package com.leapmotor4s.system.service;

import com.leapmotor4s.system.domain.DTO.SysCarDTO;
import com.leapmotor4s.system.domain.SysCar;
import com.leapmotor4s.system.domain.vo.SysCarVo;
import com.leapmotor4s.system.domain.bo.SysCarBo;
import com.leapmotor4s.common.core.page.TableDataInfo;
import com.leapmotor4s.common.core.domain.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 汽车表单Service接口
 *
 * @author badmf
 * @date 2023-11-06
 */
public interface ISysCarService {

    /**
     * 查询汽车表单
     */
    SysCarVo queryById(Long serviceId);

    /**
     * 根据车牌号查询汽车表单
     */
    List<SysCarVo> queryByLicensePlate(String licensePlate);

    /**
     * 查询汽车表单列表
     */
    TableDataInfo<SysCarVo> queryPageList(SysCarBo bo, PageQuery pageQuery);

    /**
     * 查询汽车表单列表
     */
    List<SysCarVo> queryList(SysCarBo bo);


    /**
     * 新增汽车表单
     */
    Boolean insertByBo(SysCarBo bo);

    /**
     * 修改汽车表单
     */
    Boolean updateByBo(SysCarBo bo);

    /**
     * 校验并批量删除汽车表单信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);

    /**
     * 联表查询测试
     */
    List<SysCarDTO> queryJoinByLicensePlate(String licensePlate);
}
