package com.java_fll_dashboard;

import com.java_fll_dashboard.ControllerFXMLCommands;

import javafx.fxml.FXML;

public class AudioModule {
    // Add audio controller for the system later.
    public AudioModule() {

    }

    public static void fadeAudioOut() {
        System.out.println("Fading out to " + ControllerFXMLCommands.getInstance().getMinSliderValue());
    }

    public static void fadeAudioIn() {
        System.out.println("Fading in to " + ControllerFXMLCommands.getInstance().getMaxSliderValue());
    }
}
