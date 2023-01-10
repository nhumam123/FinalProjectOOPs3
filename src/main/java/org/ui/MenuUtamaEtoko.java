package org.ui;

import org.product.ProductOrder;
import org.product.ProductView;
import org.tablemodel.OrderViewTableModel;
import org.tablemodel.TokoTableModel;

import javax.swing.*;;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class MenuUtamaEtoko extends JFrame {
    private JButton userBtn;
    private JTable tableProduk;
    private JButton checkoutButton;
    private JScrollPane scrollPaneProductView;
    private JPanel panel;
    private JButton scramble;
    private JLabel imageView;
    private JLabel descView;
    private JLabel titleView;
    private JButton addProductBtn;
    private JButton resetPesanBtn;
    private JButton tambahPesan;
    private JButton kurangPesan;
    private JLabel jmlPesanLabel;
    private JLabel hargaPesanLabel;
    private JTable tableOrder;
    private JScrollPane scrollPaneOrderView;

    public MenuUtamaEtoko(ArrayList<ProductView> productList) {
        // Isi datamodel
        final TableModel tokoDataModel = new TokoTableModel(productList);
        final TableModel orderViewDataModel = new OrderViewTableModel(new ArrayList<ProductOrder>());
        final ProductOrder selectedProduct = new ProductOrder(null,null,-1, -1);
        final HashMap<String, Integer> orderTablePcsMap = new HashMap<String,Integer>();
        final ArrayList<ProductOrder> orderTableViewDataSource = new ArrayList<ProductOrder>()

        // Kerangka tabel TokoDataModel
        tableProduk = new JTable(tokoDataModel);
        scrollPaneProductView.setViewportView(tableProduk);
        tableProduk.setPreferredScrollableViewportSize(new Dimension(300, 100));
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        // Set invisible row Detail dan img64
        tableProduk.removeColumn(tableProduk.getColumnModel().getColumn(3));
        tableProduk.removeColumn(tableProduk.getColumnModel().getColumn(3));

        //Kerangka tabel orderViewDataModel
        tableOrder = new JTable(orderViewDataModel);
        scrollPaneOrderView.setViewportView(tableOrder);
        tableOrder.setPreferredScrollableViewportSize(new Dimension(300, 100));
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
                selectedProduct.setKodeProduk(tableProduk.getValueAt(tableProduk.getSelectedRow(), 0).toString());
                selectedProduct.setNamaProduk(tableProduk.getValueAt(tableProduk.getSelectedRow(), 1).toString());
                selectedProduct.setHargaProduk(Integer.parseInt(tableProduk.getValueAt(tableProduk.getSelectedRow(), 2).toString()));


                // JmlPesanLabel
                jmlPesanLabel.setText("0");
                hargaPesanLabel.setText("0");


                //SetTitle
                titleView.setText(tableProduk.getValueAt(tableProduk.getSelectedRow(), 1).toString());
                descView.setText(tableProduk.getModel().getValueAt(tableProduk.getSelectedRow(),3).toString());
                imageView.setText(tableProduk.getModel().getValueAt(tableProduk.getSelectedRow(),4).toString());

            }
        });

        tableOrder.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {


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
        addProductBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Untuk menambahkan value ke checkout

                // get Pcs
                int getPcs = Integer.parseInt(jmlPesanLabel.getText());
                int hargaPatokan = Integer.parseInt(tableProduk.getValueAt(tableProduk.getSelectedRow(), 2).toString());

                selectedProduct.setHargaProduk(hargaPatokan,getPcs);

                ProductOrder pd = new ProductOrder(
                        selectedProduct.getKodeProduk(),
                        selectedProduct.getNamaProduk(),
                        selectedProduct.getHargaProduk(),
                        getPcs
                );

                // Add Data in OrderTable
                if (!orderTablePcsMap.containsKey(pd.getKodeProduk())) {
                    orderTablePcsMap.put(pd.getKodeProduk(), pd.getPcs());
                    ((OrderViewTableModel) orderViewDataModel).addDataList(pd);
                } else {
                    orderTablePcsMap.put(pd.getKodeProduk(), orderTablePcsMap.get(pd.getKodeProduk()) + pd.getPcs());

                    pd.setHargaProduk(hargaPatokan, pcsBefore + pd.getPcs());
                    orderTableMap.put(selectedProduct.getKodeProduk(), pd);
                }


            }
        });

    }
}
