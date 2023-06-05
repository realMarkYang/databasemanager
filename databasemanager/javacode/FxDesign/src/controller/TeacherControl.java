package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Students;
import model.Teacher;
import service.ITeacherService;
import service.impl.TeacherServiceImpl;
import utils.AlertScreen;
import utils.GUI;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TeacherControl implements Initializable {
    private ITeacherService teacherService = new TeacherServiceImpl();
    @FXML
    private TableColumn<Teacher, String> numberClo, nameClo, genderClo, phoneClo, taskClo, deleteButtonClo;

    @FXML
    private AnchorPane Teacher;


    @FXML
    private TableView<Teacher> table;

    @FXML
    private TextField search;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("教师界面初始化");
        List<model.Teacher> list = teacherService.queryInformation();
        for (int i = 0; i < list.size(); i++) {
            ObservableList<Teacher> lists = FXCollections.observableArrayList(list.get(i));
            table.getItems().addAll(lists);
        }
        numberClo.setCellValueFactory(new PropertyValueFactory<Teacher, String>("number"));
        nameClo.setCellValueFactory(new PropertyValueFactory<Teacher, String>("name"));
        genderClo.setCellValueFactory(new PropertyValueFactory<Teacher, String>("gender"));
        phoneClo.setCellValueFactory(new PropertyValueFactory<Teacher, String>("phone"));
        taskClo.setCellValueFactory(new PropertyValueFactory<Teacher, String>("task"));
        deleteButtonClo.setCellFactory((col) -> {
            TableCell<Teacher, String> cell = new TableCell<Teacher, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);

                    if (!empty) {

                        Button delBtn = new Button("删除");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                            Teacher deleteTea = this.getTableView().getItems().get(this.getIndex());
                            Boolean messageScreen = AlertScreen.getMessageScreen("确定", "您确定要删除姓名为:    "+deleteTea.getName()+"  的教师吗？");
                            if (messageScreen){
                                String s = teacherService.deleteTeacher(deleteTea.getNumber());
                                if ("成功".equals(s)){
                                    FXMLLoader loader = new GUI(new Stage(), "../view/TeacherControl.fxml", "管理界面", 1544, 787,null).getLoader();
                                    Stage stage = (Stage)Teacher.getScene().getWindow();
                                    stage.close();

                                    AlertScreen.getMessageScreen("确定", "删除成功！");

                                    System.out.println("删除 " + deleteTea.getName() + " 的记录成功！");
                                }else {
                                    AlertScreen.getMessageScreen("确定", "系统出现异常,删除失败！");
                                }
                            }

                        });
                    }
                }
            };
            return cell;
        });


    }

    public void teacherClicked(MouseEvent event) {
        AlertScreen.getMessageScreen("提示", "该界面就是哦！");
    }

    public void questionClicked(MouseEvent event) {
        Boolean messageScreen = AlertScreen.getMessageScreen("提示", "确定要进入题库管理界面吗？");
        if (messageScreen) {
            FXMLLoader loader = new GUI(new Stage(), "../view/QuestionControl.fxml", "题库管理界面", 1543, 787,null).getLoader();
            Stage stage = (Stage) Teacher.getScene().getWindow();
            stage.close();
            System.out.println("进入学生界面");
        }
    }

    public void studentClicked(MouseEvent event) {
        Boolean messageScreen = AlertScreen.getMessageScreen("提示", "确定要进入学生管理界面吗？");
        if (messageScreen) {
            FXMLLoader loader = new GUI(new Stage(), "../view/StudentControl.fxml", "学生管理界面", 1544, 787,null).getLoader();
            Stage stage = (Stage) Teacher.getScene().getWindow();
            stage.close();
            System.out.println("进入学生界面");
        }
    }

    public void saveClicked(MouseEvent event) {
        FXMLLoader loader = new GUI(new Stage(), "../view/SaveTeacherView.fxml", "教师添加界面", 450, 594,null).getLoader();
        Stage stage = (Stage)Teacher.getScene().getWindow();
        stage.close();
    }

    public void queryClicked(MouseEvent event) {
        String content = search.getText();
        Teacher tea = teacherService.queryOnePerson(content);
        ObservableList<Teacher> lists = FXCollections.observableArrayList(tea);
        table.getItems().addAll(lists);
        search.clear();
        table.refresh();
    }


}
