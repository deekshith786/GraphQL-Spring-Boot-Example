package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String userId;

    private String userName;
    private String userAddress;
    private String userPhone;
    private String password;

}
