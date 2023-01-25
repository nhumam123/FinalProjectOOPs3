package org.ui;

import org.collection.HashCollectionsList;
import org.product.ProductView;
import org.tablemodel.TokoTableModel;
import org.user.type.Admin;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminMenu extends JFrame {
    private JButton editDataBtn;
    private JPanel panel1;
    private JButton DeleteButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTable tableProdukAdmin;
    private JTextField textField3;
    private JTextField textField4;
    private JScrollPane scrollPaneAdmin;
    private JTextPane textPane1;
    private JButton addDataBtn;
    private JButton addDataBtn2;
    private JButton userButton;
    private JButton logoutButton;
    private JTable tableUpdate;

    private ArrayList<ProductView> productViewsList;
    private HashCollectionsList<ProductView> productViewHashCollectionsList;

    private TableModel tokoDataModel;

    private Admin admin;



    public AdminMenu(HashCollectionsList<ProductView> productHashList)  {
        productViewHashCollectionsList = productHashList;
        productViewsList = productHashList.convertToArrayList();
        this.tokoDataModel = new TokoTableModel(productViewsList);

        setVisible(false);

        // Kerangka tabel TokoDataModel
        tableProdukAdmin = new JTable(this.tokoDataModel);
        scrollPaneAdmin.setViewportView(tableProdukAdmin);
        tableProdukAdmin.setPreferredScrollableViewportSize(new Dimension(300, 100));
        setContentPane(panel1);
        pack();
        setLocationRelativeTo(null);

        // Set invisible button confirm
        addDataBtn2.setVisible(false);


        tableProdukAdmin.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                // do some actions here, for example
                // print first column value from selected row
                //System.out.println(tableProduk.getValueAt(tableProduk.getSelectedRow(), 0).toString());
                textField1.setText(tableProdukAdmin.getValueAt(tableProdukAdmin.getSelectedRow(), 1).toString());
                textField2.setText(tableProdukAdmin.getValueAt(tableProdukAdmin.getSelectedRow(), 0).toString());
                textField3.setText(tableProdukAdmin.getValueAt(tableProdukAdmin.getSelectedRow(), 2).toString());
                textPane1.setText(tableProdukAdmin.getModel().getValueAt(tableProdukAdmin.getSelectedRow(),3).toString());


            }
        });


        editDataBtn.addActionListener(new ActionListener() {
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
                productViewsList = productViewHashCollectionsList.convertToArrayList();

                // Update table
                updateTable();

            }
        });
        DeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (deleteConfirmation(panel1)) {
                    String kodeProduk = textField2.getText();
                    productViewHashCollectionsList.deleteData(kodeProduk);
                    productViewsList = productViewHashCollectionsList.convertToArrayList();
                    // Update table
                    updateTable();

                }
            }
        });
        addDataBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addDataBtn.setVisible(false);
                addDataBtn2.setVisible(true);
                textField2.setEditable(true);
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textPane1.setText("");
            }
        });
        addDataBtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addDataBtn.setVisible(true);
                addDataBtn2.setVisible(false);
                ProductView newProduct = new ProductView(
                        textField2.getText(),
                        textField1.getText(),
                        Integer.parseInt(textField3.getText()),
                        textPane1.getText()
                );

                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textPane1.setText("");

                textField2.setEditable(false);

                productViewHashCollectionsList.addData(newProduct.getKodeProduk(), newProduct);
                productViewsList = productViewHashCollectionsList.convertToArrayList();
                //update table
                updateTable();
                //refreshTable();
            }
        });
        userButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccountInfo accountInfo = new AccountInfo(
                        admin.getUsername(),
                        admin.getFullname(),
                        admin.getEmail(),
                        admin.getPhoneNumber()
                );
            }
        });
    }

    public boolean deleteConfirmation(Component parentComponent) {
        int confirm = JOptionPane.showConfirmDialog(parentComponent, "Apakah anda yakin untuk menghapus item ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(parentComponent, "Item deleted.");
            tableProdukAdmin.repaint();
            return true;
        }
        return false;
    }

    private void updateTable() {
        tableProdukAdmin.repaint();
        tableProdukAdmin.repaint();
        ((TokoTableModel) this.tokoDataModel).setProductList(productViewsList);
        tableProdukAdmin.setVisible(false);
        tableProdukAdmin.setVisible(true);
        tableProdukAdmin.repaint();
        tableProdukAdmin.repaint();
    }

    public void setAdmin(Admin admin){
        this.admin = admin;
        userButton.setText(admin.getUsername());
    }

    public HashCollectionsList<ProductView> returnProductView() {
        return productViewHashCollectionsList;
    }
}
