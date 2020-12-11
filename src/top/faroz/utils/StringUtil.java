package top.faroz.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName StringUtil
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/12/10 下午5:39
 * @Version 1.0
 **/
public class StringUtil {
    /**
     * 判断字符串是否为空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        if (str.length()==0) return true;
        return false;
    }

    /**
     * 判断该字符串中包含的是不是int类型数
     * @param str
     * @return
     */
    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
