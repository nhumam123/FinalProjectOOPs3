package org.user.type;

public class Admin extends User {
    private String role;
    public Admin (String username, String password, String email, String phoneNumber, String role) {
        super(username,password,email,phoneNumber);
        this.role = role;
    }

}
