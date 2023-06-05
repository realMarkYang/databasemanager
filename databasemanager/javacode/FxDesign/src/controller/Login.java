package controller;


import dao.IStudentDao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import service.IMangersService;
import service.IStudentService;
import service.ITeacherService;
import service.impl.MangerServiceImpl;
import service.impl.StudentServiceImpl;
import service.impl.TeacherServiceImpl;
import utils.AlertScreen;
import utils.GUI;


public class Login {
    private ITeacherService teacherService = new TeacherServiceImpl();
    private IStudentService studentService = new StudentServiceImpl();
    private IMangersService mangersService = new MangerServiceImpl();
    private String flag = null;
    public static String Number;

    @FXML
    private AnchorPane Login;

    @FXML
    private TextField number;

    @FXML
    private PasswordField password;


    public void okButton(MouseEvent event) {
        System.out.println(flag);
        if (!("".equals(number.getText())) && !("".equals(password.getText()))) {
                if (flag == null){
                    AlertScreen.getMessageScreen("提示", "请选择身份！");
                }else if (flag == "teacher"){
                    System.out.println("老师");
                    String s = teacherService.teacherLogin(number.getText(), password.getText());
                    if ("成功".equals(s)){
                        Number = number.getText();
                        System.out.println("教师登陆成功");
                        FXMLLoader loader = new GUI(new Stage(), "../view/TeacherView.fxml", "管理界面", 856, 533,null).getLoader();
                        Stage stage = (Stage)Login.getScene().getWindow();
                        stage.close();
                    }else {
                        AlertScreen.getMessageScreen("提示", "账号或者密码错误！");
                        System.out.println("登录失败");
                    }
                }else if (flag == "student"){
                    System.out.println("学生");
                    String text = number.getText();
                    System.out.println(text);
                    String s = studentService.studentLogin(text, password.getText());
                    if ("成功".equals(s)){
                        System.out.println("学生登陆成功");
                        AlertScreen.getMessageScreen("提示", "学生登陆成功！");
                        Stage stage = (Stage)Login.getScene().getWindow();
                        stage.close();
                        FXMLLoader loader = new GUI(new Stage(), "../view/StudentView.fxml", "管理界面", 1299, 902,null).getLoader();

                    }else {
                        AlertScreen.getMessageScreen("提示", "账号或者密码错误！");
                        System.out.println("登录失败");
                    }
                }else if (flag == "manger"){
                    System.out.println("管理员");
                    String s = mangersService.mangerLogin(number.getText(),password.getText());
                    if ("管理员存在".equals(s)){
                        //AlertScreen.getMessageScreen("提示", "登陆成功！");
                        System.out.println("管理员登陆成功");
                        FXMLLoader loader = new GUI(new Stage(), "../view/StudentControl.fxml", "管理界面", 1544, 787,null).getLoader();
                        Stage stage = (Stage)Login.getScene().getWindow();
                        stage.close();
                    }else {
                        AlertScreen.getMessageScreen("提示", "账号或者密码错误！");
                        System.out.println("登录失败");
                    }
                }
        } else {
            AlertScreen.getMessageScreen("提示", "请输入账号或者密码！");
        }
    }

    public void teacher(MouseEvent event) {
        flag = "teacher";
    }

    public void student(MouseEvent event) {
        flag = "student";
    }

    public void manger(MouseEvent event) {
        flag = "manger";
    }
}
