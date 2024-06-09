package com.java_fll_dashboard;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class DisplayFXMLCommands {
    private static DisplayFXMLCommands instance;

    @FXML
    private Text timerText;

    public DisplayFXMLCommands() {
        instance = this;
    }

    public static DisplayFXMLCommands getInstance() {
        return instance;

    }

    @FXML
    public void initialize() {
        // Init of these items bc of the goofy JavaFX system of setting things up.
        timerText.setText("2:30");

    }

    public void setTimerText(int time) {

        if (time % 60 < 10) {
            timerText.setText(time / 60 + ":0" + time % 60);
        } else {
            timerText.setText(time / 60 + ":" + time % 60);
        }

    }

}