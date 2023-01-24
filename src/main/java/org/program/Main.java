package org.program;

import org.collection.HashCollectionsList;
import org.product.ProductView;
import org.ui.AdminMenu;
import org.ui.CustomerMenu;
import org.ui.MenuLogin;
import org.user.type.Admin;
import org.user.type.Customer;

import java.io.IOException;

public class Main {

    public static void  main(String[] args) throws IOException {
        // Database
        HashCollectionsList<Admin> adminUsers = new HashCollectionsList<>();
        HashCollectionsList<Customer> customerUsers = new HashCollectionsList<>();
        // ArrayList untuk katalog ProductView
        HashCollectionsList<ProductView> hashMapProductViews = new HashCollectionsList<>();

        ProductView pd = new ProductView("ABS3", "Kokonut",15000, "Kokonut yang mantap");

        // Initialize
        hashMapProductViews.addData(pd.getKodeProduk(), pd);
        pd = new ProductView("AASD", "Chiki", 12000, "Chiki sedasp");
        hashMapProductViews.addData(pd.getKodeProduk(), pd);
        pd = new ProductView("DSF3", "Nutrijawa",21000, "Jamu yang berasal dari jawa"  );
        hashMapProductViews.addData(pd.getKodeProduk(), pd);

        // Initialize customer
        Customer customer1 = new Customer(
                "humam",
                "123",
                "Naufal Humam",
                "naufal.pujianputra@binus.ac.id",
                "6284525423",
                "Jl. Araya no 1",
                "64323",
                "Malang");

        // Initialize Admin
        Admin admin1 = new Admin(
                "edomar",
                "edo",
                "Edo Mardodo",
                "edo.mardodo@gmail.com",
                "6283748900000",
                "Pemilik Perusahaan"
        );

        // add data initial to database
        customerUsers.addData(customer1.getUsername(),customer1);
        adminUsers.addData(admin1.getUsername(),admin1);

        // Menu login
        MenuLogin menuLogin = new MenuLogin(customerUsers, adminUsers, hashMapProductViews);
        String usernameAcc = menuLogin.getAccFoundUsername();
        int role = menuLogin.getRoleAcc();


        if (usernameAcc != null) {
            // ADMIN
            if (role == 1){
                AdminMenu adminMenu = new AdminMenu(hashMapProductViews);
            }
            // CUSTOMER
            if (role == 2) {
//                CustomerMenu customerMenu = new CustomerMenu(
//                        customerUsers.getData().getUsername()
//                )
            }
        }



        // Menu utama toko
//        MenuUtamaEtoko menuToko = new MenuUtamaEtoko();




        // Umtuk test Menu Toko

//        MenuUtamaEtoko menuToko = new MenuUtamaEtoko(customerHumam, hashMapProductViews.convertToArrayList()
//        );
        // Untuk test Menu Admin
//        AdminMenu adminMenu = new AdminMenu(hashMapProductViews);

//        NewAccountForm newAccountForm = new NewAccountForm();

    }
}