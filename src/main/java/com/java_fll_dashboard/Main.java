package com.java_fll_dashboard;

import java.io.IOException;

public class Main {
    private static final GUI gui = new GUI();

    public static void main(String[] args) throws IOException {
        System.out.println("Starting program...");

        new ControllerFXMLCommands();
        new DisplayFXMLCommands();

        // try {
        gui.mylaunch();
        // } catch (Exception e) {
        // System.out.println(e);
        // }

    }

}