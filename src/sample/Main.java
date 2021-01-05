package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //引用sample.fxml页面布局
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        //设置窗口名称
        primaryStage.setTitle("日历");
        //设置窗口大小
        primaryStage.setScene(new Scene(root, 627, 399));
        //固定窗口大小使其无法最大化
        primaryStage.setResizable(false);
        //设置窗口的图标.
        primaryStage.getIcons().add(new Image("/sample/image/rili.jpg"));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
