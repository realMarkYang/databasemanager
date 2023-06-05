package test;

import dao.IQuestionDao;
import dao.impl.QuestionDaoImpl;
import model.Question;
import org.junit.Test;
import service.IQuestionService;

import java.util.List;

import static org.junit.Assert.*;

public class QuestionDaoImplTest {
private IQuestionDao dao = new QuestionDaoImpl();
    @Test
    public void getPaper() {
//        List<Question> list = dao.getPaper("英语");
//        Question question = list.get(0);
//        System.out.println(question);

        int r = dao.deleteObject("化学");
        System.out.println(r);
    }
}