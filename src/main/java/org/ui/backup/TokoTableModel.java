package org.tablemodel.backup;
import org.product.Product;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class TokoTableModel extends AbstractTableModel {
    private final ArrayList<Product> productList;
    private final String[] columnNames = new String[] {
            "Kode Produk", "Nama Produk", "Detail", "Harga", "Aksi", "Satuan"
    };
//    private final Class[] columnClass = new Class[] {
//            String.class, String.class, String.class, Integer.class, Objects.class, Integer.class
//    };

    public TokoTableModel(ArrayList<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

//    @Override
//    public Class<?> getColumnClass(int columnIndex)
//    {
//        return columnClass[columnIndex];
//    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return productList.size();
    }


    public Object getValueAt(int rowIdx, int colIdx) {
        Product row = productList.get(rowIdx);
        switch (colIdx) {
            case 0:
                return row.getKodeProduk();
            case 1:
                return row.getNamaProduk();
            case 2:
                // detail button
                JButton detailBtn = new JButton("Detail");
                detailBtn.setVisible(true);
                detailBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(detailBtn, " Hello" + productList.get(rowIdx).getDeskripsiProduk());
                    }
                });
                return detailBtn;
            case 3:
                return row.getHargaProduk();
            case 4:
                // return aksi
                return null;
            case 5:
                // return satuan
                return null;
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 2:
                return true;
            default:
                return false;
        }
    }
}
