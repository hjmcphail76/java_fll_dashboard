package com.java_fll_dashboard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GUI extends Application {

    public static Scene controllerScene;
    public static Scene displayScene;

    public static Stage controllerStage;
    public static Stage displayStage;
    private boolean isResizeable = false;

    @Override
    public void start(Stage defaultStage) throws IOException {

        controllerScene = createScene("controllerMain");
        displayScene = createScene("displayMain");

        controllerStage = new Stage();
        controllerStage.setScene(controllerScene);
        controllerStage.show();
        controllerStage.setResizable(isResizeable);

        displayStage = new Stage();
        displayStage.setScene(displayScene);
        displayStage.show();

    }

    private static Scene createScene(String fxml) throws IOException {
        return new Scene(loadFXML(fxml), 640, 480);
    }

    public static void setScene(Stage stage, Scene scene) throws IOException {
        stage.setScene(scene);
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();

    }

    public void mylaunch() {
        // Use this to call JavaFX's launch command from another file that does not
        // extend Application
        launch();
    }

}