package controller;

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
import service.IStudentService;
import service.impl.StudentServiceImpl;
import utils.AlertScreen;
import utils.GUI;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class StudentControl implements Initializable {
    private IStudentService studentService = new StudentServiceImpl();
    @FXML
    private TableView<Students> table;

    @FXML
    private AnchorPane Student;

    @FXML
    private TableColumn<Students, String> numberClo, nameClo, genderClo,classRoomClo,chineseDateClo,mathDateClo,englishDateClo,deleteButtonClo;

    @FXML
    private TableColumn<Students, Double> g_ChineseClo, g_MathClo, g_EnglishClo, g_historyClo,
                                            g_musicClo,g_computerClo,g_polityClo,g_SumClo, g_AvgClo;

    @FXML
    private TextField search;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("学生界面初始化");
        List<Students> list = studentService.queryInformation();
        for (int i = 0; i < list.size(); i++) {
            ObservableList<Students> lists = FXCollections.observableArrayList(list.get(i));
            table.getItems().addAll(lists);
        }
        nameClo.setCellValueFactory(new PropertyValueFactory<Students, String>("name"));
        genderClo.setCellValueFactory(new PropertyValueFactory<Students, String>("gender"));
        classRoomClo.setCellValueFactory(new PropertyValueFactory<Students,String>("classRoom"));
        numberClo.setCellValueFactory(new PropertyValueFactory<Students, String>("number"));
        g_ChineseClo.setCellValueFactory(new PropertyValueFactory<Students,Double>("g_Chinese"));
        g_MathClo.setCellValueFactory(new PropertyValueFactory<Students,Double>("g_Math"));
        g_EnglishClo.setCellValueFactory(new PropertyValueFactory<Students,Double>("g_English"));
        g_SumClo.setCellValueFactory(new PropertyValueFactory<Students,Double>("g_Sum"));
        g_AvgClo.setCellValueFactory(new PropertyValueFactory<Students,Double>("g_Avg"));
        chineseDateClo.setCellValueFactory(new PropertyValueFactory<Students,String>("chinese_date_place"));
        mathDateClo.setCellValueFactory(new PropertyValueFactory<Students,String>("math_date_place"));
        englishDateClo.setCellValueFactory(new PropertyValueFactory<Students,String>("english_date_place"));
        g_historyClo.setCellValueFactory(new PropertyValueFactory<Students,Double>("g_history"));
        g_musicClo.setCellValueFactory(new PropertyValueFactory<Students,Double>("g_music"));
        g_computerClo.setCellValueFactory(new PropertyValueFactory<Students,Double>("g_computer"));
        g_polityClo.setCellValueFactory(new PropertyValueFactory<Students,Double>("g_polity"));
        deleteButtonClo.setCellFactory((col) -> {
            TableCell<Students, String> cell = new TableCell<Students, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);

                    if (!empty) {

                        Button delBtn = new Button("删除");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                            Students deleteStu = this.getTableView().getItems().get(this.getIndex());
                            Boolean messageScreen = AlertScreen.getMessageScreen("确定", "您确定要删除姓名为:   "+deleteStu.getName()+"  的学生吗？");
                            if (messageScreen){

                                String s = studentService.deleteStudent(deleteStu.getNumber());
                                if ("成功".equals(s)){
                                    FXMLLoader loader = new GUI(new Stage(), "../view/StudentControl.fxml", "管理界面", 1544, 787,null).getLoader();
                                    Stage stage = (Stage)Student.getScene().getWindow();
                                    stage.close();

                                    AlertScreen.getMessageScreen("确定", "删除成功！");

                                    System.out.println("删除 " + deleteStu.getName() + " 的记录成功！");
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

        System.out.println("初始化成功！");
    }

    @FXML
    public void questionClicked(MouseEvent event) {
        Boolean messageScreen = AlertScreen.getMessageScreen("提示", "确定要进入题库管理界面吗？");
        if (messageScreen) {
            FXMLLoader loader = new GUI(new Stage(), "../view/QuestionControl.fxml", "题库管理界面", 1543, 787,null).getLoader();
            Stage stage = (Stage) Student.getScene().getWindow();
            stage.close();
            System.out.println("进入学生界面");
        }
    }

    @FXML
    public void teacherClicked(MouseEvent event) {
        Boolean messageScreen = AlertScreen.getMessageScreen("提示", "确定要进入教师管理界面吗？");
        if (messageScreen){
            FXMLLoader loader = new GUI(new Stage(), "../view/TeacherControl.fxml", "教师管理界面", 1544, 787,null).getLoader();
            Stage stage = (Stage)Student.getScene().getWindow();
            stage.close();
            System.out.println("进入教师界面");
        }

    }

    @FXML
    public void studentClicked(MouseEvent event) {
         AlertScreen.getMessageScreen("提示", "该界面就是哦！");

    }

    @FXML
    public void saveClicked(MouseEvent event) {
        FXMLLoader loader = new GUI(new Stage(), "../view/SaveView.fxml", "学生添加界面", 450, 594,null).getLoader();
        Stage stage = (Stage)Student.getScene().getWindow();
        stage.close();
    }


    @FXML
    public void queryClicked(MouseEvent event) {
        String content = search.getText();
        Students stu = studentService.queryOnePerson(content);
        if (stu!=null){
            ObservableList<Students> lists = FXCollections.observableArrayList(stu);
            table.getItems().addAll(lists);
            search.clear();
            table.refresh();
        }else {
            AlertScreen.getMessageScreen("提示", "找不到该学生！！");
            search.clear();
        }

    }

}
