package org.ui;

import org.product.ProductView;
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
    private JButton resetPesanBtn;
    private JButton tambahPesan;
    private JButton kurangPesan;
    private JLabel jmlPesanLabel;
    private JLabel hargaPesanLabel;

    public MenuUtamaEtoko(ArrayList<ProductView> productList) {
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

        // Set invisible row Detail dan img64
        tableProduk.removeColumn(tableProduk.getColumnModel().getColumn(3));
        tableProduk.removeColumn(tableProduk.getColumnModel().getColumn(3));

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
                jmlPesanLabel.setText("0");
                hargaPesanLabel.setText("0");
                titleView.setText(tableProduk.getValueAt(tableProduk.getSelectedRow(), 1).toString());

                // get data from invisible column
                descView.setText(tableProduk.getModel().getValueAt(tableProduk.getSelectedRow(),3).toString());
                imageView.setText(tableProduk.getModel().getValueAt(tableProduk.getSelectedRow(),4).toString());
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
        tambahPesan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inJml = jmlPesanLabel.getText();
                int integerJml = Integer.parseInt(inJml);
                integerJml++;
                jmlPesanLabel.setText(String.valueOf(integerJml));

                String inHarga = tableProduk.getValueAt(tableProduk.getSelectedRow(), 2).toString();
                int integerHarga = Integer.parseInt(inHarga);
                integerHarga = integerHarga * integerJml ;
                hargaPesanLabel.setText(String.valueOf(integerHarga));

            }
        });
        kurangPesan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inJml = jmlPesanLabel.getText();
                int integerJml = Integer.parseInt(inJml);
                if (integerJml > 0)
                    integerJml--;
                jmlPesanLabel.setText(String.valueOf(integerJml));

                String inHarga = tableProduk.getValueAt(tableProduk.getSelectedRow(), 2).toString();
                int integerHarga = Integer.parseInt(inHarga);
                integerHarga = integerHarga * integerJml ;
                hargaPesanLabel.setText(String.valueOf(integerHarga));
            }
        });
        resetPesanBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jmlPesanLabel.setText("0");
                hargaPesanLabel.setText("0");
            }
        });
    }
}
