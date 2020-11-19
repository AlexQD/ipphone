package ru.radcenter.ipphone.model;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account {

    @Id
    private String account;

    private String phone;
    private String address;


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}