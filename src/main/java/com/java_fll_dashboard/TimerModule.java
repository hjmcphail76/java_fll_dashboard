package com.java_fll_dashboard;

import javafx.application.Platform;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimerModule {
    private static volatile int restartableTime = 0;
    private static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);;

    public TimerModule() {
        // scheduler = Executors.newScheduledThreadPool(1);
    }

    public static synchronized void restart() {
        // System.out.println("Time reset to 150");
        restartableTime = 151;
    }

    private void timer() {
        final int[] seconds = { restartableTime };
        Runnable task = () -> {
            if (seconds[0] > 0) {
                Platform.runLater(() -> DisplayFXMLCommands.getInstance().setTimerText(seconds[0]));
                seconds[0]--;
            } else {
                Platform.runLater(() -> DisplayFXMLCommands.getInstance().setTimerText(0));
                scheduler.shutdown();
                System.out.println("Time's up!");
            }
        };

        scheduler.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS);

    }

    public static boolean isShutdown() {
        return scheduler.isShutdown();
    }

    public void start() {
        // System.out.println("Thread is running with initial time: " +
        // restartableTime);
        timer();
    }

    public static void stop() {
        scheduler.shutdownNow(); // Stop the scheduler
    }
}
