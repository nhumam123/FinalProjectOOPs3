package org.ui;

import org.collection.HashCollectionsList;
import org.user.type.Customer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Arrays;

public class NewAccountForm extends JFrame {
    private JTextField usernameField;
    private JTextField fullnameField;
    private JTextField emailField;
    private JTextField telpField;
    private JTextField cityField;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JButton daftarBtn;
    private JTextPane addressPane;
    private JTextField postalCodeField;
    private JPanel panel;


    private String username;
    private String fullname;
    private String email;
    private String telp;
    private String address;
    private String postalCode;
    private String city;
    private char[] password;

    private HashCollectionsList<Customer> customers;
    private Customer cust;


    public NewAccountForm(HashCollectionsList<Customer> customers)  {
        // Customer database
        this.customers = customers;

        setContentPane(panel);
        setTitle("Registrasi");
        setBounds(600,200,400,450);
        //h.setSize(300,400);
        setVisible(false);

        daftarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(register()){
                    JOptionPane.showMessageDialog(panel, "akun " + cust.getUsername() + " telah dibuat!");
                    setVisible(false);
                }

            }
        });

    }

    private boolean register() {
        this.username = usernameField.getText();
        this.fullname = fullnameField.getText();
        this.email = emailField.getText();
        this.telp = telpField.getText();
        this.address = addressPane.getText();
        this.postalCode = postalCodeField.getText();
        this.city = cityField.getText();

        this.password = validateSamePassword();

        if (checkFilledFieldMessage() && this.password.length != 0 && usernameNotExist()) {
            this.cust = new Customer(
                    this.username,
                    String.valueOf(this.password),
                    this.fullname,
                    this.email,
                    this.telp,
                    this.address,
                    this.postalCode,
                    this.city
            );
            customers.addData(cust.getUsername(), cust);
            return true;
        }
        return false;
    }

    public HashCollectionsList<Customer> returnCustomers(){
        return this.customers;
    }

    public char[] validateSamePassword() {
        if (passwordField1.getPassword().length == 0 || passwordField2.getPassword().length == 0){
            JOptionPane.showMessageDialog(panel, "Password harus diisi!");
        }
        if (Arrays.equals(passwordField1.getPassword(), passwordField2.getPassword()) ) {
            return passwordField1.getPassword();
        } else {
            JOptionPane.showMessageDialog(panel, "Password tidak sama!");
            return null;
        }
    }

    public boolean checkFilledFieldMessage () {
        if (usernameField.getText().length() == 0 ||
        usernameField.getText().length() == 0  ||
        fullnameField.getText().length() == 0  ||
        emailField.getText().length() == 0  ||
        telpField.getText().length() == 0  ||
        addressPane.getText().length() == 0  ||
        postalCodeField.getText().length() == 0  ||
        cityField.getText().length() == 0
        ) {
            JOptionPane.showMessageDialog(panel, "Isi semua field!");
            return false;
        }
        return true;
    }

    private boolean usernameNotExist() {
        if (!customers.exist(this.username)) {
            return true;
        }
        JOptionPane.showMessageDialog(panel, "Username sudah ada!");
        return false;
    }



}
