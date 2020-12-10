package top.faroz.bean;

/**
 * @ClassName StuSta
 * @Description 建立老师与学生的关系,
 * 多个学生可以绑定同一个老师
 * 但是每一个学生只能绑定一个老师
 * @Author FARO_Z
 * @Date 2020/12/10 下午3:34
 * @Version 1.0
 **/
public class StuSta {
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
