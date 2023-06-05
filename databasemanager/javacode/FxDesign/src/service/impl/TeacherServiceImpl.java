package service.impl;

import dao.ITeacherDao;
import dao.impl.TeacherDaoImpl;

import model.Teacher;
import service.ITeacherService;

import java.util.List;

public class TeacherServiceImpl implements ITeacherService {
    private ITeacherDao dao = new TeacherDaoImpl();
    private String result = null;
    /**
     * 查询教师信息
     *
     * @return 集合
     */
    @Override
    public List<Teacher> queryInformation() {
        return dao.queryInformation();
    }

    /**
     * 查询某个学生的信息
     *
     * @param numberOrName 职工号或者姓名
     * @return 返回一个对象
     */
    @Override
    public Teacher queryOnePerson(String numberOrName) {
        return dao.queryOnePerson(numberOrName);
    }

    /**
     * 删除教师
     *
     * @param number 职工号
     * @return 返回一个字符串
     */
    @Override
    public String deleteTeacher(String number) {
        int i = dao.deleteTeacher(number);
        if (i>0){
            result = "成功";
        }
      return result;
    }

    /**
     * 添加教师
     *
     * @param tea 学生对象
     * @return 返回一个字符串
     */
    @Override
    public String saveTeacher(Teacher tea) {
        int a = dao.saveTeacher(tea);
        if (a == 999){
            result = "职工号已存在";
        }else {
            result = "添加成功";
        }
        return result;
    }

    /**
     * 教师登录
     *
     * @param number   账号
     * @param password 密码
     * @return 返回一个字符串
     */
    @Override
    public String teacherLogin(String number, String password) {
        List<Teacher> list = dao.teacherLogin(number);
        if (list.size()>0){
            result = "成功";
        }
        return result;
    }


}
