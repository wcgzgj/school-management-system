package top.faroz.utils;

import java.text.SimpleDateFormat;

/**
 * @ClassName ViewUtil
 * @Description 将从DB中获取的英文类型
 * 转换为中文，保证界面用户友好
 * @Author FARO_Z
 * @Date 2020/12/14 上午10:09
 * @Version 1.0
 **/
public class TranslateUtil {
    /**
     * 翻译假期的类型
     * @param str
     * @return
     */
    public static String translateStatus(String str) {
        switch (str) {
            case "underreview":
                return "审核中";
            case "undergoing":
                return "进行中";
            case "over":
                return "已结束";
            case "reject":
                return "已拒绝";
            case "agree":
                return "已同意";
            default:
                return "输入错误";
        }
    }

    public static String translateHolidayType(String str) {
        switch (str) {
            case "practice": 
                return "实习";
            case "family":
                return "探亲";
            case "temp":
                return "临时";
            case "holiday":
                return "假期";
            default:
                return "输入错误";
        }
    }

    /**
     * 将格林威治标准时翻译为 yyyy-MM-dd格式
     * @param date
     * @return
     */
    public static String translateDate(java.util.Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
}
