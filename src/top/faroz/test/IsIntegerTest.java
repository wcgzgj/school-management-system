package top.faroz.test;

import top.faroz.utils.StringUtil;

/**
 * @ClassName IsIntegerTest
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/12/11 下午3:58
 * @Version 1.0
 **/
public class IsIntegerTest {
    public static void main(String[] args) {
        System.out.println(StringUtil.isInteger("12345"));
        System.out.println(StringUtil.isInteger("12345abc"));
        System.out.println(StringUtil.isInteger("abcd"));
    }
}
