package com.leapmotor4s.system.service;

import com.leapmotor4s.system.domain.DTO.SysCarDTO;
import com.leapmotor4s.system.domain.OssFile;
import com.leapmotor4s.common.core.page.TableDataInfo;
import com.leapmotor4s.common.core.domain.PageQuery;
import com.leapmotor4s.system.domain.vo.OssFileVo;
import com.leapmotor4s.system.domain.vo.SysCarVo;

import java.util.Collection;
import java.util.List;

/**
 * 文件表单Service接口
 *
 * @author leapmotor4s
 * @date 2023-11-06
 */
public interface IOssFileService {
    /**
     * 新增文件表单
     */
    Boolean insertByBo(OssFile bo);

    /**
     * 查询文件表单
     */
    OssFileVo queryById(Long fileId);
}
