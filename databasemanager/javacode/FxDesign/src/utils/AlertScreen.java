package utils;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import javax.swing.*;
import java.util.Optional;

public class AlertScreen {
    /**
     * 提示框
     * @param title 标题
     * @param msg 内容
     * @return 返回一个Alert对象
     */
    public static Boolean getMessageScreen(String title, String msg){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,msg,new ButtonType("取消",ButtonBar.ButtonData.NO),
               new ButtonType("确定",ButtonBar.ButtonData.YES) );
        alert.setHeaderText("消息提示");

        alert.setContentText(msg);
        Optional<ButtonType> buttonType = alert.showAndWait();
        if(buttonType.get().getButtonData().equals(ButtonBar.ButtonData.YES)){
            return true;
        }
        else {
            return false;
        }
    }
}
