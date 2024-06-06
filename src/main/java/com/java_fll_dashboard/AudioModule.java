package com.java_fll_dashboard;

import net.bjoernpetersen.volctl.VolumeControl;

import java.io.IOException;

public class AudioModule {
    private static VolumeControl volumeControl;

    // Add audio controller for the system later.
    public AudioModule() throws IOException {
        volumeControl = new VolumeControl();
    }

    public void fadeAudioOut() {
        System.out.println("Current volume: " + volumeControl.getVolume());
        System.out.println("Fading out to " + ControllerFXMLCommands.getInstance().getMinSliderValue());
        volumeControl.setVolume(ControllerFXMLCommands.getInstance().getMinSliderValue());
    }

    public void fadeAudioIn() {
        System.out.println("Current volume: " + volumeControl.getVolume());
        System.out.println("Fading in to " + ControllerFXMLCommands.getInstance().getMaxSliderValue());
        volumeControl.setVolume(ControllerFXMLCommands.getInstance().getMaxSliderValue());
    }
}
