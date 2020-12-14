package top.faroz.test;

import top.faroz.utils.StringUtil;

/**
 * @ClassName ParseFloatTest
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/12/14 下午3:13
 * @Version 1.0
 **/
public class ParseFloatTest {
    public static void main(String[] args) {
        String[] strs={"1","3.14",".14","a12","12.2.2"};
        for (String str : strs) {
            System.out.println(StringUtil.isFloat(str));
        }
    }
}
