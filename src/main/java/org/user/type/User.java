package org.user.type;

public abstract class User {
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

    public String getUsername() {
        return username;
    }

    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
