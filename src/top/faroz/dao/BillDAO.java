package top.faroz.dao;

import top.faroz.bean.Bill;
import top.faroz.utils.DBUtil;

import java.sql.*;
import java.util.List;

/**
 * @ClassName BillDao
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/11/15 下午8:50
 * @Version 1.0
 **/
public class BillDAO {
    /**
     * private int id;
     *     private String reason;
     *     private float money;
     *     private String status;
     *     private int stu_id;
     */

    /**
     * 获取数据条数
     * @return
     */
    public int getTotal() {
        int total=0;
        String sql = "select count(*) from bill";
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

    public void add(Bill bean) {
        String sql = "insert into bill values(null,?,?,?,?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1,bean.getReason());
            stmt.setFloat(2,bean.getMoney());
            stmt.setString(3,bean.getStatus());
            stmt.setInt(4,bean.getStu_id());

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
