package top.faroz.test;

/**
 * @ClassName JSPUseFileTest
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/12/10 下午3:08
 * @Version 1.0
 **/
public class JSPUseFileTest {
    public void JSPUse() {
        System.out.println("JSP文件正在使用src中类");
        /**
         * 经过测试，jsp是可以直接使用src中的类的
         * 所以，可以在controller中使用Dao层函数进行判断
         */
    }
}
