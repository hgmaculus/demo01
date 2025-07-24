package menu;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/*
    Set Look and Feel to Nimbus
*/
public class LookAndFeel {
     public static void setNimbus() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
        }
    }
}
