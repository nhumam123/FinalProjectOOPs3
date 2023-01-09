package org.user.type;

public class Customer extends User{
    private String address;
    private String postalCode;
    private String city;

    public Customer (String username, String password, String email, String phoneNumber, String address, String postalCode, String city) {
        super(username,password,email,phoneNumber);
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
    }
}
