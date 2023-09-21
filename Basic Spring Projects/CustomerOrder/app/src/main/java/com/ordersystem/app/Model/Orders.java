package com.ordersystem.app.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="customer_id")
    private Customer customer;
    @Column(nullable = false)
    private boolean paymentStatus;
    @Enumerated(EnumType.STRING)
    private paymentType paymentType;
    private double amount;

public enum paymentType{
    UPI, CREDIT_CARD, DEBIT_CARD, CASH;
}

}