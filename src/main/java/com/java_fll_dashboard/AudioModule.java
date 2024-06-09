package com.java_fll_dashboard;

import net.bjoernpetersen.volctl.VolumeControl;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AudioModule {

    private static VolumeControl volumeControl;
    private static ScheduledExecutorService scheduler;
    Runnable action;

    private final int millisecondsTickInterval = 250; //0.5 second
    private final int volumeChange = 3; //percent to add to system volume per unit of time specified above.

    public AudioModule(int mode) {
        try {
            volumeControl = new VolumeControl();
            scheduler = Executors.newScheduledThreadPool(1);

            //Could make this cleaner later.
            if (mode == 1) {
                action = () -> {
                    if (getAudioLevel() < ControllerFXMLCommands.getInstance().getMaxSliderValue()) {
                        setAudioLevel(getAudioLevel() + volumeChange);
                    }
                    else {
                        setAudioLevel(ControllerFXMLCommands.getInstance().getMaxSliderValue());
                        stopScheduler(); //We are now done.
                    }
                };
            } else if (mode == -1) {
                action = () -> {
                    if (getAudioLevel() > ControllerFXMLCommands.getInstance().getMinSliderValue()) {
                        setAudioLevel(getAudioLevel() - volumeChange);
                    }
                    else{
                        //Sets it to the precise value in case we over shoot a tad.
                        setAudioLevel(ControllerFXMLCommands.getInstance().getMinSliderValue());
                        stopScheduler(); //We are now done.
                    }
                };
            }
            else {
                action = () -> {};
            }

            scheduler.scheduleAtFixedRate(action, 0, millisecondsTickInterval, TimeUnit.MILLISECONDS);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void fadeAudioOut() {
        new AudioModule(-1);
    }

    public static void fadeAudioIn() {
        new AudioModule(1);
    }

    private void setAudioLevel(int level){
        volumeControl.setVolume(level);
    }

    private int getAudioLevel(){
        return volumeControl.getVolume();
    }
    public static void stopScheduler() {
        scheduler.shutdownNow(); // Stop the scheduler.
    }
    public static boolean schedulerActive() {
        return scheduler != null;
    }

}
