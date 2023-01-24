package org.tablemodel;
import org.product.ProductOrder;
import org.product.ProductView;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class TokoTableModel extends AbstractTableModel {
    private ArrayList<ProductView> productList;
    private final String[] columnNames = new String[] {
            "Kode Produk", "Nama Produk", "Harga Satuan", "Detail Produk"
    };
//    private final Class[] columnClass = new Class[] {
//            String.class, String.class, String.class, Integer.class, Objects.class, Integer.class
//    };

    public TokoTableModel(ArrayList<ProductView> productList) {
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
        return productList.size() ;
    }


    public Object getValueAt(int rowIdx, int colIdx) {
        ProductView row = productList.get(rowIdx);
        switch (colIdx) {
            case 0:
                return row.getKodeProduk();
            case 1:
                return row.getNamaProduk();
            case 2:
                return row.getHargaProduk();
            case 3:
                return row.getDeskripsiProduk();
        }
        return null;
    }

    public void setProductList(ArrayList<ProductView> productList) {
        this.productList = productList;
        fireTableStructureChanged();
        fireTableDataChanged();
    }
}
