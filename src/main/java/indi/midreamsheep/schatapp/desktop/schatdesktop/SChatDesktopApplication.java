package indi.midreamsheep.schatapp.desktop.schatdesktop;

import indi.midreamsheep.schatapp.desktop.schatdesktop.account.GuidanceController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.stage.Stage;

import java.io.IOException;

public class SChatDesktopApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SChatDesktopApplication.class.getResource("account/guidance.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        GuidanceController controller = (GuidanceController) fxmlLoader.getController();
        controller.init();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}