package com.java_fll_dashboard;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;

import com.java_fll_dashboard.GUI;

public class ControllerFXMLCommands {
    @FXML
    private Slider minSlider;
    private Slider maxSlider;

    public ControllerFXMLCommands() {

    }

    @FXML
    private void toggleDisplay() {
        if (GUI.displayStage.showingProperty().get()) {
            GUI.displayStage.hide();
        } else {
            GUI.displayStage.show();
        }
    }

    @FXML
    private void testTrigger() throws IOException {
        System.out.println("UK Sports");
    }

    // Retrive values from elements on the "Controller" window:

    public double getMinSliderValue() {
        return minSlider.valueProperty().get();
    }

    public double getMaxSliderValue() {
        return maxSlider.valueProperty().get();
    }
}
