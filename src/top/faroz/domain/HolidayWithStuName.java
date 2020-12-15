package top.faroz.domain;

import top.faroz.bean.Holiday;

import java.sql.PreparedStatement;

/**
 * @ClassName HolidayWithStuName
 * @Description 为了教师端
 * 显示学生的真实姓名使用
 * @Author FARO_Z
 * @Date 2020/12/14 下午8:37
 * @Version 1.0
 **/
public class HolidayWithStuName {
    public Holiday holiday;
    public String stuName;

    public HolidayWithStuName(Holiday holiday, String stuName) {
        this.holiday = holiday;
        this.stuName = stuName;
    }

    public Holiday getHoliday() {
        return holiday;
    }

    public void setHoliday(Holiday holiday) {
        this.holiday = holiday;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }
}
