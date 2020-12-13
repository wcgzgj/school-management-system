package top.faroz.dao;

import top.faroz.bean.Sta;
import top.faroz.utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName StaDAO
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/11/15 下午8:50
 * @Version 1.0
 **/
public class StaDAO extends DAO{
    /**
     *  private int id;
     *  private String name;
     *  private String password;
     */
    public int getTotal() {
        int total=0;
        // 使用数据库中的聚合函数
        String sql = "select count(*) from sta";
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
     * 向数据库中插入教师信息
     * @param bean
     */
    public void add(Sta bean) {
        String sql = "insert into sta values(?,?,?)";
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

    public void update(Sta bean) {

    }

    public void delete(int id) {

    }

    public Sta get(int id) {
        Sta sta = null;
        String sql = "select * from sta where id=?";
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            // 如果没有查到对应的学生，就不会发生下一步，返回的就是null
            while (rs.next()) {
                int sta_id = rs.getInt(1);
                String sta_name = rs.getString(2);
                String sta_password = rs.getString(3);
                sta=new Sta();
                sta.setId(sta_id);
                sta.setName(sta_name);
                sta.setPassword(sta_password);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return sta;
    }

    /**
     * 获取数据库中所有行的数据
     * @return
     */
    public List<Sta> list() {
        String sql = "select * from sta";
        List<Sta> list = new ArrayList<>();
        Connection conn = DBUtil.getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Sta sta = new Sta();
                sta.setId(rs.getInt(1));
                sta.setName(rs.getString(2));
                sta.setPassword(rs.getString(3));
                list.add(sta);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public List<Sta> list(int start,int end) {
        return null;
    }
}
