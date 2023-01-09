package org.ui;

import org.product.Product;
import org.tablemodel.TokoTableModel;

import javax.swing.*;;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MenuUtamaEtoko extends JFrame {
    private JButton userBtn;
    private JTable tableProduk;
    private JButton checkoutButton;
    private JScrollPane scrollPane;
    private JPanel panel;
    private JButton scramble;
    private JLabel imageView;
    private JLabel descView;
    private JLabel titleView;
    private JButton tambahkanProdukButton;
    private JButton resetPesan;
    private JButton tambahPesan;
    private JButton kurangPesan;
    private JLabel jmlPesan;
    private JLabel hargaPesan;
    private JButton button1;

    public MenuUtamaEtoko(ArrayList<Product> productList) {
        // Isi datamodel
        TableModel dataModel = new TokoTableModel(productList);

        // Kerangka tabel
        tableProduk = new JTable(dataModel);
        scrollPane.setViewportView(tableProduk);
        tableProduk.setPreferredScrollableViewportSize(new Dimension(300, 100));
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        userBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        tableProduk.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                // do some actions here, for example
                // print first column value from selected row
                //System.out.println(tableProduk.getValueAt(tableProduk.getSelectedRow(), 0).toString());
                jmlPesan.setText("0");
                titleView.setText(tableProduk.getValueAt(tableProduk.getSelectedRow(), 1).toString());
                descView.setText(tableProduk.getValueAt(tableProduk.getSelectedRow(), 3).toString());
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
