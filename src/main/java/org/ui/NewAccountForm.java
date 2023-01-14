package org.ui;

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

    private Customer cust;


    public NewAccountForm()  {
//        String username, String password, String fullname,  String email, String phoneNumber, String address, String postalCode, String city
        setContentPane(panel);
        setTitle("Registrasi");
        setBounds(600,200,400,450);
        //h.setSize(300,400);
        setVisible(true);

        daftarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                register();
            }
        });
    }

    public void register() {
        this.username = usernameField.getText();
        this.fullname = fullnameField.getText();
        this.email = emailField.getText();
        this.telp = telpField.getText();
        this.address = addressPane.getText();
        this.postalCode = postalCodeField.getText();
        this.city = cityField.getText();

        this.password = validateSamePassword();

        if (checkFilledFieldMessage() && this.password.length != 0) {
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

        }
    }

    public Customer returnCustomerObj (){
        return this.cust;
    }

    public char[] validateSamePassword() {
        if (passwordField1.getPassword().length == 0 || passwordField2.getPassword().length == 0){
            JOptionPane.showMessageDialog(daftarBtn, "Password harus diisi!");
        }
        if (Arrays.equals(passwordField1.getPassword(), passwordField2.getPassword()) ) {
            return passwordField1.getPassword();
        } else {
            JOptionPane.showMessageDialog(daftarBtn, "Password tidak sama!");
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
            JOptionPane.showMessageDialog(daftarBtn, "Isi semua field!");
            return false;
        }
        return true;
    }

}
