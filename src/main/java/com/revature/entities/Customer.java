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
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long permanentAccountNumber;
    String loginId;
    String password;
    boolean isNewCustomer;
    String role;
    String firstname;
    String lastname;
    String uniqueIdentifier;
    String email;
    int birthDay;
    String birthMonth;
    int birthYear;
    String street;
    String city;
    String state;
    String areaCode;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    List<BankAccount> bankAccount;

    @OneToMany(mappedBy = "accountNumber")
    List<BankAccount> linkedAccounts;
}
