
package com.gnuino.demo01;
import clientes.FrameClientes;
import javax.swing.SwingUtilities;
import menu.MainMenu;
public class Demo01 {
    public static void main(String[] args) {
        menu.LookAndFeel.setNimbus();
        SwingUtilities.invokeLater(() -> new MainMenu().setVisible(true));
        
        // use inside try to call autocloseable
        /*
        try (FrameClientes testFrameClientes = new FrameClientes(null, true)){
            SwingUtilities.invokeLater(() -> testFrameClientes.setVisible(true));
        } catch (Exception e) {
        }
        */
    }
}
