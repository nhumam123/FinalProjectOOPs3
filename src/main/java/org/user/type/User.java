package org.user.type;

abstract class User {
    protected String username;
    protected String password;
    protected String fullname;
    protected String email;
    protected String phoneNumber;

    User(String username, String password, String fullname, String email, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
