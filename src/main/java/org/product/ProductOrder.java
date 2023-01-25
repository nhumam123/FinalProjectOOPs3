package org.product;

public class ProductOrder extends Product{
    private int pcs;

    public ProductOrder(String kodeProduk, String namaProduk, int hargaProduk, int pcs) {
        super(kodeProduk, namaProduk, hargaProduk );
        this.pcs = pcs;
    }

    public int getPcs() {
        return pcs;
    }

    public void setPcs(int pcs) {
        this.pcs = pcs;
    }

    public void setHargaProduk(int hargaProduk, int pcs) {
        this.hargaProduk = hargaProduk * pcs;
        this.pcs = pcs;
    }
}
