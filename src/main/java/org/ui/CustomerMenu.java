package org.ui;

import org.collection.HashCollectionsList;
import org.product.ProductOrder;
import org.product.ProductView;
import org.tablemodel.OrderViewTableModel;
import org.tablemodel.TokoTableModel;
import org.user.type.Customer;

import javax.swing.*;;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CustomerMenu extends JFrame {
    private JButton userBtn;
    private JTable tableProduk;
    private JButton checkoutButton;
    private JScrollPane scrollPaneProductView;
    private JPanel panel;
    private JButton resetBtn;
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
    private JLabel totalPriceLabel;
    private JLabel totalPcsLabel;

    private HashCollectionsList<ProductOrder> orderHashList;
    private ArrayList<ProductOrder> orderArrayListFinal;
    private int totalPrice;
    private int totalPcs;

    private ProductOrder selectedProduct = new ProductOrder(null,null,-1, -1);

    public CustomerMenu(Customer userObj, ArrayList<ProductView> productList) {
        // Isi datamodel
        final TableModel tokoDataModel = new TokoTableModel(productList);
        final TableModel orderViewDataModel = new OrderViewTableModel(new ArrayList<ProductOrder>());
        selectedProduct = new ProductOrder(null,null,-1, -1);

        orderHashList = new HashCollectionsList<>();
        totalPrice = 0;

        setTitle("Belanja E-Toko");

        userBtn.setText(userObj.getUsername());

        // Kerangka tabel TokoDataModel
        tableProduk = new JTable(tokoDataModel);
        scrollPaneProductView.setViewportView(tableProduk);
        tableProduk.setPreferredScrollableViewportSize(new Dimension(300, 100));
        setContentPane(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        // Set invisible row Detail dan img64
        tableProduk.removeColumn(tableProduk.getColumnModel().getColumn(3));

        //Kerangka tabel orderViewDataModel
        tableOrder = new JTable(orderViewDataModel);
        scrollPaneOrderView.setViewportView(tableOrder);
        tableOrder.setPreferredScrollableViewportSize(new Dimension(300, 100));
        setContentPane(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);


        tableProduk.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                // do some actions here, for example
                getSelectedRow();
            }
        });

        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkoutClick(userObj);
            }
        });

        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                orderHashList.resetData();
                ((OrderViewTableModel) orderViewDataModel).resetData();

                // Set label totalPrice to 0
                totalPrice = 0;
                totalPriceLabel.setText("0");

                // Set pcs total to 0
                totalPcs = 0;
                totalPcsLabel.setText("0");
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

                // Add data to hashmap
                if (!orderHashList.exist(getKodeProduk)){
                    orderHashList.addData(getKodeProduk, pd );
                } else {
                    ProductOrder orderNew = orderHashList.getData(getKodeProduk);
                    orderNew.setHargaProduk(hargaPatokan, getPcs);
                    orderHashList.updateData(getKodeProduk, orderNew);
                }

                // Convert hashmap into arraylist
                orderArrayListFinal = orderHashList.convertToArrayList();

                // Add Data in OrderTable
                ((OrderViewTableModel) orderViewDataModel).setProductOrderList(orderArrayListFinal);

                // Get total price & pcs label
                totalPrice = 0;
                totalPcs = 0;
                int rows = orderArrayListFinal.size();
                for (int i = 0; i < rows; i++) {
                    totalPrice += orderArrayListFinal.get(i).getHargaProduk();
                    totalPcs += orderArrayListFinal.get(i).getPcs();
                    System.out.println(totalPrice);
                }
                totalPriceLabel.setText(String.valueOf(totalPrice));
                totalPcsLabel.setText(String.valueOf(totalPcs));


            }
        });

        userBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccountInfo accountInfo = new AccountInfo(
                        userObj.getUsername(),
                        userObj.getFullname(),
                        userObj.getEmail(),
                        userObj.getPhoneNumber()
                );
            }
        });
    }

    private void getSelectedRow() {
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

    private void checkoutClick(Customer userObj) {
        String username = userBtn.getText();
        CheckoutKonfirmasi checkoutKonfirmasi = new CheckoutKonfirmasi(userObj ,orderArrayListFinal, Integer.parseInt(totalPriceLabel.getText()));
    }

}
