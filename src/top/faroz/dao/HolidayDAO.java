package top.faroz.dao;

import top.faroz.bean.Holiday;
import top.faroz.utils.DBUtil;

import java.sql.*;
import java.util.List;

/**
 * @ClassName HolidayDAO
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/11/15 下午8:50
 * @Version 1.0
 **/
public class HolidayDAO extends DAO{
    /**
     *     private int id; //自增id
     *     private String type; //请假类型 "事假 临时假条..."
     *     private Date start; //开始时间
     *     private Date end; //结束时间
     *     private String status; //状态 "审核中  假期中  已销假"
     *     private int stu_id; //申请该假的学生id
     */

    public int getTotal() {
        int total=0;


        return total;
    }

    public void add(Holiday bean) {
        String sql = "insert into holiday values(null,?,?,?,?,?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            System.out.println(bean);
            stmt.setString(1,bean.getType());
            stmt.setDate(2,DBUtil.javaDateToSqlDate(bean.getStart()));
            stmt.setDate(3,DBUtil.javaDateToSqlDate(bean.getEnd()));
            stmt.setString(4,bean.getStatus());
            stmt.setInt(5,bean.getStu_id());
            //执行插入操作
            stmt.execute();

            //获取插入数据库后，自增的id
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                bean.setId(id);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void update(Holiday bean) {

    }

    public void delete(int id) {

    }

    public Holiday get(int id) {
        return null;
    }

    public List<Holiday> list() {
        return list(0,Short.MAX_VALUE);
    }

    public List<Holiday> list(int start,int end) {
        return null;
    }
}
