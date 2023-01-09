package org.program;

import org.product.Product;
import org.ui.MenuLogin;
import org.ui.MenuUtamaEtoko;
import org.user.UserCollections;
import org.user.type.Admin;
import org.user.type.Customer;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
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

        Product pd = new Product("ABS3", "Kokonut", "Kokonut yang mantap", 15000);
        ArrayList<Product> arrpd = new ArrayList<>();
        arrpd.add(pd);
        pd = new Product("AASD", "Chiki", "Chiki sedasp", 12000);
        arrpd.add(pd);
        pd = new Product("DSF3", "Nutrijawa", "Jamu yang berasal dari jawa",  21000);
        arrpd.add(pd);
        MenuUtamaEtoko menuToko = new MenuUtamaEtoko(arrpd);

    }
}