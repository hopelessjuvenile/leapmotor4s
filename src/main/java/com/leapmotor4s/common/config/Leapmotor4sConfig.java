package com.leapmotor4s.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 读取项目相关配置
 *
 * @author leapmotor4s
 */

@Data
@Component
@ConfigurationProperties(prefix = "leapmotor4s")
public class Leapmotor4sConfig {
    /**
     * 项目名称
     */
    private String name;

    /**
     * 版本
     */
    private String version;

    /**
     * 版权年份
     */
    private String copyrightYear;

    /**
     * 缓存懒加载
     */
    private boolean cacheLazy;
}
