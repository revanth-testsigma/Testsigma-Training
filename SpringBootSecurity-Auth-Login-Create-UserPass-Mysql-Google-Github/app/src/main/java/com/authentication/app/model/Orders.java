package com.authentication.app.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User customer;
    @Column(nullable = false)
    private boolean paymentStatus;
    @Enumerated(EnumType.STRING)
    private paymentType paymentType;
    private double amount;

public enum paymentType{
    UPI, CREDIT_CARD, DEBIT_CARD, CASH;
}

}