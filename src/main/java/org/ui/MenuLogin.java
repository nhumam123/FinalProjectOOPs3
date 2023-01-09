package org.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class MenuLogin extends JFrame{
    private JPanel panelMain;
    private JTextField username;
    private JButton btnClick;
    private JPasswordField password;
    private JButton btnExit;

    public MenuLogin()  {
        setContentPane(panelMain);
        setTitle("Helloss");
        setBounds(600,200,200,200);
        //h.setSize(300,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnClick.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String Username = username.getText();
                String Password1 = String.valueOf(password.getPassword());

                if (Username.equals("section.io") && Password1.equals("123"))
                    JOptionPane.showMessageDialog(null, "Login Successful");
                else
                    JOptionPane.showMessageDialog(null, "Username or Password mismatch ");

                JOptionPane.showMessageDialog(btnClick, username.getText()+" Hello");
            }
        });
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
