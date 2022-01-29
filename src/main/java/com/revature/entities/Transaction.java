package com.revature.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String initiatorAccountName;
    String datimeOfTransaction;
    String transactionType;
    float amount;
    Long recipientAccountNumber;
    String recipientAccountName;

    @ManyToOne
    @JoinColumn(name = "initiatorAccount")
    BankAccount initiatorAccount;
}
