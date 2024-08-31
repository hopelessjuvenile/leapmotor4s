package com.leapmotor4s.system.controller;

import java.io.File;
import java.io.IOException;
import java.util.*;

import com.leapmotor4s.system.domain.OssFile;
import com.leapmotor4s.system.domain.vo.OssFileVo;
import com.leapmotor4s.system.service.IOssFileService;
import com.leapmotor4s.system.service.OssTemplate;
import com.leapmotor4s.system.util.ByteToMultipartFileConverter;
import com.leapmotor4s.system.util.LoggingOssFileInfo;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.*;
import cn.dev33.satoken.annotation.SaCheckPermission;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import com.leapmotor4s.common.annotation.RepeatSubmit;
import com.leapmotor4s.common.annotation.Log;
import com.leapmotor4s.common.core.controller.BaseController;
import com.leapmotor4s.common.core.domain.R;
import com.leapmotor4s.common.core.validate.AddGroup;
import com.leapmotor4s.common.enums.BusinessType;
import org.springframework.web.multipart.MultipartFile;

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
@RequestMapping("oss/file")
public class OssFileController extends BaseController {

    private final OssTemplate ossTemplate;
    private final IOssFileService iOssFileService;

    /**
     * 新增文件
     */
    @SaCheckPermission("oss:file:add")
    @Log(title = "文件表单", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody OssFile bo) {
        R<Void> flag = toAjax(iOssFileService.insertByBo(bo));
        return flag;
    }

    /**
     * 获取汽车图像详细信息
     *
     * @param fileId 主键
     */
    @SaCheckPermission("oss:file:idQuery")
    @GetMapping("/Id")
    public R<OssFileVo> getInfo(@NotNull(message = "主键不能为空")
                               @RequestParam Long fileId) {
        return R.ok(iOssFileService.queryById(fileId));
    }

    /**
     * 接收图片并打包存储
     */
    @SaCheckPermission("oss:file:image")
    @Log(title = "获取图像", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping("/image")
    public R<Void> checkImage(@RequestBody Map<String, String> map) throws IOException {
        log.info("检测到一次Post上传图像请求");
        String fileStr = map.get("file");
        byte[] fileStream = Base64.getDecoder().decode(fileStr);
        MultipartFile multipartFileStream = ByteToMultipartFileConverter.convert(fileStream, map.get("file_name"));
        File file = new File("D:\\test.jpeg");
        OssFile storageFile = ossTemplate.upLoadFile("carimage", multipartFileStream.getName(), map.get("direction"), map.get("license_plate"), multipartFileStream);
//        打印文件信息
        LoggingOssFileInfo.loggingOssFileInfo(storageFile);
//        打包存储
        R<Void> addResult = add(storageFile);
        log.info(addResult.toString());
        return toAjax(true);
    }
}

