package com.ordersystem.app.Model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(unique=true)
    private String email;
    private String address;
    private String password;
}
