package test;

import dao.IStudentDao;
import dao.impl.StudentDaoImpl;
import model.Students;
import org.junit.Test;

import java.util.List;


public class StudentDaoImplTest {
    private IStudentDao dao = new StudentDaoImpl();
    @Test
    public void queryInformation() {

//        List<Students> list = dao.queryInformation();
//
//        for (Students s:
//             list) {
//            System.out.println(s);
//        }


//        List<Students> list = dao.studentLogin("1915925003");
//        for (Students s:
//             list) {
//            System.out.println(s);
//        }


        int g_chinese = dao.g_Update("1915925003", "语文", "90");
        System.out.println(g_chinese);
    }
}