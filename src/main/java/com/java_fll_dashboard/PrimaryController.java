package com.java_fll_dashboard;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {
    public PrimaryController() {

    }

    @FXML
    private void switchToSecondary() throws IOException {
        Main.setRoot("secondary");
    }
    @FXML
    private void testTrigger() throws IOException {
        System.out.println("EA Sports");
    }
}
