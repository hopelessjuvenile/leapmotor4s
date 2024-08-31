package com.leapmotor4s.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.leapmotor4s.common.utils.StringUtils;
import com.leapmotor4s.common.core.page.TableDataInfo;
import com.leapmotor4s.common.core.domain.PageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.leapmotor4s.system.domain.DTO.SysCarDTO;
import com.leapmotor4s.system.domain.OssFile;
import com.leapmotor4s.system.mapper.OssFileMPJMapper;
import com.leapmotor4s.system.mapper.SysCarMPJMapper;
import com.leapmotor4s.system.mapper.SysCarOtherMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import com.leapmotor4s.system.domain.bo.SysCarBo;
import com.leapmotor4s.system.domain.vo.SysCarVo;
import com.leapmotor4s.system.domain.SysCar;
import com.leapmotor4s.system.mapper.SysCarMapper;
import com.leapmotor4s.system.service.ISysCarService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 汽车表单Service业务层处理
 *
 * @author badmf
 * @date 2023-11-06
 */
@Slf4j
@RequiredArgsConstructor
@Service("PrimaryCar")
public class SysCarServiceImpl implements ISysCarService {

    private final SysCarMapper baseMapper;
    private final SysCarOtherMapper baseOtherMapper;
    private final OssFileMPJMapper baseMPJMapper;

    /**
     * 查询汽车表单
     */
    @Override
    public SysCarVo queryById(Long serviceId){
        return baseMapper.selectVoById(serviceId);
    }

    /**
     * 根据车牌号查询汽车表单
     */
    @Override
    public List<SysCarVo> queryByLicensePlate(String licensePlate){
        QueryWrapper<SysCarVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("license_plate", licensePlate);
        return baseOtherMapper.selectList(queryWrapper);
    }

    /**
     * 查询汽车表单列表
     */
    @Override
    public TableDataInfo<SysCarVo> queryPageList(SysCarBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<SysCar> lqw = buildQueryWrapper(bo);
        Page<SysCarVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询汽车表单列表
     */
    @Override
    public List<SysCarVo> queryList(SysCarBo bo) {
        LambdaQueryWrapper<SysCar> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<SysCar> buildQueryWrapper(SysCarBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<SysCar> lqw = Wrappers.lambdaQuery();
        lqw.eq(StringUtils.isNotBlank(bo.getLicensePlate()), SysCar::getLicensePlate, bo.getLicensePlate());
        lqw.eq(StringUtils.isNotBlank(bo.getOrderNumber()), SysCar::getOrderNumber, bo.getOrderNumber());
        lqw.like(StringUtils.isNotBlank(bo.getAgentName()), SysCar::getAgentName, bo.getAgentName());
        lqw.eq(bo.getCreateTime() != null, SysCar::getCreateTime, bo.getCreateTime());
        return lqw;
    }

    /**
     * 新增汽车表单
     */
    @Override
    public Boolean insertByBo(SysCarBo bo) {
        SysCar add = BeanUtil.toBean(bo, SysCar.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setServiceId(add.getServiceId());
        }
        return flag;
    }

    /**
     * 修改汽车表单
     */
    @Override
    public Boolean updateByBo(SysCarBo bo) {
        SysCar update = BeanUtil.toBean(bo, SysCar.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(SysCar entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除汽车表单
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }

    /**
     * 根据sys_car和oss_file联表查询oss_file.domain和oss_file.direction
     */
    @Override
    public List<SysCarDTO> queryJoinByLicensePlate(String licensePlate) {
        MPJLambdaWrapper<OssFile> wrapper = new MPJLambdaWrapper<OssFile>()
                .select(SysCar::getAgentName, SysCar::getOrderNumber, SysCar::getLicensePlate, SysCar::getRemark)
                .select(OssFile::getDomain, OssFile::getDirection, OssFile::getPutTime, OssFile::getFilePath, OssFile::getName)
                .leftJoin(SysCar.class, SysCar::getLicensePlate, OssFile::getLicensePlate)
                .eq(SysCar::getLicensePlate, licensePlate);
        return baseMPJMapper.selectJoinList(SysCarDTO.class, wrapper);
    }
}

