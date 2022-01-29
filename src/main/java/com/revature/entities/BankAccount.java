package com.revature.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    String accountName;
    double balance;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId", referencedColumnName = "permanentAccountNumber")
    Customer customer;

    @JsonIgnore
    @OneToMany(mappedBy = "initiatorAccount")
    List<Transaction> transactionList;

    @ManyToOne
    Customer linkedCustomer;
}
