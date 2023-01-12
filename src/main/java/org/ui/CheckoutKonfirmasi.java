package org.ui;

import org.product.ProductOrder;
import org.tablemodel.OrderViewTableModel;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.util.ArrayList;

public class CheckoutKonfirmasi extends JFrame {
    private JPanel panel1;
    private JTextPane textPane2;
    private JComboBox comboBox1;
    private JButton pesanButton;
    private JLabel userLabel;
    private JTable orderTable;
    private JScrollPane tOrderScrollPane;
    private JLabel totalLabel;
    private JTextField pesananTextField;


    private int totalAmount;

    public CheckoutKonfirmasi(String username, ArrayList<ProductOrder> productOrderArrayList) {
        final TableModel orderViewDataModel = new OrderViewTableModel(productOrderArrayList);
        orderTable = new JTable(orderViewDataModel);
        tOrderScrollPane.setViewportView(orderTable);

        setContentPane(panel1);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);


        userLabel.setText(username);

    }
}
