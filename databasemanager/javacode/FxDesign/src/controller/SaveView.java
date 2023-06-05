package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Students;
import service.IStudentService;
import service.impl.StudentServiceImpl;
import utils.AlertScreen;
import utils.GUI;

public class SaveView {
    private IStudentService studentService = new StudentServiceImpl();
    private Students stu = null;
    private String flag = null;

    @FXML
    private TextField nameField,classRoomField,numberField,passwordField;

    @FXML
    private AnchorPane SaveView;

    public void ok(ActionEvent actionEvent) {
        String name = nameField.getText();
        String classRoom = classRoomField.getText();
        String number = numberField.getText();
        String password = passwordField.getText();
        Boolean message = AlertScreen.getMessageScreen("提示", "你确定要添加该学生吗??");
        if (message){
            if ("man".equals(flag)){
                stu = new Students();
                stu.setName(name);
                stu.setClassRoom(classRoom);
                stu.setNumber(number);
                stu.setPassword(password);
                stu.setGender("男");
                String s = studentService.saveStudent(stu);
                if ("学号已存在".equals(s)){
                    AlertScreen.getMessageScreen("提示", "学号重复，请确认学号是否有误！");
                    //numberField.setText("");
                }else if ("班级不存在".equals(s)){
                    AlertScreen.getMessageScreen("提示", "班级不存在，请确认班级是否有误！");
                }else if ("添加成功".equals(s)){
                    FXMLLoader loader = new GUI(new Stage(), "../view/StudentControl.fxml", "管理界面", 1544, 787,null).getLoader();
                    Stage stage = (Stage)SaveView.getScene().getWindow();
                    stage.close();
                    AlertScreen.getMessageScreen("提示", "学生信息添加成功！！");

                }
            }else if ("woman".equals(flag)){
                stu = new Students();
                stu.setName(name);
                stu.setClassRoom(classRoom);
                stu.setNumber(number);
                stu.setPassword(password);
                stu.setGender("女");
                String s = studentService.saveStudent(stu);
                if ("学号已存在".equals(s)){
                    AlertScreen.getMessageScreen("提示", "学号重复，请确认学号是否有误！");
                    //numberField.setText("");
                }else if ("班级不存在".equals(s)){
                    AlertScreen.getMessageScreen("提示", "班级不存在，请确认班级是否有误！");
                }else if ("添加成功".equals(s)){
                    FXMLLoader loader = new GUI(new Stage(), "../view/StudentControl.fxml", "管理界面", 1544, 787,null).getLoader();
                    Stage stage = (Stage)SaveView.getScene().getWindow();
                    stage.close();
                    AlertScreen.getMessageScreen("提示", "学生信息添加成功！！");

                }
            }
        }else {
            FXMLLoader loader = new GUI(new Stage(), "../view/StudentControl.fxml", "管理界面", 1544, 787,null).getLoader();
        }
    }


    public void getWoman(MouseEvent event) {
        flag = "woman";
    }

    public void getMan(MouseEvent event) {
        flag = "man";
    }
}
