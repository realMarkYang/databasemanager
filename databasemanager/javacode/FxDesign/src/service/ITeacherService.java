package service;


import model.Teacher;

import java.util.List;

public interface ITeacherService {
    /**
     *查询教师信息
     * @return 集合
     */
    public List<Teacher> queryInformation();

    /**
     * 查询某个教师的信息
     * @param numberOrName 职工号或者姓名
     * @return 返回一个对象
     */
    public Teacher queryOnePerson(String numberOrName);

    /**
     * 删除教师
     * @param number 职工号
     * @return 返回一个字符串
     */
    public String deleteTeacher(String number);
    /**
     * 添加教师
     * @param tea 学生对象
     * @return 返回一个字符串
     */
    public String saveTeacher(Teacher tea);
    /**
     * 教师登录
     * @param number 账号
     * @param password 密码
     * @return 返回一个字符串
     */
    public String teacherLogin(String number,String password);
}
