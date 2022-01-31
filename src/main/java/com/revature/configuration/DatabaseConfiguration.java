package com.revature.configuration;

import com.revature.entities.BankAccount;
import com.revature.entities.Customer;
import com.revature.entities.Transaction;
import com.revature.repositories.BankAccountRepository;
import com.revature.repositories.CustomerRepository;
import com.revature.repositories.TransactionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

//@Configuration
public class DatabaseConfiguration {

//    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository, BankAccountRepository bankAccountRepository, TransactionRepository transactionRepository) {
        return args -> {
            Customer customerNew = new Customer(
                    1000000000L,
                    "userNew",
                    "@Test000",
                    true,
                    "USER",
                    "Caleb",
                    "Sword",
                    null,
                    "BigmouthCreator@gmail.com",
                    31,
                    "May",
                    1995,
                    "871 Fisher Rd.",
                    "Grosse Pointe",
                    "Michigan",
                    "48230",
                    null,
                    null
            );
            BankAccount bankAccountCustomerNewChecking = new BankAccount(
                    100000L,
                    "Checking",
                    1000.00,
                    customerNew,
                    null,
                    null
            );
            BankAccount bankAccountCustomerNewSavings = new BankAccount(
                    100001L,
                    "Savings",
                    1000.00,
                    customerNew,
                    null,
                    null
            );
            Transaction bankAccountCustomerNewCheckingTransaction1 = new Transaction(
                    1000000000L,
                    "Checking",
                    Instant.now().toEpochMilli(),
                    "DEPOSIT",
                    10.00F,
                    100000L,
                    "Checking",
                    bankAccountCustomerNewChecking
            );
            Transaction bankAccountCustomerNewCheckingTransaction2 = new Transaction(
                    1000000001L,
                    "Checking",
                    Instant.now().toEpochMilli(),
                    "WITHDRAWAL",
                    10.00F,
                    100000L,
                    "Checking",
                    bankAccountCustomerNewChecking
            );
            Transaction bankAccountCustomerNewCheckingTransaction3 = new Transaction(
                    1000000002L,
                    "Checking",
                    Instant.now().toEpochMilli(),
                    "TRANSFER",
                    00.01F,
                    100001L,
                    "Savings",
                    bankAccountCustomerNewChecking
            );
            Transaction bankAccountCustomerNewCheckingTransaction4 = new Transaction(
                    1000000003L,
                    "Checking",
                    Instant.now().toEpochMilli(),
                    "DEPOSIT",
                    00.01F,
                    100000L,
                    "Checking",
                    bankAccountCustomerNewChecking
            );
            Transaction bankAccountCustomerNewCheckingTransaction5 = new Transaction(
                    1000000004L,
                    "Checking",
                    Instant.now().toEpochMilli(),
                    "DEPOSIT",
                    00.02F,
                    100000L,
                    "Checking",
                    bankAccountCustomerNewChecking
            );
            Transaction bankAccountCustomerNewCheckingTransaction6 = new Transaction(
                    1000000005L,
                    "Checking",
                    Instant.now().toEpochMilli(),
                    "WITHDRAWAL",
                    00.03F,
                    100000L,
                    "Checking",
                    bankAccountCustomerNewChecking
            );
            List<Transaction> bankAccountCustomerNewCheckingTransactionList = new ArrayList<Transaction>();
            bankAccountCustomerNewCheckingTransactionList.add(bankAccountCustomerNewCheckingTransaction1);
            bankAccountCustomerNewCheckingTransactionList.add(bankAccountCustomerNewCheckingTransaction2);
            bankAccountCustomerNewCheckingTransactionList.add(bankAccountCustomerNewCheckingTransaction3);
            bankAccountCustomerNewCheckingTransactionList.add(bankAccountCustomerNewCheckingTransaction4);
            bankAccountCustomerNewCheckingTransactionList.add(bankAccountCustomerNewCheckingTransaction5);
            bankAccountCustomerNewCheckingTransactionList.add(bankAccountCustomerNewCheckingTransaction6);
            bankAccountCustomerNewChecking.setTransactionList(bankAccountCustomerNewCheckingTransactionList);

            Transaction bankAccountCustomerNewSavingsTransaction1 = new Transaction(
                    1000000006L,
                    "Checking",
                    Instant.now().toEpochMilli(),
                    "DEPOSIT",
                    10.00F,
                    100000L,
                    "Checking",
                    bankAccountCustomerNewSavings
            );
            Transaction bankAccountCustomerNewSavingsTransaction2 = new Transaction(
                    1000000007L,
                    "Checking",
                    Instant.now().toEpochMilli(),
                    "WITHDRAWAL",
                    10.00F,
                    100000L,
                    "Checking",
                    bankAccountCustomerNewSavings
            );
            Transaction bankAccountCustomerNewSavingsTransaction3 = new Transaction(
                    1000000008L,
                    "Checking",
                    Instant.now().toEpochMilli(),
                    "TRANSFER",
                    00.01F,
                    100001L,
                    "Savings",
                    bankAccountCustomerNewSavings
            );
            Transaction bankAccountCustomerNewSavingsTransaction4 = new Transaction(
                    1000000009L,
                    "Checking",
                    Instant.now().toEpochMilli(),
                    "DEPOSIT",
                    00.01F,
                    100000L,
                    "Checking",
                    bankAccountCustomerNewSavings
            );
            Transaction bankAccountCustomerNewSavingsTransaction5 = new Transaction(
                    1000000010L,
                    "Checking",
                    Instant.now().toEpochMilli(),
                    "DEPOSIT",
                    00.02F,
                    100000L,
                    "Checking",
                    bankAccountCustomerNewSavings
            );
            Transaction bankAccountCustomerNewSavingsTransaction6 = new Transaction(
                    1000000011L,
                    "Checking",
                    Instant.now().toEpochMilli(),
                    "WITHDRAWAL",
                    00.03F,
                    100000L,
                    "Checking",
                    bankAccountCustomerNewSavings
            );
            List<Transaction> bankAccountCustomerNewSavingsTransactionList = new ArrayList<Transaction>();
            bankAccountCustomerNewSavingsTransactionList.add(bankAccountCustomerNewSavingsTransaction1);
            bankAccountCustomerNewSavingsTransactionList.add(bankAccountCustomerNewSavingsTransaction2);
            bankAccountCustomerNewSavingsTransactionList.add(bankAccountCustomerNewSavingsTransaction3);
            bankAccountCustomerNewSavingsTransactionList.add(bankAccountCustomerNewSavingsTransaction4);
            bankAccountCustomerNewSavingsTransactionList.add(bankAccountCustomerNewSavingsTransaction5);
            bankAccountCustomerNewSavingsTransactionList.add(bankAccountCustomerNewSavingsTransaction6);
            bankAccountCustomerNewSavings.setTransactionList(bankAccountCustomerNewSavingsTransactionList);


            // ==================================================================================================

            Customer customerVeteran = new Customer(
                    1000000001L,
                    "user",
                    "@Test000",
                    true,
                    "USER",
                    "Caleb",
                    "Sword",
                    null,
                    "BigmouthCreator@gmail.com",
                    31,
                    "May",
                    1995,
                    "871 Fisher Rd.",
                    "Grosse Pointe",
                    "Michigan",
                    "48230",
                    null,
                    null
            );
            BankAccount bankAccountCustomerVeteranChecking = new BankAccount(
                    100002L,
                    "Checking",
                    1000.00,
                    customerVeteran,
                    null,
                    null
            );
            BankAccount bankAccountCustomerVeteranSavings = new BankAccount(
                    100003L,
                    "Savings",
                    1000.00,
                    customerVeteran,
                    null,
                    null
            );

            Transaction bankAccountCustomerVeteranCheckingTransaction1 = new Transaction(
                    100012L,
                    "Checking",
                    Instant.now().toEpochMilli(),
                    "DEPOSIT",
                    10.00F,
                    100000L,
                    "Checking",
                    bankAccountCustomerVeteranChecking
            );
            Transaction bankAccountCustomerVeteranCheckingTransaction2 = new Transaction(
                    100013L,
                    "Checking",
                    Instant.now().toEpochMilli(),
                    "WITHDRAWAL",
                    10.00F,
                    100000L,
                    "Checking",
                    bankAccountCustomerVeteranChecking
            );
            Transaction bankAccountCustomerVeteranCheckingTransaction3 = new Transaction(
                    100014L,
                    "Checking",
                    Instant.now().toEpochMilli(),
                    "TRANSFER",
                    00.01F,
                    100001L,
                    "Savings",
                    bankAccountCustomerVeteranChecking
            );
            Transaction bankAccountCustomerVeteranCheckingTransaction4 = new Transaction(
                    100015L,
                    "Checking",
                    Instant.now().toEpochMilli(),
                    "DEPOSIT",
                    00.01F,
                    100000L,
                    "Checking",
                    bankAccountCustomerVeteranChecking
            );
            Transaction bankAccountCustomerVeteranCheckingTransaction5 = new Transaction(
                    100016L,
                    "Checking",
                    Instant.now().toEpochMilli(),
                    "DEPOSIT",
                    00.02F,
                    100000L,
                    "Checking",
                    bankAccountCustomerVeteranChecking
            );
            Transaction bankAccountCustomerVeteranCheckingTransaction6 = new Transaction(
                    100017L,
                    "Checking",
                    Instant.now().toEpochMilli(),
                    "WITHDRAWAL",
                    00.03F,
                    100000L,
                    "Checking",
                    bankAccountCustomerVeteranChecking
            );
            List<Transaction> bankAccountCustomerVeteranCheckingTransactionList = new ArrayList<Transaction>();
            bankAccountCustomerVeteranCheckingTransactionList.add(bankAccountCustomerVeteranCheckingTransaction1);
            bankAccountCustomerVeteranCheckingTransactionList.add(bankAccountCustomerVeteranCheckingTransaction2);
            bankAccountCustomerVeteranCheckingTransactionList.add(bankAccountCustomerVeteranCheckingTransaction3);
            bankAccountCustomerVeteranCheckingTransactionList.add(bankAccountCustomerVeteranCheckingTransaction4);
            bankAccountCustomerVeteranCheckingTransactionList.add(bankAccountCustomerVeteranCheckingTransaction5);
            bankAccountCustomerVeteranCheckingTransactionList.add(bankAccountCustomerVeteranCheckingTransaction6);
            bankAccountCustomerVeteranChecking.setTransactionList(bankAccountCustomerVeteranCheckingTransactionList);

            Transaction bankAccountCustomerVeteranSavingsTransaction1 = new Transaction(
                    100018L,
                    "Checking",
                    Instant.now().toEpochMilli(),
                    "DEPOSIT",
                    10.00F,
                    100000L,
                    "Checking",
                    bankAccountCustomerVeteranSavings
            );
            Transaction bankAccountCustomerVeteranSavingsTransaction2 = new Transaction(
                    100019L,
                    "Checking",
                    Instant.now().toEpochMilli(),
                    "WITHDRAWAL",
                    10.00F,
                    100000L,
                    "Checking",
                    bankAccountCustomerVeteranSavings
            );
            Transaction bankAccountCustomerVeteranSavingsTransaction3 = new Transaction(
                    100020L,
                    "Checking",
                    Instant.now().toEpochMilli(),
                    "TRANSFER",
                    00.01F,
                    100001L,
                    "Savings",
                    bankAccountCustomerVeteranSavings
            );
            Transaction bankAccountCustomerVeteranSavingsTransaction4 = new Transaction(
                    100021L,
                    "Checking",
                    Instant.now().toEpochMilli(),
                    "DEPOSIT",
                    00.01F,
                    100000L,
                    "Checking",
                    bankAccountCustomerVeteranSavings
            );
            Transaction bankAccountCustomerVeteranSavingsTransaction5 = new Transaction(
                    100022L,
                    "Checking",
                    Instant.now().toEpochMilli(),
                    "DEPOSIT",
                    00.02F,
                    100000L,
                    "Checking",
                    bankAccountCustomerVeteranSavings
            );
            Transaction bankAccountCustomerVeteranSavingsTransaction6 = new Transaction(
                    100023L,
                    "Checking",
                    Instant.now().toEpochMilli(),
                    "WITHDRAWAL",
                    00.03F,
                    100000L,
                    "Checking",
                    bankAccountCustomerVeteranSavings
            );
            List<Transaction> bankAccountCustomerVeteranSavingsTransactionList = new ArrayList<Transaction>();
            bankAccountCustomerVeteranSavingsTransactionList.add(bankAccountCustomerVeteranSavingsTransaction1);
            bankAccountCustomerVeteranSavingsTransactionList.add(bankAccountCustomerVeteranSavingsTransaction2);
            bankAccountCustomerVeteranSavingsTransactionList.add(bankAccountCustomerVeteranSavingsTransaction3);
            bankAccountCustomerVeteranSavingsTransactionList.add(bankAccountCustomerVeteranSavingsTransaction4);
            bankAccountCustomerVeteranSavingsTransactionList.add(bankAccountCustomerVeteranSavingsTransaction5);
            bankAccountCustomerVeteranSavingsTransactionList.add(bankAccountCustomerVeteranSavingsTransaction6);
            bankAccountCustomerVeteranSavings.setTransactionList(bankAccountCustomerVeteranSavingsTransactionList);

            // ==================================================================================================

            Customer manager = new Customer(
                    1000000001L,
                    "manager",
                    "@Test000",
                    true,
                    "USER",
                    "Caleb",
                    "Sword",
                    null,
                    "BigmouthCreator@gmail.com",
                    31,
                    "May",
                    1995,
                    "871 Fisher Rd.",
                    "Grosse Pointe",
                    "Michigan",
                    "48230",
                    null,
                    null
            );

            // ==================================================================================================

            List<Customer> customerList = new ArrayList<Customer>();
            customerList.add(customerNew);
            customerList.add(customerVeteran);
            customerList.add(manager);
            customerRepository.saveAll(customerList);

            List<BankAccount> bankAccountList = new ArrayList<BankAccount>();
            bankAccountList.add(bankAccountCustomerNewChecking);
            bankAccountList.add(bankAccountCustomerNewSavings);
            bankAccountList.add(bankAccountCustomerVeteranChecking);
            bankAccountList.add(bankAccountCustomerVeteranSavings);
            bankAccountRepository.saveAll(bankAccountList);

            List<Transaction> transactionList = new ArrayList<Transaction>();
            transactionList.add(bankAccountCustomerNewCheckingTransaction1);
            transactionList.add(bankAccountCustomerNewCheckingTransaction2);
            transactionList.add(bankAccountCustomerNewCheckingTransaction3);
            transactionList.add(bankAccountCustomerNewCheckingTransaction4);
            transactionList.add(bankAccountCustomerNewCheckingTransaction5);
            transactionList.add(bankAccountCustomerNewCheckingTransaction6);
            transactionList.add(bankAccountCustomerVeteranCheckingTransaction1);
            transactionList.add(bankAccountCustomerVeteranCheckingTransaction2);
            transactionList.add(bankAccountCustomerVeteranCheckingTransaction3);
            transactionList.add(bankAccountCustomerVeteranCheckingTransaction4);
            transactionList.add(bankAccountCustomerVeteranCheckingTransaction5);
            transactionList.add(bankAccountCustomerVeteranCheckingTransaction6);
            transactionRepository.saveAll(transactionList);
        };
    }
}
