package org.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AdminMenu {
    private JButton ADDDATAButton;
    private JPanel panel1;
    private JButton DELETEButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTable table1;
    private JTextField textField3;
    private JTextField textField4;
    private JTable tableUpdate;

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {
        //to do add your handling code here:
        //set data to their textfield

        DefaultTableModel tblModel = (DefaultTableModel)table1.getModel();

        //set data to text field when raw is selected

        String tblKodeProduk = tblModel.getValueAt(table1.getSelectedRow(), 0) .toString();
    }
}
