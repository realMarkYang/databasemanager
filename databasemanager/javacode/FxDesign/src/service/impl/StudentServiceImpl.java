package service.impl;

import dao.IStudentDao;
import dao.impl.StudentDaoImpl;
import model.Students;
import service.IStudentService;

import java.util.List;

public class StudentServiceImpl implements IStudentService {
    private IStudentDao dao = new StudentDaoImpl();
    private String result = "失败";

    /**
     * 查询学生信息
     *
     * @return 集合
     */
    @Override
    public List<Students> queryInformation() {
        List<Students> list = dao.queryInformation();
        return list;
    }

    /**
     * 查询某个学生的信息
     *
     * @param number 学号
     * @return 返回一个对象
     */
    @Override
    public Students queryOnePerson(String number) {
        return dao.queryOnePerson(number);
    }

    /**
     * 删除学生
     *
     * @param number 学号
     * @return 返回一个字符串
     */
    @Override
    public String deleteStudent(String number) {
        int i = dao.deleteStudent(number);
        if (i>0){
            result = "成功";
        }
        return result;
    }

    /**
     * 添加学生
     *
     * @param stu
     * @return 返回一个字符串
     */
    @Override
    public String saveStudent(Students stu) {
        int a = dao.saveStudent(stu);
        if (a == 999){
            result = "学号已存在";
        }else if (a == 888){
            result = "班级不存在";
        } else {
            result = "添加成功";
        }
        return result;
    }

    /**
     * 学生登录
     *
     * @param number   账号
     * @param password 密码
     * @return 返回一个字符串
     */
    @Override
    public String studentLogin(String number, String password) {
        List<Students> list = dao.studentLogin(number);
        if (list.size()>0){
            result = "成功";
        }
        return result;
    }

    /**
     * 更新学生信息
     *
     * @param number 学号
     * @param object 学科
     * @param score  分数
     * @return 返回一个字符串
     */
    @Override
    public String g_update(String number, String object, String score) {
        int i = dao.g_Update(number, object, score);
        if (i>0){
            result = "成功";
        }
        return result;
    }


}
