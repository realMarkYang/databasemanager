package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Teacher;
import service.ITeacherService;
import service.impl.TeacherServiceImpl;
import utils.GUI;

import java.net.URL;
import java.util.ResourceBundle;

public class TeacherView implements Initializable {
    private ITeacherService teacherService = new TeacherServiceImpl();
    @FXML
    private AnchorPane TeacherView;

    @FXML
    private TextField name,room,object;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Teacher teacher = teacherService.queryOnePerson(Login.Number);
        name.setText(teacher.getName());
        String task = teacher.getTask();
        if (task.contains("14#201")){
            room.setText("14#201");
        }else if (task.contains("14#203")){
            room.setText("14#203");
        }else if (task.contains("14#301")){
            room.setText("14#301");
        }else if (task.contains("14#303")){
            room.setText("14#303");
        }

        if (task.contains("语文")){
            object.setText("语文");
        }else if (task.contains("数学")){
            object.setText("数学");
        }else if (task.contains("英语")){
            object.setText("英语");
        }else if (task.contains("音乐")){
            object.setText("音乐");
        }else if (task.contains("历史")){
            object.setText("历史");
        }else if (task.contains("计算机")){
            object.setText("计算机");
        }else if (task.contains("思政")){
            object.setText("思政");
        }
    }


    public void okButton(ActionEvent actionEvent) {
        Stage stage = (Stage)TeacherView.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new GUI(new Stage(), "../view/SysLogin.fxml", "管理界面", 858, 580,null).getLoader();
    }
}
