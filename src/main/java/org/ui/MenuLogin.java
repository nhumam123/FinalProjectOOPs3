package org.ui;

import org.collection.HashCollectionsList;
import org.user.type.Admin;
import org.user.type.Customer;
import org.user.type.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuLogin extends JFrame{
    private JPanel panelMain;
    private JButton loginBtn;
    private JPasswordField passwordField;
    private JTextField usernameField;
    private JButton createAccBtn;

    private HashCollectionsList<Customer> customers;
    private HashCollectionsList<Admin> admins;
    private Object AccFound;
    private int role;


    public MenuLogin(HashCollectionsList<Customer> customerUsers, HashCollectionsList<Admin> adminUsers)  {
        // database
        this.customers = customerUsers;
        this.admins = adminUsers;

        setContentPane(panelMain);
        setTitle("Login E-Toko");
        setBounds(600,200,200,200);
        //h.setSize(300,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginAccountBtn();
            }
        });
    }

    private void loginAccountBtn() {
        String usernameText = usernameField.getText();
        String password1Text = String.valueOf(passwordField.getPassword());

        // Get either of account database from username
        Admin adminAcc = admins.getData(usernameText);
        Customer customerAcc = customers.getData(usernameText);
        User finalAcc;
        if (adminAcc != null){
            // role 1 Admin
            role = 1;
            finalAcc = adminAcc;
        } else if (customerAcc != null) {
            // role 2 Customer
            role = 2;
            finalAcc = customerAcc;
        } else {
            // none account found
            role = -1;
            finalAcc = null;
        }
        checkUserPass(finalAcc);

        JOptionPane.showMessageDialog(loginBtn, usernameField.getText()+" Hello");
    }

    private <O extends User> boolean checkUserPass(O objUser){
        if (usernameField.equals(objUser.getUsername()) && passwordField.equals(objUser.getPassword())) {
            JOptionPane.showMessageDialog(null, "Login Successful");
            return true;
        }
        else {
            JOptionPane.showMessageDialog(null, "Username or Password mismatch ");
            return false;
        }



    }

//    public static void main(String[] args) {
//        MenuLogin h = new MenuLogin();
//        h.setContentPane(h.panelMain);
//        h.setTitle("Hello");
//        h.setBounds(600,200,200,200);
//        //h.setSize(300,400);
//        h.setVisible(true);
//        h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }

//    public static void startMenuLogin() {
//        MenuLogin h = new MenuLogin();
//        h.setContentPane(h.panelMain);
//        h.setTitle("Hello");
//        h.setBounds(600,200,200,200);
//        //h.setSize(300,400);
//        h.setVisible(true);
//        h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }

}
