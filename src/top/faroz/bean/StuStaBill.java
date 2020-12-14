package top.faroz.bean;

/**
 * @ClassName StuStaBill
 * @Description 另一个StuSta其实是StuStaHoliday
 * 但是，因为再次修改，涉及到大量其他修改，麻烦至极
 * 所以，就不再改了，自己记得就好
 * （header和teacherheader也同理）
 * 这里都要归结于写之前，没有设计好
 * 下次在写代码前，一定要提前规划好了
 * @Author FARO_Z
 * @Date 2020/12/14 下午1:25
 * @Version 1.0
 **/
public class StuStaBill {
    private int id;
    private int stu_id;
    private int sta_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public int getSta_id() {
        return sta_id;
    }

    public void setSta_id(int sta_id) {
        this.sta_id = sta_id;
    }
}
