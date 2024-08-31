package com.leapmotor4s.common.core.service;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 通用 部门服务
 *
 * @author leapmotor4s
 */
public interface DeptService {

    /**
     * 通过部门ID查询部门名称
     *
     * @param deptIds 部门ID串逗号分隔
     * @return 部门名称串逗号分隔
     */
    String selectDeptNameByIds(String deptIds);

}
