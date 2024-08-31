package com.leapmotor4s.system.util;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class GetCurrentTime {
    public static Date getCurrentTime() {
        // 获取中国时区
        TimeZone chinaTimeZone = TimeZone.getTimeZone("Asia/Shanghai");

        // 获取当前时间
        Date currentDate = new Date();

        // 设置时区
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        dateFormat.setTimeZone(chinaTimeZone);

        try {
            // 格式化为字符串
            String formattedDateStr = dateFormat.format(currentDate);

            // 将字符串解析为 Date 对象
            return dateFormat.parse(formattedDateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return currentDate;
    }
}

