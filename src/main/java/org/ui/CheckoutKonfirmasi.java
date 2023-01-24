package org.ui;

import org.product.ProductOrder;
import org.tablemodel.OrderViewTableModel;
import org.user.type.Customer;
import org.user.type.User;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CheckoutKonfirmasi<O extends Customer> extends JFrame {
    private JPanel panel1;
    private JTextPane alamatPane;
    private JComboBox comboBox1;
    private JButton pesanButton;
    private JLabel userLabel;
    private JTable orderTable;
    private JScrollPane tOrderScrollPane;
    private JLabel totalLabel;


    public CheckoutKonfirmasi(Customer userObj, ArrayList<ProductOrder> productOrderArrayList, int totalPrice) {
        final TableModel orderViewDataModel = new OrderViewTableModel(productOrderArrayList);

        orderTable = new JTable(orderViewDataModel);
        tOrderScrollPane.setViewportView(orderTable);

        setContentPane(panel1);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);


        userLabel.setText(userObj.getUsername());
        alamatPane.setText(userObj.getAddress());
        totalLabel.setText(String.valueOf(totalPrice));


        pesanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(panel1, "Pembelian berhasil!");
                panel1.setEnabled(false);
            }
        });
    }
}
