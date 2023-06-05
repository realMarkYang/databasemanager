package dao;

import model.Students;

import java.util.List;

public interface IStudentDao {
    /**
     * 查询同学信息
     * @return
     */
    public List<Students> queryInformation();

    /**
     * 查询某个学生的信息
     * @param number 学号
     * @return 返回一个students对象
     */
    public Students queryOnePerson(String number);

    /**
     * 删除学生
     * @param number 学号
     * @return 返回一个int数字
     */
    public int deleteStudent(String number);

    /**
     * 添加学生
     * @param stu
     * @return 返回一个int类型的数组
     */
    public int saveStudent(Students stu);

    /**
     * 学生登录
     * @param number 账号
     * @return 返回字符串
     */
    public List<Students> studentLogin(String number);

    /**
     * 成绩更新
     * @param number 学号
     * @param object 学科
     * @param score 成绩
     * @return 返回int类型数字
     */
    public int g_Update(String number,String object,String score);

}
