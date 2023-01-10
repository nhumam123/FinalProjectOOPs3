package org.product.backup;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;

public class Product {
    private String kodeProduk;
    private String namaProduk;
    private String deskripsiProduk;
    private int satuanProduk;
    private String imageProduk64;

    private int hargaProduk;

    public Product(String kodeProduk, String namaProduk, String deskripsiProduk, int satuanProduk, int hargaProduk) {
        this.kodeProduk = kodeProduk;
        this.namaProduk = namaProduk;
        this.deskripsiProduk = deskripsiProduk;
        this.satuanProduk = satuanProduk;
        this.hargaProduk = hargaProduk;
    }

    public String getKodeProduk() {
        return kodeProduk;
    }

    public void setKodeProduk(String kodeProduk) {
        this.kodeProduk = kodeProduk;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public String getDeskripsiProduk() {
        return deskripsiProduk;
    }

    public void setDeskripsiProduk(String deskripsiProduk) {
        this.deskripsiProduk = deskripsiProduk;
    }

    public int getSatuanProduk() {
        return satuanProduk;
    }

    public void setSatuanProduk(int satuanProduk) {
        this.satuanProduk = satuanProduk;
    }

    public String getImageProduk64() {
        return imageProduk64;
    }

    public int getHargaProduk() {
        return hargaProduk;
    }

    public void setHargaProduk(int hargaProduk) {
        this.hargaProduk = hargaProduk;
    }

    public void setImageProduk64(String imageProduk64) {
        this.imageProduk64 = imageProduk64;
    }

    public void ImgProdukToBase64() throws IOException {
        File f = new File("C:\\Users\\naufa\\OneDrive - Bina Nusantara\\College\\Ganjil 2022 (Sem 3)\\Screenshot_43.jpg");
        FileInputStream fin = new FileInputStream(f);
        byte imageByteArray[] = new byte[(int)f.length()];
        fin.read(imageByteArray);
        imageProduk64 = Base64.getEncoder().encodeToString(imageByteArray);
        fin.close();
    }

//    public void getImage64() throws IOException {
//        ImgProdukToBase64();
//        System.out.println(this.imageProduk64);
//    }
}
