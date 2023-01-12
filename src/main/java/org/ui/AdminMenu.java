package org.ui;

import org.product.ProductOrder;
import org.product.ProductView;
import org.tablemodel.TokoTableModel;

import javax.swing.*;
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

        addProductBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Untuk menambahkan value ke checkout

                // get Pcs
                String getKodeProduk = selectedProduct.getKodeProduk();
                int getPcs = Integer.parseInt(jmlPesanLabel.getText());
                int hargaPatokan = Integer.parseInt(tableProduk.getValueAt(tableProduk.getSelectedRow(), 2).toString());
                String getNamaProduk = selectedProduct.getNamaProduk();
                selectedProduct.setHargaProduk(hargaPatokan, getPcs);
                int hargaProdukTotal = selectedProduct.getHargaProduk();


                selectedProduct.setHargaProduk(hargaPatokan,getPcs);

                ProductOrder pd = new ProductOrder(
                        getKodeProduk,
                        getNamaProduk,
                        hargaProdukTotal,
                        getPcs
                );

                ProductView pdv = new ProductView(
                        getKodeProduk,
                        getNamaProduk,
                        get
                )

                // Add data to hashmap
                if (!orderHashList.exist(getKodeProduk)){
                    orderHashList.addData(getKodeProduk, pd );
                } else {
                    ProductOrder orderNew = orderHashList.getData(getKodeProduk);
                    orderNew.setHargaProduk(hargaPatokan, getPcs);
                    orderHashList.updateData(getKodeProduk, orderNew);
                }
    }
}
