package top.faroz.dao;

import top.faroz.bean.Bill;
import top.faroz.bean.Stu;
import top.faroz.bean.StuSta;
import top.faroz.utils.DBUtil;

import java.sql.*;
import java.util.List;

/**
 * @ClassName StuStaDAO
 * @Description StuSta 数据库DAO层
 * @Author FARO_Z
 * @Date 2020/12/13 下午12:43
 * @Version 1.0
 **/
public class StuStaDAO {
    /**
     * private int id;
     * private int stu_id;
     * private int sta_id;
     */
    /**
     * 通过stuid获取对象
     * @return
     */
    public StuSta getByStu(int id) {
        Connection conn = DBUtil.getConnection();
        String sql = "select * from stu_sta where stu_id=?";
        StuSta stuSta = null;
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                stuSta=new StuSta();
                //从2开始，因为前面还有一个自增id
                stuSta.setStu_id(rs.getInt(2));
                stuSta.setSta_id(rs.getInt(3));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return stuSta;
    }

    public StuSta getBySta(int id) {
        Connection conn = DBUtil.getConnection();
        String sql = "select * from stu_sta where sta_id=?";
        StuSta stuSta = null;
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                stuSta=new StuSta();
                //从2开始，因为前面还有一个自增id
                stuSta.setStu_id(rs.getInt(2));
                stuSta.setSta_id(rs.getInt(3));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return stuSta;
    }

    public int getTotal() {
        int total=0;
        String sql = "select count(*) from stu_sta";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                total=rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return total;
    }

    public void add(StuSta bean) {
        String sql = "insert into stu_sta values(null,?,?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1,bean.getStu_id());
            stmt.setInt(2,bean.getSta_id());
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

    public void update(Bill bean) {

    }

    public void delete(int id) {

    }

    /**
     * 通过学生信息删除
     */
    public void deleteByStuId(int id) {
        String sql = "delete from stu_sta where stu_id=?";
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1,id);
            stmt.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Bill get(int id) {
        return null;
    }

    public List<Bill> list() {
        return list(0,Short.MAX_VALUE);
    }

    public List<Bill> list(int start,int end) {
        return null;
    }
}
