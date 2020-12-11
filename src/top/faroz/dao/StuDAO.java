package top.faroz.dao;

import top.faroz.bean.Stu;
import top.faroz.utils.DBUtil;

import java.sql.*;
import java.util.List;

/**
 * @ClassName StuDAO
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/11/15 下午8:50
 * @Version 1.0
 **/
public class StuDAO extends DAO{
    /**
     * private int id;
     * private String name;
     * private String password;
     */


    /**
     * 获得数据库中学生的总个数
     * @return
     */
    public int getTotal() {
        int total=0;
        // 使用数据库中的聚合函数
        String sql = "select count(*) from stu";
        Connection conn = DBUtil.getConnection();
        ResultSet resultSet=null;
        try (Statement stmt = conn.createStatement()){
            resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                total=resultSet.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return total;
    }

    /**
     * 向数据库中插入学生信息
     * @param bean
     */
    public void add(Stu bean) {
        String sql = "insert into stu values(?,?,?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1,bean.getId());
            stmt.setString(2,bean.getName());
            stmt.setString(3,bean.getPassword());

            //插入数据
            stmt.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void update(Stu bean) {

    }

    public void delete(int id) {

    }

    public Stu get(int id) {
        Stu stu = null;
        String sql = "select * from stu where id=?";
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            // 如果没有查到对应的学生，就不会发生下一步，返回的就是null
            while (rs.next()) {
                int stu_id = rs.getInt(1);
                String stu_name = rs.getString(2);
                String stu_password = rs.getString(3);
                stu=new Stu();
                stu.setId(stu_id);
                stu.setName(stu_name);
                stu.setPassword(stu_password);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return stu;
    }

    public List<Stu> list() {
        return list(0,Short.MAX_VALUE);
    }

    public List<Stu> list(int start,int end) {
        return null;
    }
}
