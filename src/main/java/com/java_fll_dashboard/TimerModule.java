package com.java_fll_dashboard;

import javafx.application.Platform;
import javafx.scene.control.TreeCell;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimerModule {
    private static volatile int restartableTime = 0;
    private static ScheduledExecutorService scheduler;

    public TimerModule() {
        scheduler = Executors.newScheduledThreadPool(1);
    }

    private static synchronized void resetTime() {
        restartableTime = 151; // 2:31
    }

    private void timer() {
        final int[] seconds = { restartableTime };
        Runnable task = () -> {
            if (seconds[0] > 0) {
                Platform.runLater(() -> DisplayFXMLCommands.getInstance().setTimerText(seconds[0]));
                seconds[0]--;
            } else {
                Platform.runLater(() -> DisplayFXMLCommands.getInstance().setTimerText(0));
                scheduler.shutdown(); // Loops until this gets called
            }
        };

        scheduler.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS); // Every 1 second, "task" is called.
    }

    public void resetAndStartTimer() {
        resetTime();
        timer();
    }

    public static boolean schedulerCreated() {
        if (scheduler == null) {
            return false;
        }
        return true;
    }

    public static void stopScheduler() {
        scheduler.shutdownNow(); // Stop the scheduler by force.
    }
}
