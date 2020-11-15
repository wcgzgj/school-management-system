package top.faroz.dao;

import top.faroz.bean.Stu;
import top.faroz.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName StuDAO
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/11/15 下午8:50
 * @Version 1.0
 **/
public class StuDAO {
    public int getTotal() {
        int total=0;


        return total;
    }

    public void add(Stu bean) {
        String sql = "";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {




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

    public void update(Stu bean) {

    }

    public void delete(int id) {

    }

    public Stu get(int id) {
        return null;
    }

    public List<Stu> list() {
        return list(0,Short.MAX_VALUE);
    }

    public List<Stu> list(int start,int end) {
        return null;
    }
}
