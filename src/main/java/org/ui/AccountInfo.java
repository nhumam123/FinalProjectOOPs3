package org.ui;

import javax.swing.*;

public class AccountInfo extends JFrame {
    private JTextField usernameField;
    private JTextField fullnameField;
    private JTextField emailField;
    private JTextField phoneField;
    private JPanel panel;


    public AccountInfo(String username, String fullname, String email, String phone) {
        setContentPane(panel);
        setTitle("Account Info");
        setSize(300,250);
        setLocationRelativeTo(null);
        setVisible(true);

        this.usernameField.setText(username);
        this.fullnameField.setText(fullname);
        this.emailField.setText(email);
        this.phoneField.setText(phone);
    }
}
