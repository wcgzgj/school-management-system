package top.faroz.service;

import top.faroz.bean.Bill;
import top.faroz.bean.Stu;
import top.faroz.bean.StuStaBill;
import top.faroz.dao.BillDAO;
import top.faroz.dao.StuDAO;
import top.faroz.dao.StuStaBillDAO;
import top.faroz.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * @ClassName TeacherBillService
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/12/15 下午1:00
 * @Version 1.0
 **/
public class TeacherBillService {
    public List<Bill> getStuBill(int staID) {
        StuStaBillDAO stuStaBillDAO = new StuStaBillDAO();
        List<StuStaBill> list = stuStaBillDAO.list();
        //因为可能会出现重复数据，所以使用set存储
        Set<Integer> set = new HashSet<>(); // <==获取教师管辖的学生
        // <==获取教师管辖的学生
        for (StuStaBill stuStaBill : list) {
            if (stuStaBill.getSta_id()==staID) {
                set.add(stuStaBill.getStu_id());
            }
        }

        //存储，教师管辖的，学生申请的，还在审核阶段的申报金额
        List<Bill> bills = new ArrayList<>();

        BillDAO billDAO = new BillDAO();
        List<Bill> billDaoList = billDAO.list();
        for (Bill bill : billDaoList) {
            if (set.contains(bill.getStu_id()) &&
                bill.getStatus().equals("underreview")) {
                bills.add(bill);
            }
        }
        return bills;
    }

    /**
     * 获取数据库中，所有对应学号的学生姓名的hash表
     * @return
     */
    public Map<Integer,String> getStuNameMap() {
        StuDAO stuDAO = new StuDAO();
        List<Stu> list = stuDAO.list();

        Map<Integer, String> map = new HashMap<>();
        for (Stu stu : list) {
            map.put(stu.getId(),stu.getName());
        }
        return map;
    }

    /**
     * 删除数据库表中
     * 有指定学生id和指定教师id的数据
     *
     * 但是，只会删除一条数据
     * 就相当于，将数据表当做栈来使用了
     * @param stuId
     * @param staID
     */
    public void deleteFromStuSta(int stuId,int staID) {
        StuStaBill stuStaBill = getOneByStuSta(stuId, staID);
        StuStaBillDAO dao = new StuStaBillDAO();
        dao.delete(stuStaBill.getId());
    }

    public void changeBillStatus(int billID,String status) {
        BillDAO billDAO = new BillDAO();
        Bill bill = billDAO.get(billID);
        bill.setStatus(status);
        billDAO.update(bill);
    }

    public StuStaBill getOneByStuSta(int stuID,int staID) {
        String sql = "select * from stu_sta_bill where stu_id=? and sta_id=?";
        StuStaBill stuStaBill=null;
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1,stuID);
            stmt.setInt(2,staID);

            ResultSet rs = stmt.executeQuery();
            //只取出一条数据！！！
            if (rs.next()) {
                stuStaBill = new StuStaBill();
                stuStaBill.setId(rs.getInt(1));
                stuStaBill.setStu_id(rs.getInt(2));
                stuStaBill.setSta_id(rs.getInt(3));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return stuStaBill;
    }
}
