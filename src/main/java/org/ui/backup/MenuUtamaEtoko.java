package org.ui.backup;

import org.product.Product;
import org.tablemodel.TokoTableModel;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

;

public class MenuUtamaEtoko extends JFrame {
    private JButton userBtn;
    private JTable tableProduk;
    private JButton checkoutButton;
    private JScrollPane scrollPane;
    private JPanel panel;
    private JButton scramble;

    public MenuUtamaEtoko(ArrayList<Product> productList) {
        // Isi datamodel
        TableModel dataModel = new TokoTableModel(productList);

        // Kerangka tabel
        tableProduk = new JTable(dataModel);
        scrollPane.setViewportView(tableProduk);
        tableProduk.setPreferredScrollableViewportSize(new Dimension(400, 100));
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        // Render button Detail
        tableProduk.getColumnModel().getColumn(2).setCellRenderer(new DetailCellRender());
        // For Onclick button Detail



        userBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        scramble.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableProduk.setValueAt(9999 , 1,1);
            }
        });
    }
}
