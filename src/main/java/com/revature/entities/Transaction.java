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
    Date timeOfTransaction;

    @ManyToOne
    @JoinColumn(name = "transactionTypeId", nullable = false)
    TransactionType transactionType;

    @ManyToOne
    @JoinColumn(name = "cardTypeId", nullable = false)
    CardType cardType;

    @ManyToOne
    @JoinColumn(name = "referenceNumber", nullable = false)
    BankAccount bankAccount;
}
