package org.ui;

import org.collection.HashCollectionsList;
import org.product.ProductView;
import org.user.type.Admin;
import org.user.type.Customer;
import org.user.type.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class MenuLogin extends JFrame{
    private JPanel panelMain;
    private JButton loginBtn;
    private JPasswordField passwordField;
    private JTextField usernameField;
    private JButton createAccBtn;
    private JButton refreshBtn;
    private JButton refreshProductButton;

    private HashCollectionsList<Customer> customers;
    private HashCollectionsList<Admin> admins;

    private HashCollectionsList<ProductView> productViews;
    private String accFoundUsername;
    private int role;


    public MenuLogin(HashCollectionsList<Customer> customerUsers, HashCollectionsList<Admin> adminUsers, HashCollectionsList<ProductView> productViews)  {
        // database
        this.customers = customerUsers;
        this.admins = adminUsers;
        this.productViews = productViews;
        NewAccountForm newAccountForm = new NewAccountForm(customers);
        AdminMenu adminMenu = new AdminMenu(productViews);

        // Refreshbtn false
        refreshBtn.setVisible(false);
        refreshProductButton.setVisible(false);

        setContentPane(panelMain);
        setTitle("Login E-Toko");
        setSize(400,300);
        setLocationRelativeTo(null);
        //h.setSize(300,400);
        setVisible(true);

        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (loginAccountBtn()) {
                    setVisible(true);
                    if (role == 1) {
                        adminMenu.setVisible(true);
                        adminMenu.setAdmin(admins.getData(accFoundUsername));
                    } else if (role == 2) {
                        CustomerMenu menuUtamaEtoko = new CustomerMenu(
                                customerUsers.getData(accFoundUsername),
                                productViews.convertToArrayList());
                    }
                }
            }
        });
        createAccBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newAccountForm.setVisible(true);
                newAccountForm.setLocationRelativeTo(null);
                refreshBtn.setVisible(true);
            }
        });
        refreshBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCustomers(newAccountForm.returnCustomers());
                refreshBtn.setVisible(false);
            }
        });
        refreshProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setProductViews(adminMenu.returnProductView());
                refreshProductButton.setVisible(false);
            }
        });
    }

    private boolean loginAccountBtn() {
        String usernameText = usernameField.getText();

        // Get either of account database from username
        Admin adminAcc = admins.getData(usernameText);
        Customer customerAcc = customers.getData(usernameText);
        User finalAcc;
        if (adminAcc != null){
            // role 1 Admin
            this.role = 1;
            finalAcc = adminAcc;
        } else if (customerAcc != null) {
            // role 2 Customer
            this.role = 2;
            finalAcc = customerAcc;
        } else {
            // none account found
            this.role = -1;
            finalAcc = null;
        }
        User objUser = checkUserPass(finalAcc);

        if (objUser != null) {
            this.accFoundUsername = objUser.getUsername();
            JOptionPane.showMessageDialog(panelMain, usernameField.getText()+" Hello");
            return true;
        }
        return false;
    }

    private <O extends User> O checkUserPass(O objUser){
        String userField = usernameField.getText();

        if (userField.equals(objUser.getUsername()) && Arrays.equals(passwordField.getPassword(), objUser.getPassword().toCharArray())) {
            JOptionPane.showMessageDialog(null, "Login Successful");
            return objUser;
        }
        else {
            JOptionPane.showMessageDialog(null, "Username or Password mismatch ");
            return null;
        }
    }

    public String getAccFoundUsername() {
        return this.accFoundUsername;
    }

    public int getRoleAcc() {
        return this.role;
    }

    public void setCustomers(HashCollectionsList<Customer> newCustomer) {
        this.customers = newCustomer;
    }

    public void setProductViews(HashCollectionsList<ProductView> productViews) {
        this.productViews = productViews;
    }
}
