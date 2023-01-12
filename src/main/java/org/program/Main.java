package org.program;

import org.product.ProductView;
import org.ui.AdminMenu;
import org.ui.MenuLogin;
import org.ui.MenuUtamaEtoko;
import org.user.UserCollections;
import org.user.type.Admin;
import org.user.type.Customer;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        // ArrayList untuk katalog ProductView
        ArrayList<ProductView> arrpd = new ArrayList<>();

        Customer customerHumam = new Customer(
                "humam",
                "123",
                "naufal.pujianputra@binus.ac.id",
                "6284525423",
                "Jl. Araya no 1",
                "64323",
                "Malang");

        // test
        UserCollections userCollections = new UserCollections<String>();
        userCollections.addUser("humam", customerHumam);
        System.out.println(userCollections.exist("humam"));
        System.out.println(userCollections.exist("naufal"));

        // Menu login
//        MenuLogin menuLogin = new MenuLogin();
        // Menu utama toko
//        MenuUtamaEtoko menuToko = new MenuUtamaEtoko();
//        menuLogin.startMenuLogin();

        ProductView pd = new ProductView("ABS3", "Kokonut",15000, "Kokonut yang mantap");

        arrpd.add(pd);
        pd = new ProductView("AASD", "Chiki", 12000, "Chiki sedasp");
        arrpd.add(pd);
        pd = new ProductView("DSF3", "Nutrijawa",21000, "Jamu yang berasal dari jawa"  );
        arrpd.add(pd);


        // Umtuk test Menu Toko
        MenuUtamaEtoko menuToko = new MenuUtamaEtoko(arrpd);
        // Untuk test Menu Admin
        AdminMenu adminMenu = new AdminMenu(arrpd);

    }
}