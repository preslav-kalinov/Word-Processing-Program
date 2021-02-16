package com.company;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {

    public static void main(String[] args) {
        InterfaceGUI GUI = new InterfaceGUI();
	    GUI.setVisible(true);
	    GUI.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
    }
}
