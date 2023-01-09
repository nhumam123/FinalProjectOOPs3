package org.user.type;

abstract class User {
    protected String username;
    protected String password;
    protected String email;
    protected String phoneNumber;

    User(String username, String password, String email, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
