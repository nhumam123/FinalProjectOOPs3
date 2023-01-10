package org.ui;

import org.product.ProductView;
import org.tablemodel.TokoTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;

public class AdminMenu extends JFrame {
    private JButton ADDDATAButton;
    private JPanel panel1;
    private JButton DELETEButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTable tableProdukAdmin;
    private JTextField textField3;
    private JTextField textField4;
    private JScrollPane scrollPaneAdmin;
    private JTable tableUpdate;

//    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {
//        //to do add your handling code here:
//        //set data to their textfield
//
//        DefaultTableModel tblModel = (DefaultTableModel)table1.getModel();
//
//        //set data to text field when raw is selected
//
//        String tblKodeProduk = tblModel.getValueAt(table1.getSelectedRow(), 0) .toString();
//        String tblNamaProduk = tblModel.getValueAt(table1.getSelectedRow(), 1) .toString();
//        String tblHargaProduk = tblModel.getValueAt(table1.getSelectedRow(), 2) .toString();
//        String tblDeskProduk = tblModel.getValueAt(table1.getSelectedRow(), 3) .toString();
//
//    }


    public AdminMenu(ArrayList<ProductView> productList)  {
        final TableModel tokoDataModel = new TokoTableModel(productList);
        // Kerangka tabel TokoDataModel
        tableProdukAdmin = new JTable(tokoDataModel);
        scrollPaneAdmin.setViewportView(tableProdukAdmin);
        tableProdukAdmin.setPreferredScrollableViewportSize(new Dimension(300, 100));
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        // Set invisible row Detail dan img64
        tableProdukAdmin.removeColumn(tableProdukAdmin.getColumnModel().getColumn(3));
        tableProdukAdmin.removeColumn(tableProdukAdmin.getColumnModel().getColumn(3));

    }
}
