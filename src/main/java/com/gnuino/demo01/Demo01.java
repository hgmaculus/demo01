package com.gnuino.demo01;

import javax.swing.SwingUtilities;
import menu.MainMenu;

public class Demo01 {
    public static void main(String[] args) {
        menu.LookAndFeel.setNimbus();
        SwingUtilities.invokeLater(() -> new MainMenu().setVisible(true));
    }
}
