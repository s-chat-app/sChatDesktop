package indi.midreamsheep.schatapp.desktop.schatdesktop.controller.account;

import indi.midreamsheep.schatapp.desktop.schatdesktop.until.ui.style.SChatStyleManagement;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class GuidanceController {

    @FXML
    public Text descriptionText;

    @FXML
    public TextFlow copyright;

    @FXML
    public Button login;


    private SChatStyleManagement<Button> loginStyleManagement;
    public void init(){
        initButton();
        //设置Button颜色中心向外渐变
        descriptionText.getStyleClass().add("bg-primary");
        descriptionText.setStyle("-fx-font-family: 微软雅黑");
        //设置背景颜色
        descriptionText.setStyle("-fx-background-color: #e87b7b");
    }

    private void initButton(){
        //设置按钮的gif动图背景
        loginStyleManagement = new SChatStyleManagement<>(login);
        initButtonStyle(login,loginStyleManagement);
        initLoginButton();
    }

    private void initLoginButton() {

    }

    private void initButtonStyle(Button button,SChatStyleManagement<Button> styleManagement){
        button.setOnMouseEntered(event -> {
            styleManagement.addStyle("-fx-background-color: linear-gradient(to right, #5d95ea, #00b7fc,#5d95ea)");
        });
        button.setOnMouseExited(event -> {
            styleManagement.addStyle("-fx-background-color: linear-gradient(to right, #9dd2f6, #00b7fc,#9dd2f6)");
        });
    }
    private void initText(){
        //设置字体
        descriptionText.setStyle("-fx-font-family: 微软雅黑");
        //设置字体大小
        descriptionText.setStyle("-fx-font-size: 20px");
        //设置字体颜色
        descriptionText.setStyle("-fx-text-fill: #ff0000");
        //设置背景颜色
        descriptionText.setStyle("-fx-background-color: #e87b7b");
    }


}
