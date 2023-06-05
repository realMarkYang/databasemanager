package test;

import dao.ITeacherDao;
import dao.impl.TeacherDaoImpl;
import model.Teacher;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TeacherDaoImplTest {
private ITeacherDao dao = new TeacherDaoImpl();
    @Test
    public void queryInformation() {
        List<Teacher> list = dao.queryInformation();
        for (Teacher tea:
             list) {
            System.out.println(tea);
        }
    }
}