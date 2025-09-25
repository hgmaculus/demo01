
package utilsgui;

import javax.swing.JTable;

public class JTableReadonly extends JTable {
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
