package com.java_fll_dashboard;

import java.io.IOException;
import javafx.fxml.FXML;

public class DisplayApp {
    public DisplayApp() {
        System.out.println("I made it!");
    }

    @FXML
    private void switchToPrimary() throws IOException {
        Main.setRoot("primary");
    }
}