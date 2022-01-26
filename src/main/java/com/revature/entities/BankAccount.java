package com.revature.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "bank_accounts")
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long accountNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId", referencedColumnName = "id")
    Customer customer;

    @OneToMany(mappedBy = "bankAccount")
    List<Transaction> transactionList;
}
