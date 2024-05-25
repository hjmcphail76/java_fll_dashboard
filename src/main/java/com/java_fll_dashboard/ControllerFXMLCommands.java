package com.java_fll_dashboard;

import java.io.IOException;
import javafx.fxml.FXML;
import com.java_fll_dashboard.GUI;
public class ControllerFXMLCommands {
    public ControllerFXMLCommands() {

    }
    @FXML
    private void hideDisplayWindow(){
        if (GUI.displayStage.showingProperty().get()){
            GUI.displayStage.hide();
        }
        else{
            GUI.displayStage.show();
        }
        


    }
    @FXML
    private void showDisplayWindow(){

    }


    @FXML
    private void testTrigger() throws IOException {
        System.out.println("UK Sports");
    }
}
