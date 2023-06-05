package controller;

import dao.impl.StudentDaoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Question;
import model.Students;
import model.Teacher;
import service.IQuestionService;
import service.IStudentService;
import service.ITeacherService;
import service.impl.QuestionServiceImpl;
import service.impl.StudentServiceImpl;
import service.impl.TeacherServiceImpl;
import utils.AlertScreen;

import java.net.URL;
import java.util.*;

public class StudentExam implements Initializable {
    private IStudentService studentService = new StudentServiceImpl();
    private IQuestionService questionService = new QuestionServiceImpl();
    private ITeacherService teacherService = new TeacherServiceImpl();
    private String objectName = StudentView.Object;
    private List<Students> list = StudentDaoImpl.list;
    private List<Teacher> TList = new LinkedList<>();
    private String flag = null;
    private int index = 0;
    private String answer = "";
    private int score = 0;
    private  List<Question> list1 = new ArrayList<>(questionService.getPaper(objectName));

    @FXML
    private TextField Title,teacherName,teacherPhone,studentNumber,studentName,studentClassRoom;

    @FXML
    private TextArea content;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Title.setText("   "+objectName+"   考试");
        Students students = list.get(0);
        studentName.setText(students.getName());
        studentNumber.setText(students.getNumber());
        studentClassRoom.setText(students.getClassRoom());
        List<Teacher> list = teacherService.queryInformation();
        for (Teacher tea:list) {
            if (tea.getTask().contains(objectName)){
                TList.add(tea);
            }
        }
        for (Teacher tea:TList) {
            if (tea.getTask().contains(students.getClassRoom())){
                teacherName.setText(tea.getName());
                teacherPhone.setText(tea.getPhone());
            }
        }

        Question question = list1.get(index);
        String title = question.getTitle().replace("<br>","\n   ");
        content.setText(title);
    }

    public void lastButton(ActionEvent actionEvent) {
        Random random = new Random();
        int pos = random.nextInt(13);
        int count = 1;
        while (count<5){
            if (pos<=list1.size()){
                Question question = list1.get(index);
                String title = question.getTitle().replace("<br>","\n   ");
                content.setText(title);
                count++;
                index++;
            }else {
                pos = random.nextInt(13);
            }
        }
        content.setText("                               题    库    刷    新！    ");
    }

    public void okButton(ActionEvent actionEvent) {
        Boolean message = AlertScreen.getMessageScreen("提示", "试卷只能提交一次,确定要交卷吗？");

        if (message){
            content.setText("                                      答      题    结      束！"+"\n\t" +
                    "          答案为："+answer);
            String s = studentService.g_update(list.get(0).getNumber(), objectName, String.valueOf(score));
            if ("成功".equals(s)){
                AlertScreen.getMessageScreen("提示", "您的最终分数为: "+score);
            }else {
                AlertScreen.getMessageScreen("提示", "结算出现异常！请联系管理员！");
            }
        }


    }

    public void nextButton(ActionEvent actionEvent) {
        if (index>=1){
            int i = 1;
            index--;
            Question question = list1.get(index);
            String title = question.getTitle().replace("<br>","\n   ");
            content.setText(title);
            if (question.getAnswer().equals(flag)){
                score+=25;
                flag = null;
            }
            answer = answer.concat(i+"."+question.getAnswer()+"   ");
            i++;
        }else {
            AlertScreen.getMessageScreen("提示", "本题为最后一题！");
        }

    }


    public void ChooseA(MouseEvent event) {
        flag = "A";
    }

    public void ChooseB(MouseEvent event) {
        flag = "B";
    }

    public void ChooseC(MouseEvent event) {
        flag = "C";
    }

    public void ChooseD(MouseEvent event) {
        flag = "D";
    }



}
