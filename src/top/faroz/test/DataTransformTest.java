package top.faroz.test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName DataTransformTest
 * @Description 测试日期的互相转换
 * @Author FARO_Z
 * @Date 2020/12/14 上午10:17
 * @Version 1.0
 **/
public class DataTransformTest {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(new Date());
        System.out.println(format);
    }
}
