package top.faroz.dao;

import top.faroz.bean.Holiday;
import top.faroz.bean.StuStaBill;
import top.faroz.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName StuStaBillDAO
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/12/14 下午1:26
 * @Version 1.0
 **/
public class StuStaBillDAO {
    public int getTotal() {
        int total=0;


        return total;
    }

    public void add(StuStaBill bean) {
        String sql = "insert into stu_sta_bill values(null,?,?)";
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1,bean.getStu_id());
            stmt.setInt(2,bean.getSta_id());
            stmt.execute();
            ResultSet keys = stmt.getGeneratedKeys();
            if (keys.next()) {
                int key = keys.getInt(1);
                bean.setId(key);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void update(StuStaBill bean) {

    }

    public void delete(int id) {

    }

    public Holiday get(int id) {
        return null;
    }

    public List<StuStaBill> list() {
        return null;
    }

    public List<StuStaBill> list(int start,int end) {
        return null;
    }
}
