package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Question;
import service.IQuestionService;
import service.impl.QuestionServiceImpl;
import utils.AlertScreen;
import utils.GUI;

import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;

public class ObjectView implements Initializable {
    private IQuestionService questionService = new QuestionServiceImpl();

    @FXML
    private AnchorPane ObjectView;

    @FXML
    private TextArea content;

    @FXML
    private TextField Title;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        HashSet<Question> paper = questionService.getPaper(QuestionControl.name);
        Title.setText("            "+QuestionControl.name);
        String contentAll = "";
        for (Question q :
                paper) {
            String title = q.getTitle().replace("<br>","\n   ");
            contentAll = contentAll.concat("\n\t"+title+"\n\t");
        }
        content.setText(contentAll);
    }

    public void okButton(ActionEvent actionEvent) {
        Boolean messageScreen = AlertScreen.getMessageScreen("提示", "确定要要修改题库吗？");
        if (messageScreen){
            String text = content.getText();
            String s = questionService.updateQuestion(QuestionControl.name, text);
            if ("成功".equals(s)){
                AlertScreen.getMessageScreen("确定", "修改成功！");
            }else {
                AlertScreen.getMessageScreen("确定", "系统出现异常,修改失败！");
            }
        }
    }

    public void lastButton(ActionEvent actionEvent) {
        Boolean messageScreen = AlertScreen.getMessageScreen("提示", "确定要返回题库管理界面吗？");
        if (messageScreen) {
            FXMLLoader loader = new GUI(new Stage(), "../view/QuestionControl.fxml", "题库管理界面", 1543, 787,null).getLoader();
            Stage stage = (Stage) ObjectView.getScene().getWindow();
            stage.close();
            System.out.println("进入学生界面");
        }
    }



}
