package org.ui;

import org.collection.HashCollectionsList;
import org.product.ProductOrder;
import org.product.ProductView;
import org.tablemodel.OrderViewTableModel;
import org.tablemodel.TokoTableModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminMenu extends JFrame {
    private JButton AddDataButton;
    private JPanel panel1;
    private JButton DeleteButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTable tableProdukAdmin;
    private JTextField textField3;
    private JTextField textField4;
    private JScrollPane scrollPaneAdmin;
    private JTextPane textPane1;
    private JTable tableUpdate;

    private ArrayList<ProductView> productViews;
    private HashCollectionsList<ProductView> productViewHashCollectionsList;




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


    public AdminMenu(HashCollectionsList<ProductView> productHashList)  {
        productViewHashCollectionsList = productHashList;
        productViews = productHashList.convertToArrayList();
        TableModel tokoDataModel = new TokoTableModel(productViews);


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


        tableProdukAdmin.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                // do some actions here, for example
                // print first column value from selected row
                //System.out.println(tableProduk.getValueAt(tableProduk.getSelectedRow(), 0).toString());
                textField1.setText(tableProdukAdmin.getValueAt(tableProdukAdmin.getSelectedRow(), 1).toString());
                textField2.setText(tableProdukAdmin.getValueAt(tableProdukAdmin.getSelectedRow(), 0).toString());
                textField3.setText(tableProdukAdmin.getValueAt(tableProdukAdmin.getSelectedRow(), 2).toString());
                textPane1.setText(tableProdukAdmin.getModel().getValueAt(tableProdukAdmin.getSelectedRow(),3).toString());

//
//
//                // JmlPesanLabel
//                jmlPesanLabel.setText("0");
//                hargaPesanLabel.setText("0");
//
//
//                //SetTitle
//                titleView.setText(tableProduk.getValueAt(tableProduk.getSelectedRow(), 1).toString());
//                descView.setText(tableProduk.getModel().getValueAt(tableProduk.getSelectedRow(),3).toString());
//                imageView.setText(tableProduk.getModel().getValueAt(tableProduk.getSelectedRow(),4).toString());


            }
        });


        AddDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Get data from textfield
                String namaProduk = textField1.getText();
                String kodeProduk = textField2.getText();
                int hargaProduk = Integer.parseInt(textField3.getText());
                String deskripsiProduk = textPane1.getText();

                // Pembuatan ProductView
                ProductView pd = new ProductView(kodeProduk, namaProduk, hargaProduk, deskripsiProduk);

                // Penyimpanan data ke hash dan array
                productViewHashCollectionsList.deleteData(kodeProduk);
                productViewHashCollectionsList.addData(kodeProduk, pd);
                productViews = productViewHashCollectionsList.convertToArrayList();

                // Update table
                ((TokoTableModel) tokoDataModel).setProductList(productViews);

            }
        });
        DeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String kodeProduk = textField2.getText();
                productViewHashCollectionsList.deleteData(kodeProduk);
                productViews = productViewHashCollectionsList.convertToArrayList();

                // Update table
                ((TokoTableModel) tokoDataModel).setProductList(productViews);
            }
        });
    }
}
