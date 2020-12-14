package top.faroz.dao;

import com.sun.org.apache.regexp.internal.RE;
import top.faroz.bean.Holiday;
import top.faroz.utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
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
        /**
         *     private int id; //自增id
         *     private String type; //请假类型 "事假 临时假条..."
         *     private Date start; //开始时间
         *     private Date end; //结束时间
         *     private String status; //状态 "审核中  假期中  已销假"
         *     private int stu_id; //申请该假的学生id
         */
        String sql = "update holiday set type=?,start=?,end=?,status=?,stu_id=? where id=?";
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1,bean.getType());
            stmt.setDate(2,DBUtil.javaDateToSqlDate(bean.getStart()));
            stmt.setDate(3,DBUtil.javaDateToSqlDate(bean.getEnd()));
            stmt.setString(4,bean.getStatus());
            stmt.setInt(5,bean.getStu_id());
            stmt.setInt(6,bean.getId());

            stmt.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void delete(int id) {
        String sql = "delete from holiday where id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,id);
            //执行删除操作
            stmt.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Holiday get(int id) {
        String sql = "select * from holiday where id=?";
        Holiday holiday=null;
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                /**
                 *     private int id; //自增id
                 *     private String type; //请假类型 "事假 临时假条..."
                 *     private Date start; //开始时间
                 *     private Date end; //结束时间
                 *     private String status; //状态 "审核中  假期中  已销假"
                 *     private int stu_id; //申请该假的学生id
                 */
                holiday=new Holiday();
                holiday.setId(id);
                holiday.setType(rs.getString(2));
                holiday.setStart(DBUtil.sqlDateToJavaDate(rs.getDate(3)));
                holiday.setEnd(DBUtil.sqlDateToJavaDate(rs.getDate(4)));
                holiday.setStatus(rs.getString(5));
                holiday.setStu_id(rs.getInt(6));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return holiday;
    }

    public List<Holiday> list() {
        List<Holiday> list = new ArrayList<>();
        Connection conn = DBUtil.getConnection();
        String sql = "select * from holiday";
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                /**
                 *     private int id; //假期编号
                 *     private String type; //请假类型 "事假 临时假条..."
                 *     private Date start; //开始时间
                 *     private Date end; //结束时间
                 *     private String status; //状态 "审核中  假期中  已销假"
                 *     private int stu_id; //申请该假的学生id
                 */
                Holiday holiday = new Holiday();
                holiday.setId(rs.getInt(1));
                holiday.setType(rs.getString(2));
                holiday.setStart(DBUtil.sqlDateToJavaDate(rs.getDate(3)));
                holiday.setEnd(DBUtil.sqlDateToJavaDate(rs.getDate(4)));
                holiday.setStatus(rs.getString(5));
                holiday.setStu_id(rs.getInt(6));
                list.add(holiday);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public List<Holiday> list(int start,int end) {
        return null;
    }
}
