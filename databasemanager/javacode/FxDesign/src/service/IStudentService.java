package service;

import javafx.collections.ObservableList;
import model.Students;

import java.util.List;

public interface IStudentService {
    /**
     *查询学生信息
     * @return 集合
     */
    public List<Students> queryInformation();

    /**
     * 查询某个学生的信息
     * @param number 学号
     * @return 返回一个对象
     */
    public Students queryOnePerson(String number);

    /**
     * 删除学生
     * @param number 学号
     * @return 返回一个字符串
     */
    public String deleteStudent(String number);

    /**
     * 添加学生
     * @param stu
     * @return 返回一个字符串
     */
    public String saveStudent(Students stu);

    /**
     * 学生登录
     * @param number 账号
     * @param password 密码
     * @return 返回一个字符串
     */
    public String studentLogin(String number,String password);

    /**
     * 更新学生信息
     * @param number 学号
     * @param object 学科
     * @param score 分数
     * @return 返回一个字符串
     */
    public String g_update(String number,String object,String score);
}
