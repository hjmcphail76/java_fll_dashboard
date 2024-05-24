package com.java_fll_dashboard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class GUI extends Application {

    private static Scene primaryScene;
    private static Scene secondaryScene;

    private static Stage controllerStage;
    private static Stage displayStage; 
    
    @Override
    public void start(Stage defaultStage) throws IOException {

        
        primaryScene = createScene("primary");
        secondaryScene = createScene("secondary");

        controllerStage = new Stage();
        controllerStage.setScene(primaryScene);
        controllerStage.show();
        
        displayStage = new Stage();
        //displayStage.setScene();  TODO:
        displayStage.show();
        
    }

    static Stage getControllerStage(){
        return controllerStage;
    }
    static Stage getDisplayStage(){
        return displayStage;
    }
    static Scene getPrimaryScene(){
        return primaryScene;
    }
    static Scene getSecondaryScene(){
        return secondaryScene;
    }

    static Scene createScene(String fxml) throws IOException{
        return new Scene(loadFXML(fxml), 640, 480);
    }

    static void setScene(Stage stage, Scene scene) throws IOException {
        stage.setScene(scene);
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
        
    }

    
    public void mylaunch(){
        //Use this to call JavaFX's launch command from another file that does not extend Application
        launch();
    }

}