package dao.impl;

//import com.oracle.tools.packager.JreUtils;
import dao.IStudentDao;
import handler.IResultSetHandler;
import model.Students;
import utils.JDBCTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class StudentDaoImpl implements IStudentDao {
    private int result = 0;
    public static List<Students> list = new LinkedList<Students>();

    /**
     * 查询同学信息
     *
     * @return
     */
    @Override
    public List<Students> queryInformation() {
        JDBCTemplate.updateData("update grade set g_sum=IFNULL(g_Chinese,0)+" +
                "IFNULL(g_math,0)+IFNULL(g_english,0)+IFNULL(g_Computer,0)+IFNULL(g_history,0)+" +
                "IFNULL(g_music,0)+IFNULL(g_polity,0),g_avg=g_sum/7");
        list = JDBCTemplate.query("select * from students s\n" +
                        " JOIN  grade g\n" +
                        "WHERE s.number = g.number"
                       , new StudentResultSetHandler());
        return list;
    }

    /**
     * 查询某个学生的信息
     *
     * @param number 学号
     * @return 返回一个students对象
     */
    @Override
    public Students queryOnePerson(String number) {
        list = JDBCTemplate.query("select * from students s\n" +
                        " JOIN  grade g\n" +
                        "WHERE s.number = g.number and s.number = ?",
                new StudentResultSetHandler(), number);
        return list.size() > 0 ? list.get(0) : null;
    }

    /**
     * 删除学生
     *
     * @param number 学号
     * @return 返回一个int数字
     */
    @Override
    public int deleteStudent(String number) {
//        return JDBCTemplate.updateData("delete  from students s\n" +
//                        " JOIN  grade g\n" +
//                        "WHERE s.number = g.number and s.number = ?",number);
        JDBCTemplate.updateData( "delete from grade \n" +
                "WHERE number = ?;",number);
        return JDBCTemplate.updateData("delete from students\n" +
                "WHERE number = ?;\n",number);
    }

    /**
     * 添加学生
     *
     * @param stu
     * @return 返回一个int类型的数组
     */
    @Override
    public int saveStudent(Students stu) {
        list = JDBCTemplate.query("select * from students s join grade g where s.number = ?", new StudentResultSetHandler(),
                stu.getNumber());
        if (list.size() <= 0) {
            List<Students> list2 = JDBCTemplate.query("select * from students s join grade g where  s.classroom = ?", new StudentResultSetHandler(),
                    stu.getClassRoom());
            if (list2.size() == 0){
                result = 888;
            }else {
                Students students = list2.get(0);
                stu.setChinese_date_place(students.getChinese_date_place());
                stu.setMath_date_place(students.getMath_date_place());
                stu.setEnglish_date_place(students.getEnglish_date_place());
                result = JDBCTemplate.updateData("insert into students (name,gender,classroom,number,password," +
                        "Chinese_date_place,math_date_place,english_date_place) Values(?,?,?,?,?,?,?,?)",
                        stu.getName(),stu.getGender(),stu.getClassRoom(),stu.getNumber(),stu.getPassword(),
                        stu.getChinese_date_place(),stu.getMath_date_place(),stu.getEnglish_date_place());
                JDBCTemplate.updateData("insert into grade (number,g_Chinese,g_math,g_english,g_polity,g_music," +
                        "g_history,g_computer,g_sum,g_avg) values(?,?,?,?,?,?,?,?,?,?)",
                        stu.getNumber(),null,null,null,null,null,null,null,null,null);
            }
        } else {
            result = 999;
        }
        return result;
    }

    /**
     * 学生登录
     *
     * @param number   账号
     * @return 返回字符串
     */
    @Override
    public List<Students> studentLogin(String number) {
            list =  JDBCTemplate.query("select * from students s\n" +
                            " JOIN  grade g\n" +
                            "WHERE s.number = g.number and s.number = ?",
                new StudentResultSetHandler(),number);
            return list;

    }

    /**
     * 成绩更新
     *
     * @param number 学号
     * @param object 学科
     * @param score  成绩
     * @return 返回int类型数字
     */
    @Override
    public int g_Update(String number, String object, String score) {
        if ("语文".equals(object)){
            return JDBCTemplate.updateData("update grade set g_Chinese = ? Where number = ?",
                    score,number);
        }else if ("数学".equals(object)){
            return JDBCTemplate.updateData("update grade set g_math = ? Where number = ?",
                    score,number);
        }else if("英语".equals(object)){
            return JDBCTemplate.updateData("update grade set g_english = ? Where number = ?",
                    score,number);
        }else if("音乐".equals(object)){
            return JDBCTemplate.updateData("update grade set g_music = ? Where number = ?",
                    score,number);
        }else if ("历史".equals(object)){
            return JDBCTemplate.updateData("update grade set g_history = ? Where number = ?",
                    score,number);
        }else if("思政".equals(object)){
            return JDBCTemplate.updateData("update grade set g_polity = ? Where number = ?",
                    score,number);
        }else{
            return JDBCTemplate.updateData("update grade set g_computer = ? Where number = ?",
                    score,number);
        }

    }
}

class StudentResultSetHandler implements IResultSetHandler<List<Students>> {

    @Override
    public List<Students> Handler(ResultSet res) throws SQLException {
        List<Students> list = new LinkedList<Students>();
        while (res.next()) {
            String name = res.getString("name");
            String gender = res.getString("gender");
            String classRoom = res.getString("classroom");
            String number = res.getString("number");
            String password = res.getString("password");
            double g_chinese = res.getDouble("g_Chinese");
            double g_math = res.getDouble("g_math");
            double g_english = res.getDouble("g_english");
            double g_computer = res.getDouble("g_computer");
            double g_polity = res.getDouble("g_polity");
            double g_history = res.getDouble("g_history");
            double g_music = res.getDouble("g_music");
            double g_sum = res.getDouble("g_sum");
            double g_avg = res.getDouble("g_avg");
            String chinese_date_place = res.getString("chinese_date_place");
            String math_date_place = res.getString("math_date_place");
            String english_date_place = res.getString("english_date_place");
            Students stu = new Students(name, gender, classRoom, number, password,
                    g_chinese, g_math, g_english, g_history, g_music, g_computer, g_polity,g_sum, g_avg,
                    chinese_date_place,math_date_place,english_date_place);
            list.add(stu);
        }
        return list;
    }
}