package com.java_fll_dashboard;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;

public class ControllerFXMLCommands {
    private TimerModule timerModule;
    @FXML
    private Slider minSlider;
    @FXML
    private Slider maxSlider;
    @FXML
    private ColorPicker backgroundColorPicker;

    private static ControllerFXMLCommands instance;

    public ControllerFXMLCommands() throws IOException {
        instance = this;
    }

    @FXML
    public void initialize() {
        // Init of these items bc of the goofy JavaFX system of setting things up.
        minSlider.setMin(0);
        minSlider.setMax(100);
        minSlider.setValue(50);

        maxSlider.setMin(0);
        maxSlider.setMax(100);
        maxSlider.setValue(50);

        backgroundColorPicker.setValue(javafx.scene.paint.Color.WHITE);
    }

    // Functions to call from the window directly (buttons):
    @FXML
    private void toggleDisplay() {
        if (GUI.displayStage.showingProperty().get()) {
            GUI.displayStage.hide();
        } else {
            GUI.displayStage.show();
        }
    }

    @FXML
    private void testTrigger() {
        System.out.println("UK Sports");
    }

    @FXML
    private void fadeAudioIn() {
        AudioModule.fadeAudioIn();
    }

    @FXML
    private void fadeAudioOut() {
        AudioModule.fadeAudioOut();
    }

    @FXML
    private void startTimer() {
        if (timerModule != null) {
            TimerModule.stopScheduler(); // Stop the current timer
        }
        timerModule = new TimerModule();
        timerModule.resetAndStartTimer();

    }

    // Retrive values from elements on the "Controller" window:

    public static ControllerFXMLCommands getInstance() {
        return instance;
    }

    public int getMinSliderValue() {
        if (minSlider != null) {
            return (int) minSlider.getValue();
        }
        return 0;
    }

    public int getMaxSliderValue() {
        if (maxSlider != null) {
            return (int) maxSlider.getValue();
        }
        return 0;
    }

    @SuppressWarnings("unused")
    public String getColorPickerValue() {
        if (backgroundColorPicker != null) {
            return backgroundColorPicker.getValue().toString();
        }
        return "#FFFFFF";
    }

}
