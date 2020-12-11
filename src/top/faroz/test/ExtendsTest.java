package top.faroz.test;

/**
 * @ClassName ExtendsTest
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/12/11 下午1:02
 * @Version 1.0
 **/
public class ExtendsTest {
    public static void main(String[] args) {
        Father f=new Son();


    }
}

class Father{
    int a;
    int b;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}

class Son extends Father {
    int c;
    int d;

    @Override
    public int getA() {
        return super.getA();
    }

    @Override
    public void setA(int a) {
        super.setA(a);
    }

    @Override
    public int getB() {
        return super.getB();
    }

    @Override
    public void setB(int b) {
        super.setB(b);
    }
}


