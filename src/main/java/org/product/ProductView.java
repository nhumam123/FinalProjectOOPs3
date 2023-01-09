package org.product;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

public class ProductView extends Product{
    private String deskripsiProduk;
    private String imageProduk64;

    public ProductView(String kodeProduk, String namaProduk, int hargaProduk, String deskripsiProduk) {
        super(kodeProduk, namaProduk, hargaProduk);
        this.deskripsiProduk = deskripsiProduk;
        this.imageProduk64 = null;
    }

    public String getDeskripsiProduk() {
        return deskripsiProduk;
    }

    public void setDeskripsiProduk(String deskripsiProduk) {
        this.deskripsiProduk = deskripsiProduk;
    }

    public String getImageProduk64() {
        return imageProduk64;
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
