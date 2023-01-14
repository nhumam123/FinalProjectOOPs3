package org.program;

import org.collection.HashCollectionsList;
import org.product.ProductView;
import org.ui.AdminMenu;
import org.ui.MenuUtamaEtoko;
import org.ui.NewAccountForm;
import org.user.type.Admin;
import org.user.type.Customer;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        // Database
        HashCollectionsList<Admin> adminUser = new HashCollectionsList<>();
        HashCollectionsList<Customer> customerUser = new HashCollectionsList<>();

        // ArrayList untuk katalog ProductView
        HashCollectionsList<ProductView> arrpd = new HashCollectionsList<>();

        Customer customerHumam = new Customer(
                "humam",
                "123",
                "Naufal Humam",
                "naufal.pujianputra@binus.ac.id",
                "6284525423",
                "Jl. Araya no 1",
                "64323",
                "Malang");

        // test
        customerUser.addData("humam", customerHumam);
        System.out.println(customerUser.exist("humam"));
        System.out.println(customerUser.exist("naufal"));


        // Menu login
//        MenuLogin menuLogin = new MenuLogin();
        // Menu utama toko
//        MenuUtamaEtoko menuToko = new MenuUtamaEtoko();
//        menuLogin.startMenuLogin();

        ProductView pd = new ProductView("ABS3", "Kokonut",15000, "Kokonut yang mantap");

        arrpd.addData(pd.getKodeProduk(), pd);
        pd = new ProductView("AASD", "Chiki", 12000, "Chiki sedasp");
        arrpd.addData(pd.getKodeProduk(), pd);
        pd = new ProductView("DSF3", "Nutrijawa",21000, "Jamu yang berasal dari jawa"  );
        arrpd.addData(pd.getKodeProduk(), pd);


        // Umtuk test Menu Toko
//        MenuUtamaEtoko menuToko = new MenuUtamaEtoko(customerHumam, arrpd);
        // Untuk test Menu Admin
//        AdminMenu adminMenu = new AdminMenu(arrpd);

        NewAccountForm newAccountForm = new NewAccountForm();

    }
}