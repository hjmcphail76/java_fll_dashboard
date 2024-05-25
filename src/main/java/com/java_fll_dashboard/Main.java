package com.java_fll_dashboard;

import java.security.cert.TrustAnchor;

public class Main {
    private static GUI gui = new GUI();

    public static void main(String[] args) {
        System.out.println("Starting program...");
        try {
            gui.mylaunch();
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }

}