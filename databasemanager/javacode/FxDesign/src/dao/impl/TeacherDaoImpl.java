package dao.impl;

import dao.ITeacherDao;
import handler.IResultSetHandler;
import model.Teacher;
import utils.JDBCTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class TeacherDaoImpl implements ITeacherDao {
    private int result = 0;

    /**
     * 查询教师信息
     *
     * @return 集合
     */
    @Override
    public List<Teacher> queryInformation() {
        return JDBCTemplate.query("select * from teacher",
                new TeacherResultSetHandler());
    }

    /**
     * 查询某个学生的信息
     *
     * @param numberOrName 职工号或者姓名
     * @return 返回一个对象
     */
    @Override
    public Teacher queryOnePerson(String numberOrName) {
        List<Teacher> list = JDBCTemplate.query("select * from teacher where number = ? or name = ?",
                new TeacherResultSetHandler(), numberOrName, numberOrName);
        return list.get(0);
    }

    /**
     * 删除教师
     *
     * @param number 职工号
     * @return 返回一个int数字
     */
    @Override
    public int deleteTeacher(String number) {
        return JDBCTemplate.updateData("delete from teacher where number = ?",
                number);
    }

    /**
     * 添加教师
     *
     * @param tea
     * @return 返回一个int类型的数组
     */
    @Override
    public int saveTeacher(Teacher tea) {
        List<Teacher> list1 = JDBCTemplate.query("select * from teacher where number = ?", new TeacherResultSetHandler(),
                tea.getNumber());
        if (list1.size() <= 0) {

            result = JDBCTemplate.updateData("insert into teacher (name,gender,number,password,phone)" +
                            " Values(?,?,?,?,?)", tea.getName(), tea.getGender(), tea.getNumber(),
                    "123456", tea.getPhone());
        } else {
            result = 999;
        }
        return result;
    }

    /**
     * 教师登录
     *
     * @param number 账号
     * @return 返回字符串
     */
    @Override
    public List<Teacher> teacherLogin(String number) {
        return JDBCTemplate.query("select * from teacher where number = ?",
                new TeacherResultSetHandler(), number);

    }


}

class TeacherResultSetHandler implements IResultSetHandler<List<Teacher>>{
    @Override
    public List<Teacher> Handler(ResultSet res) throws SQLException {
        List<Teacher> list = new LinkedList<Teacher>();
        while (res.next()){
            String name = res.getString("name");
            String number = res.getString("number");
            String gender = res.getString("gender");
            String phone = res.getString("phone");
            String task = res.getString("room_date_object");
            Teacher tea = new Teacher(name,number,gender,phone,task);
            list.add(tea);
        }
        return list;
    }
}
