package com.leapmotor4s.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.leapmotor4s.system.domain.OssFile;
import com.leapmotor4s.system.domain.vo.OssFileVo;
import com.leapmotor4s.system.domain.vo.SysCarVo;
import com.leapmotor4s.system.mapper.OssFileMapper;
import com.leapmotor4s.system.mapper.SysCarMapper;
import com.leapmotor4s.system.service.IOssFileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service("PrimaryFile")
public class OssFileServiceImpl implements IOssFileService {

    private final OssFileMapper baseMapper;

    /**
     * 查询汽车表单
     */
    @Override
    public OssFileVo queryById(Long fileId){
        return baseMapper.selectVoById(fileId);
    }

    /**
     * 新增汽车表单
     */
    @Override
    public Boolean insertByBo(OssFile bo) {
        OssFile add = BeanUtil.toBean(bo, OssFile.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setFileId(add.getFileId());
        }
        return flag;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(OssFile entity){
        //TODO 做一些数据校验,如唯一约束
    }
}
