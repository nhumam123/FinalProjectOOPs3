package org.product;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

public class ProductView extends Product{
    private String deskripsiProduk;

    public ProductView(String kodeProduk, String namaProduk, int hargaProduk, String deskripsiProduk) {
        super(kodeProduk, namaProduk, hargaProduk);
        this.deskripsiProduk = deskripsiProduk;
    }

    public String getDeskripsiProduk() {
        return deskripsiProduk;
    }


}
