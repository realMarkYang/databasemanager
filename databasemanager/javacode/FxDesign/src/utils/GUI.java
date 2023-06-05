package utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class GUI {
    /**
     * 界面的初始化
     * @param stage stage
     * @param path fxml路径资源
     * @param title 标题
     * @param width 窗体宽度
     * @param height 窗体高度
     */
    FXMLLoader loader = null;
    public  GUI(Stage stage, String path, String title, double width, double height,String object){

        try {
            loader = new FXMLLoader(getClass().getResource(path));
            Parent root = loader.load();
            Scene scene = new Scene(root,width,height);
            stage.setScene(scene);
            stage.setTitle(title);
            stage.getIcons().add(new Image("img/icons.png"));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            System.out.println("界面加载失败！！！");
            e.printStackTrace();
        }

    }
    public FXMLLoader getLoader(){
        return loader;
    }
}
