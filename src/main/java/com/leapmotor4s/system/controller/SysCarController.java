package com.leapmotor4s.system.controller;

import java.util.*;

import com.leapmotor4s.system.domain.DTO.SysCarDTO;
import com.leapmotor4s.system.service.OssTemplate;
import lombok.RequiredArgsConstructor;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.*;
import cn.dev33.satoken.annotation.SaCheckPermission;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import com.leapmotor4s.common.annotation.RepeatSubmit;
import com.leapmotor4s.common.annotation.Log;
import com.leapmotor4s.common.core.controller.BaseController;
import com.leapmotor4s.common.core.domain.PageQuery;
import com.leapmotor4s.common.core.domain.R;
import com.leapmotor4s.common.core.validate.AddGroup;
import com.leapmotor4s.common.core.validate.EditGroup;
import com.leapmotor4s.common.enums.BusinessType;
import com.leapmotor4s.common.utils.poi.ExcelUtil;
import com.leapmotor4s.system.domain.vo.SysCarVo;
import com.leapmotor4s.system.domain.bo.SysCarBo;
import com.leapmotor4s.system.service.ISysCarService;
import com.leapmotor4s.common.core.page.TableDataInfo;

/**
 * 汽车表单
 *
 * @author leapmotor4s
 * @date 2023-11-06
 */
@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/car")
public class SysCarController extends BaseController {

    private final ISysCarService iSysCarService;
    private final OssTemplate ossTemplate;

    /**
     * 查询汽车表单列表
     */
    @SaCheckPermission("system:car:list")
    @GetMapping("/list")
    public TableDataInfo<SysCarVo> list(SysCarBo bo, PageQuery pageQuery) {
        return iSysCarService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出汽车表单列表
     */
    @SaCheckPermission("system:car:export")
    @Log(title = "汽车表单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(SysCarBo bo, HttpServletResponse response) {
        List<SysCarVo> list = iSysCarService.queryList(bo);
        ExcelUtil.exportExcel(list, "汽车表单", SysCarVo.class, response);
    }

    /**
     * 获取汽车表单详细信息
     *
     * @param serviceId 主键
     */
    @SaCheckPermission("system:car:idQuery")
    @GetMapping("/Id")
    public R<SysCarVo> getInfo(@NotNull(message = "主键不能为空")
                                   @RequestParam Long serviceId) {
        return R.ok(iSysCarService.queryById(serviceId));
    }

    /**
     * 根据车牌号获取汽车表单详细信息
     *
     * @param licensePlate 车牌号
     */
    @SaCheckPermission("system:car:licensePlateQuery")
    @GetMapping("/licensePlateSingle")
    public R<List<SysCarVo>> getInfoWithLicensePlate(@RequestParam String licensePlate) {
        return R.ok(iSysCarService.queryByLicensePlate(licensePlate));
    }


    /**
     * 获取汽车图像信息
     *
     * @param licensePlate 车牌号
     */
    @CrossOrigin(origins = "http://localhost:88")
    @SaCheckPermission("system:car:licenseQuery")
    @GetMapping("/licensePlate")
    public R<List<SysCarDTO>> getImageInfo(@RequestParam String licensePlate) {
        log.info("接收到一次请求");
        log.info(licensePlate.toString());
        log.info(iSysCarService.queryJoinByLicensePlate(licensePlate).toString());
        return R.ok(iSysCarService.queryJoinByLicensePlate(licensePlate));
    }

    /**
     * 新增汽车表单
     */
    @SaCheckPermission("system:car:add")
    @Log(title = "汽车表单", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody SysCarBo bo) {
        R<Void> flag = null;
        if (!R.ok(iSysCarService.queryByLicensePlate(bo.getLicensePlate())).getData().isEmpty()){
            flag = R.fail();
            log.info("车辆信息已存在数据库中！");
        }else {
            flag = toAjax(iSysCarService.insertByBo(bo));
            log.info("flag" + flag.toString());
        }
        return flag;
    }

    /**
     * 修改汽车表单
     */
    @SaCheckPermission("system:car:edit")
    @Log(title = "汽车表单", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody SysCarBo bo) {
        return toAjax(iSysCarService.updateByBo(bo));
    }

    /**
     * 删除汽车表单
     *
     * @param serviceIds 主键串
     */
    @SaCheckPermission("system:car:remove")
    @Log(title = "汽车表单", businessType = BusinessType.DELETE)
    @DeleteMapping("/{serviceIds}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] serviceIds) {
        return toAjax(iSysCarService.deleteWithValidByIds(Arrays.asList(serviceIds), true));
    }
}
