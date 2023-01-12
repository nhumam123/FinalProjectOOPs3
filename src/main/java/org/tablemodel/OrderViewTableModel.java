package org.tablemodel;

import org.product.ProductOrder;

import javax.swing.table.AbstractTableModel;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class OrderViewTableModel extends AbstractTableModel {
    private ArrayList<ProductOrder> productOrderList;

    private final String[] columnNames = new String[] {
            "Kode Produk", "Nama Produk", "Pcs", "Total"
    };

    public OrderViewTableModel(ArrayList<ProductOrder> productOrderList) {
        this.productOrderList = productOrderList;
    }

    public void setProductOrderList(ArrayList<ProductOrder> productOrderList) {
        this.productOrderList = productOrderList;
        fireTableStructureChanged();
        fireTableDataChanged();
    }

    public void addDataList(ProductOrder pd){
        productOrderList.add(pd);
        fireTableRowsInserted(productOrderList.size() - 1, productOrderList.size() - 1);
    }

    public void resetData() {
        productOrderList.clear();
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return productOrderList.size();
    }


    public Object getValueAt(int rowIdx, int colIdx) {
        ProductOrder row = productOrderList.get(rowIdx);
        switch (colIdx) {
            case 0:
                return row.getKodeProduk();
            case 1:
                return row.getNamaProduk();
            case 2:
                return row.getPcs();
            case 3:
                return row.getHargaProduk();
        }
        return null;
    }


}
