package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Question;
import service.IQuestionService;
import service.impl.QuestionServiceImpl;
import utils.AlertScreen;
import utils.GUI;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class QuestionControl implements Initializable {
    private IQuestionService questionService = new QuestionServiceImpl();
    public  static String name = null;
    @FXML
    private AnchorPane Question;


    @FXML
    private TableView<Question> table;

    @FXML
    private TableColumn<Question, String> checkClo,deleteClo,objectClo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("题库初始化");
        List<Question> list = questionService.getInformation();
        for (int i = 0; i < list.size(); i++) {
            ObservableList<Question> lists = FXCollections.observableArrayList(list.get(i));
            table.getItems().addAll(lists);
        }
        objectClo.setCellValueFactory(new PropertyValueFactory<Question,String>("name"));
        deleteClo.setCellFactory((col) -> {
            TableCell<Question, String> cell = new TableCell<Question, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);

                    if (!empty) {

                        Button delBtn = new Button("删除");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                            Question question = this.getTableView().getItems().get(this.getIndex());
                            Boolean messageScreen = AlertScreen.getMessageScreen("确定", "您确定要删除学科名为:    "+question.getName()+"  的题库吗？");
                            if (messageScreen){
                                String s = questionService.deleteObject(question.getName());
                                if ("成功".equals(s)){
                                    FXMLLoader loader = new GUI(new Stage(), "../view/QuestionControl.fxml", "管理界面", 1544, 787,null).getLoader();
                                    Stage stage = (Stage)Question.getScene().getWindow();
                                    stage.close();

                                    AlertScreen.getMessageScreen("确定", "删除成功！");

                                    System.out.println("删除 " + question.getName() + " 的记录成功！");
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

        checkClo.setCellFactory((col) -> {
            TableCell<Question, String> cell = new TableCell<Question, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);

                    if (!empty) {

                        Button delBtn = new Button("查看/修改");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                            Question question = this.getTableView().getItems().get(this.getIndex());
                            Boolean messageScreen = AlertScreen.getMessageScreen("确定", "您确定要查看学科名为:    "+question.getName()+"  的题库吗？");
                            if (messageScreen){
                                name = question.getName();
                                FXMLLoader loader = new GUI(new Stage(), "../view/ObjectView.fxml", "教师管理界面", 1070, 657, null).getLoader();
                                Stage stage = (Stage) Question.getScene().getWindow();
                                stage.close();
                                System.out.println("进入 " + question.getName() + " 的记录成功！");
                                }else {
                                    AlertScreen.getMessageScreen("确定", "系统出现异常,进入失败！");
                                }
                        });
                    }
                }
            };
            return cell;
        });
        System.out.println("题库初始化成功");
    }

    public void studentClicked(MouseEvent event) {
        Boolean messageScreen = AlertScreen.getMessageScreen("提示", "确定要进入学生管理界面吗？");
        if (messageScreen) {
            FXMLLoader loader = new GUI(new Stage(), "../view/StudentControl.fxml", "学生管理界面", 1544, 787, null).getLoader();
            Stage stage = (Stage) Question.getScene().getWindow();
            stage.close();
            System.out.println("进入学生界面");
        }
    }

    public void saveClicked(MouseEvent event) {

    }

    public void queryClicked(MouseEvent event) {

    }

    public void teacherClicked(MouseEvent event) {
        Boolean messageScreen = AlertScreen.getMessageScreen("提示", "确定要进入教师管理界面吗？");
        if (messageScreen) {
            FXMLLoader loader = new GUI(new Stage(), "../view/TeacherControl.fxml", "教师管理界面", 1544, 787, null).getLoader();
            Stage stage = (Stage) Question.getScene().getWindow();
            stage.close();
            System.out.println("进入教师界面");
        }
    }

    public void QuestionClicked(MouseEvent event) {
        AlertScreen.getMessageScreen("提示", "该页面就是哦！");
    }
}
