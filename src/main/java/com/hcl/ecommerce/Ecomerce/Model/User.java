package com.hcl.ecommerce.Ecomerce.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private int id;
    private String firstname;
    private String lastname;
    private String country;
    private String phonenumber;
    private int zip;
    private String state;
    private String address;
    private String city;
    private String email;
    private String password;

    private String usertype;


    public User(){

    }
    public User(String firstname, String email, String password, String usertype, String address, String city, int zip, String state, String country, String lastname, String phonenumber) {
        this.firstname = firstname;
        this.email = email;
        this.password = password;
        this.usertype = usertype;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.state = state;
        this.country = country;
        this.lastname = lastname;
        this.phonenumber = phonenumber;
    }

    public User(int id, String firstname, String email, String password, String usertype, String address, String city, int zip, String state, String country, String lastname, String phonenumber) {
        this.id = id;
        this.firstname =firstname;
        this.usertype = usertype;
        this.email = email;
        this.password = password;
        this.address = address;
        this.city = city;
        this.country = country;
        this.zip = zip;
        this.state = state;
        this.lastname = lastname;
        this.phonenumber = phonenumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", country='" + country + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", zip=" + zip +
                ", state='" + state + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", usertype='" + usertype + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
