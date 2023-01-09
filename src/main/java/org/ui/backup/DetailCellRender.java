package org.ui.backup;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class DetailCellRender extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        // Component com =  super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        JButton btnButton = new JButton("Detail");
        return btnButton;
    }
}
