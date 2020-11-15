package top.faroz.bean;

/**
 * @ClassName Student
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/11/15 下午8:44
 * @Version 1.0
 **/
public class Stu {
    private int id;
    private String name;
    private String password;
    private int sta_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSta_id() {
        return sta_id;
    }

    public void setSta_id(int sta_id) {
        this.sta_id = sta_id;
    }
}
