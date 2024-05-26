package com.java_fll_dashboard;

import com.java_fll_dashboard.TimerModule;

public class Main {
    private static GUI gui = new GUI();

    public static void main(String[] args) {
        System.out.println("Starting program...");

        ControllerFXMLCommands controllerFXMLCommands = new ControllerFXMLCommands();
        DisplayFXMLCommands displayFXMLCommands = new DisplayFXMLCommands();

        // try {
        gui.mylaunch();
        // } catch (Exception e) {
        // System.out.println(e);
        // }

    }

}