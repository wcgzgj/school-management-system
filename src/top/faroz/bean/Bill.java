package top.faroz.bean;

/**
 * @ClassName Bill
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/11/15 下午8:44
 * @Version 1.0
 **/
public class Bill {
    private int id;
    private String reason;
    private float money;
    private String status;
    private int stu_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
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
