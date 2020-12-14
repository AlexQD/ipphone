package ru.radcenter.ipphone.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "account")
public class Account {

    @Id
    private String account;

    private String phone;
    private String address;

}