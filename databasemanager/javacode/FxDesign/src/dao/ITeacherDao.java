package dao;

import model.Teacher;

import java.util.List;

public interface ITeacherDao {
    /**
     *查询教师信息
     * @return 集合
     */
    public List<Teacher> queryInformation();

    /**
     * 查询某个学生的信息
     * @param numberOrName 职工号或者姓名
     * @return 返回一个对象
     */
    public Teacher queryOnePerson(String numberOrName);

    /**
     * 删除教师
     * @param number 职工号
     * @return 返回一个int数字
     */
    public int deleteTeacher(String number);

    /**
     * 添加教师
     * @param tea
     * @return 返回一个int类型的数组
     */
    public int saveTeacher(Teacher tea);
    /**
     * 教师登录
     * @param number 账号
     * @return 返回字符串
     */
    public List<Teacher> teacherLogin(String number);


}
