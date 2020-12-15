package top.faroz.service;

import top.faroz.bean.Bill;
import top.faroz.bean.Holiday;
import top.faroz.bean.Sta;
import top.faroz.bean.StuSta;
import top.faroz.dao.HolidayDAO;
import top.faroz.dao.StuDAO;
import top.faroz.dao.StuStaDAO;
import top.faroz.domain.HolidayWithStuName;
import top.faroz.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName StuStaHolidayService
 * @Description service层，Dao层有些地方不管用了
 * 要使用多个dao层的方法才能完成需求
 * 故在这里设立service层
 * @Author FARO_Z
 * @Date 2020/12/14 下午7:52
 * @Version 1.0
 **/
public class TeacherHolidayService {
    /**
     * 通过教师id
     * 获取对应的所有学生的请假申请
     * 且这些假期的状态必须是待审核
     * @param teacherID
     * @return
     */
    public List<Holiday> getStudentHoliday(int teacherID) {
        StuStaDAO stuStaDAO = new StuStaDAO();
        HolidayDAO holidayDAO = new HolidayDAO();
        List<StuSta> list = stuStaDAO.list();
        List<Holiday> holidayList = holidayDAO.list();
        //存储该教师管理的学生
        Set<Integer> set = new HashSet<>();
        for (StuSta stuSta : list) {
            if (stuSta.getSta_id()==teacherID) {
                set.add(stuSta.getStu_id());
            }
        }

        List<Holiday> holidays = new ArrayList<>();
        for (Holiday holiday : holidayList) {
            //如果申请这个假期的学生，在该老师的管辖范围之内
            //且这个假期的状态是待审核
            if (set.contains(holiday.getStu_id()) &&
                holiday.getStatus().equals("underreview")) {
                holidays.add(holiday);
            }
        }
        return holidays;
    }

    /**
     * 获取带学生真实姓名的,教师管辖的，学生请假信息
     * @param teacherID
     * @return
     */
    public List<HolidayWithStuName> getHolidayWithStuName(int teacherID) {
        List<Holiday> holidays = getStudentHoliday(teacherID);
        List<HolidayWithStuName> holidayWithStuNames = new ArrayList<>();
        StuDAO stuDao = new StuDAO();
        for (Holiday holiday : holidays) {
            holidayWithStuNames.add(new HolidayWithStuName(holiday,stuDao
                    .get(holiday.getStu_id())
                    .getName()));
        }
        return holidayWithStuNames;
    }

    /**
     * 修改对应学生ID假期的状态（审核中  已拒绝  进行中）
     * @param stuID
     */
    public void changeHolidayStatus(int stuID,String status) {
        HolidayDAO holidayDAO = new HolidayDAO();
        // <<====不能使用getByStuId,因为会有多个相同StudentID
        // Holiday holiday = holidayDAO.getByStuID(stuID);

        //要通过list筛选，找出对应学生申请的假期，且假期必须是underreview状态的
        Holiday target=null;
        List<Holiday> list = holidayDAO.list();
        for (Holiday h : list) {
            if (h.getStu_id()==stuID && h.getStatus().equals("underreview")) {
                target=h;
            }
        }
        if (target==null) return;//防止空指针异常

        if ("reject".equals(status)) {
            target.setStatus("reject");
        } else if ("agree".equals(status)) {
            target.setStatus("undergoing");
        }
        // System.out.println(holiday.toString());
        holidayDAO.update(target);
    }

    /**
     * 删除数据库表中
     * 有指定学生id和指定教师id的数据
     * @param stuId
     * @param staID
     */
    public void deleteFromStuSta(int stuId,int staID) {
        String sql = "delete from stu_sta where stu_id=? and sta_id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1,stuId);
            stmt.setInt(2, staID);
            stmt.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
