package controller;

import dao.impl.StudentDaoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Students;
import utils.AlertScreen;
import utils.GUI;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class StudentView implements Initializable {
    private  List<Students> list = StudentDaoImpl.list;
    public static String Object = null;
    @FXML
    private TextField Name;

    @FXML
    private AnchorPane StudentView;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (list.size()>0){
            Students students = list.get(0);
            Name.setText(students.getName());
        }else {
            AlertScreen.getMessageScreen("提示", "查询过程出现异常！！");
        }
    }

    public void exit(ActionEvent actionEvent) {
        if (list.size()>0){
            Students students = list.get(0);
            Boolean message = AlertScreen.getMessageScreen("提示", students.getName()+"  同学，您确定要退出考试系统吗？");
            if (message){
                Stage stage = (Stage)StudentView.getScene().getWindow();
                stage.close();
            }
        }else {
            AlertScreen.getMessageScreen("提示", "查询过程出现异常！！");
        }


    }

    public void ChineseButton(ActionEvent actionEvent) {
        String flag = "语文";
        Object = flag;
        System.out.println("语文考试");
        Boolean message = AlertScreen.getMessageScreen("提示", "确定要进入  "+flag+"  考试吗？");
        if (message){
            FXMLLoader loader = new GUI(new Stage(), "../view/StudentExam.fxml", "学生考试界面", 1190, 764,"语文").getLoader();
            Stage stage = (Stage)StudentView.getScene().getWindow();
            stage.close();
        }

    }

    public void EnglishButton(ActionEvent actionEvent) {
        String flag = "英语";
        Object = flag;
        System.out.println("英语考试");
        Boolean message = AlertScreen.getMessageScreen("提示", "确定要进入  "+flag+"  考试吗？");
        if (message){
            FXMLLoader loader = new GUI(new Stage(), "../view/StudentExam.fxml", "学生考试界面", 1190, 764,"英语").getLoader();
            Stage stage = (Stage)StudentView.getScene().getWindow();
            stage.close();
        }
    }

    public void MathButton(ActionEvent actionEvent) {
        String flag = "数学";
        Object = flag;
        System.out.println("数学考试");
        Boolean message = AlertScreen.getMessageScreen("提示", "确定要进入  "+flag+"  考试吗？");
        if (message){
            FXMLLoader loader = new GUI(new Stage(), "../view/StudentExam.fxml", "学生考试界面", 1190, 764,"数学").getLoader();
            Stage stage = (Stage)StudentView.getScene().getWindow();
            stage.close();
        }
    }


    public void HistoryButton(ActionEvent actionEvent) {
        String flag = "历史";
        Object = flag;
        System.out.println("历史考试");
        Boolean message = AlertScreen.getMessageScreen("提示", "确定要进入  "+flag+"  考试吗？");
        if (message){
            FXMLLoader loader = new GUI(new Stage(), "../view/StudentExam.fxml", "学生考试界面", 1190, 764,"历史").getLoader();
            Stage stage = (Stage)StudentView.getScene().getWindow();
            stage.close();
        }
    }

    public void MusicButton(ActionEvent actionEvent) {
        String flag = "音乐";
        Object = flag;
        System.out.println("音乐考试");
        Boolean message = AlertScreen.getMessageScreen("提示", "确定要进入  "+flag+"  考试吗？");
        if (message){
            FXMLLoader loader = new GUI(new Stage(), "../view/StudentExam.fxml", "学生考试界面", 1190, 764,"音乐").getLoader();
            Stage stage = (Stage)StudentView.getScene().getWindow();
            stage.close();
        }
    }

    public void ComputerButton(ActionEvent actionEvent) {
        String flag = "计算机";
        Object = flag;
        System.out.println("计算机考试");
        Boolean message = AlertScreen.getMessageScreen("提示", "确定要进入  "+flag+"  考试吗？");
        if (message){
            FXMLLoader loader = new GUI(new Stage(), "../view/StudentExam.fxml", "学生考试界面", 1190, 764,"计算机").getLoader();
            Stage stage = (Stage)StudentView.getScene().getWindow();
            stage.close();
        }
    }

    public void PolityButton(ActionEvent actionEvent) {
        String flag = "思政";
        Object = flag;
        System.out.println("思政考试");
        Boolean message = AlertScreen.getMessageScreen("提示", "确定要进入  "+flag+"  考试吗？");
        if (message){
            FXMLLoader loader = new GUI(new Stage(), "../view/StudentExam.fxml", "学生考试界面", 1190, 764,"思政").getLoader();
            Stage stage = (Stage)StudentView.getScene().getWindow();
            stage.close();
        }
    }



}

