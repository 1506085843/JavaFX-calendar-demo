package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Button id_1;
    @FXML
    private TextField text_1;//从fxml获取组件，用于读取年
    @FXML
    private TextField text_2;//从fxml获取组件，用于读取月
    @FXML
    private TextArea text_3;//从fxml获取组件text_3，用于输出

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {}

    //点击按钮时触发的事件
    public void buttonAction1(ActionEvent actionEvent)
    {
        String year = text_1.getText();//获取文本框输入的内容
        String month = text_2.getText();//获取文本框输入的内容
        String result=Service.calculationDate(year,month);
        text_3.setText(result);
    }
}
