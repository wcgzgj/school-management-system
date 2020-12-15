package top.faroz.dao;

import top.faroz.bean.Bill;
import top.faroz.utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BillDao
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/11/15 下午8:50
 * @Version 1.0
 **/
public class BillDAO extends DAO{
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
        /**
         *     private int id;
         *     private String reason;
         *     private float money;
         *     private String status;
         *     private int stu_id;
         */
        String sql = "update bill set reason=?,money=?,status=?,stu_id=? where id=?";
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1,bean.getReason());
            stmt.setFloat(2,bean.getMoney());
            stmt.setString(3,bean.getStatus());
            stmt.setInt(4,bean.getStu_id());
            stmt.setInt(5,bean.getId());

            stmt.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(int id) {

    }

    public Bill get(int id) {
        String sql = "select * from bill where id=?";
        Bill bill=null;
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                bill = new Bill();
                bill.setId(id);
                bill.setReason(rs.getString(2));
                bill.setMoney(rs.getFloat(3));
                bill.setStatus(rs.getString(4));
                bill.setStu_id(rs.getInt(5));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bill;
    }

    public List<Bill> list() {
        List<Bill> list = new ArrayList<>();
        String sql = "select * from bill";
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Bill bill = new Bill();
                bill.setId(rs.getInt(1));
                bill.setReason(rs.getString(2));
                bill.setMoney(rs.getFloat(3));
                bill.setStatus(rs.getString(4));
                bill.setStu_id(rs.getInt(5));
                list.add(bill);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public List<Bill> list(int start,int end) {
        return null;
    }
}
