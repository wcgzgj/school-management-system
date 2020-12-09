package top.faroz.bean;

import java.util.Date;

/**
 * @ClassName Holiday
 * @Description 假条
 * @Author FARO_Z
 * @Date 2020/11/15 下午8:44
 * @Version 1.0
 **/
public class Holiday {
    private int id;
    private String type;
    private Date start;
    private Date end;
    private String status;
    private int stu_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }
}
