package com.java_fll_dashboard;

import java.io.IOException;
import javafx.fxml.FXML;

public class SecondaryController {

    public SecondaryController() {
        //System.out.println("I made it!");
    }

    @FXML
    private void switchToPrimary() throws IOException {
        Main.setScene(Main.getControllerStage(), Main.getPrimaryScene());
    }
}