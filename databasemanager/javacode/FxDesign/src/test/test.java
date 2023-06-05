package test;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Mangers;



public class test extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Mangers man1 = new Mangers("1915925002", "123456", "憨憨");
        Mangers man2 = new Mangers("1915925003", "123456", "小明");
        ObservableList<Mangers> list = FXCollections.observableArrayList(man1,man2);
        TableView<Mangers> table = new TableView<>(list);
        TableColumn<Mangers,String> nameClo = new TableColumn<Mangers,String>("姓名");
        nameClo.setCellValueFactory(new PropertyValueFactory<Mangers,String>("name"));

        TableColumn<Mangers,String> numberClo = new TableColumn<Mangers,String>("学号");
        numberClo.setCellValueFactory(new PropertyValueFactory<Mangers,String>("number"));

        TableColumn<Mangers,String> passwordClo = new TableColumn<Mangers,String>("密码");
        passwordClo.setCellValueFactory(new PropertyValueFactory<Mangers,String>("password"));


        table.getColumns().addAll(nameClo,numberClo,passwordClo);
        AnchorPane ap = new AnchorPane();
        ap.getChildren().add(table);
        Scene scene = new Scene(ap);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("test");
        primaryStage.show();
    }
}
