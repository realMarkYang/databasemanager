package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Teacher;
import service.ITeacherService;
import service.impl.TeacherServiceImpl;
import utils.AlertScreen;
import utils.GUI;

public class SaveTeacherView {
    private ITeacherService teacherService = new TeacherServiceImpl();
    private String flag = null;
    private Teacher tea = new Teacher();
    @FXML
    private TextField nameField,numberField,phoneField;

    @FXML
    private AnchorPane SaveTeacherView;

    public void ok(ActionEvent actionEvent) {
        String name = nameField.getText();
        String number = numberField.getText();
        String phone = phoneField.getText();
        Boolean message = AlertScreen.getMessageScreen("提示", "你确定要添加该学生吗??");
        if (message){
            if ("man".equals(flag)){
                tea.setName(name);
                tea.setNumber(number);
                tea.setPhone(phone);
                tea.setGender("男");
                String s = teacherService.saveTeacher(tea);
                if ("职工号已存在".equals(s)){
                    AlertScreen.getMessageScreen("提示", "学号重复，请确认学号是否有误！");
                    //numberField.setText("");
                } else if ("添加成功".equals(s)){
                    FXMLLoader loader = new GUI(new Stage(), "../view/TeacherControl.fxml", "管理界面", 1544, 787,null).getLoader();
                    Stage stage = (Stage)SaveTeacherView.getScene().getWindow();
                    stage.close();
                    AlertScreen.getMessageScreen("提示", "教师信息添加成功！！");

                }
            }else if ("woman".equals(flag)) {
                tea.setName(name);
                tea.setNumber(number);
                tea.setPhone(phone);
                tea.setGender("女");
                String s = teacherService.saveTeacher(tea);
                if ("职工号已存在".equals(s)) {
                    AlertScreen.getMessageScreen("提示", "学号重复，请确认学号是否有误！");
                    //numberField.setText("");
                } else if ("添加成功".equals(s)) {
                    FXMLLoader loader = new GUI(new Stage(), "../view/TeacherControl.fxml", "管理界面", 1544, 787,null).getLoader();
                    Stage stage = (Stage) SaveTeacherView.getScene().getWindow();
                    stage.close();
                    AlertScreen.getMessageScreen("提示", "教师信息添加成功！！");

                }
            }
        }
    }



    public void man(MouseEvent event) {
        flag = "man";
    }

    public void woman(MouseEvent event) {
        flag = "woman";
    }
}
