package org.example.utils;

/**
 * @Project: SpringDemo
 * @Package: org.example.utils
 * @Description: 关于日期显示的工具类
 * @author: xiaoMa
 * @Email:17320080198@163.com
 * @date: 2024年04月10日 10:22
 */

public class DateUtil {
    public static String getDate() {
        return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
    }
}
