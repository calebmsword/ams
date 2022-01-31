package com.revature.services;

import com.revature.entities.BankAccount;
import com.revature.entities.Credentials;
import com.revature.entities.Customer;
import com.revature.exceptions.BankAccountNotFoundException;
import com.revature.exceptions.CustomerNotFoundException;
import com.revature.repositories.BankAccountRepository;
import com.revature.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final BankAccountRepository bankAccountRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, BankAccountRepository bankAccountRepository) {
        this.customerRepository = customerRepository;
        this.bankAccountRepository = bankAccountRepository;
    }

    public Customer findCustomerById(Long personalAccountNumber) throws CustomerNotFoundException {
        Optional<Customer> customerOptional = customerRepository.findById(personalAccountNumber);
        if (!customerOptional.isPresent()) {
            throw new CustomerNotFoundException("Customer not found with personalAccountNumber: "+personalAccountNumber);
        }
        return customerOptional.get();
    }

    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer editCustomer(Customer customer) throws CustomerNotFoundException {
        Optional<Customer> customerOptional = customerRepository.findById(customer.getPermanentAccountNumber());
        if (!customerOptional.isPresent()) {
            throw new CustomerNotFoundException("Customer not found with personalAccountNumber: " + customer.getPermanentAccountNumber());
        }
        return customerRepository.save(customer);
    }

    public Customer deleteCustomer(Long personalAccountNumber) throws CustomerNotFoundException {
        Optional<Customer> customerOptional = customerRepository.findById(personalAccountNumber);
        if (!customerOptional.isPresent()) {
            throw new CustomerNotFoundException("Customer not found with personalAccountNumber: "+personalAccountNumber);
        }
        Customer customer = customerOptional.get();
        customerRepository.deleteById(personalAccountNumber);
        return customer;
    }

    public Customer findCustomerByCredentials(Credentials credentials) throws CustomerNotFoundException {
        List<Customer> customerList = findAllCustomers();
        System.out.println("number of customers found: "+customerList.size());
        List<Customer> customerByCredentials = customerList
                .stream()
                .filter( customer ->
                        customer.getLoginId().equals(credentials.getLoginId()) &&
                        customer.getPassword().equals(credentials.getPassword())
                )
                .collect(Collectors.toList());
        if (customerByCredentials.size() == 0) {
            throw new CustomerNotFoundException("No Customer with username '"+credentials.getLoginId()+"' and password '"+credentials.getPassword()+"'");
        }
        return customerByCredentials.get(0);
    }

    public Customer addLinkedAccountToCustomer(Long pan, long accountNumber) throws CustomerNotFoundException, BankAccountNotFoundException {
        Optional<Customer> customerOptional = customerRepository.findById(pan);
        if (!customerOptional.isPresent()) {
            throw new CustomerNotFoundException("Customer not found with personalAccountNumber: "+pan);
        }

        Optional<BankAccount> bankAccountOptional = bankAccountRepository.findById(accountNumber);
        if(!bankAccountOptional.isPresent()) {
            throw new BankAccountNotFoundException("BankAccount not found with accountNumber: "+accountNumber);
        }

        Customer customer = customerOptional.get();
        BankAccount bankAccount = bankAccountOptional.get();

        List<BankAccount> linkedAccounts = customer.getLinkedAccounts();
        linkedAccounts.add(bankAccount);

        List<Customer> linkedCustomer = bankAccount.getLinkedCustomer();
        linkedCustomer.add(customer);

        customer.setLinkedAccounts(linkedAccounts);
        bankAccount.setLinkedCustomer(linkedCustomer);

        customerRepository.save(customer);
        bankAccountRepository.save(bankAccount);

        return customer;
    }

    public List<BankAccount> findAllLinkedBankAccountsByCustomerPan(Long pan) {
        List<BankAccount> bankAccountList = bankAccountRepository.findAll();
        List<BankAccount> linkedBankAccounts = new ArrayList<>();

        bankAccountList.forEach( bankAccount -> {
            if(bankAccount.getLinkedCustomer().stream().anyMatch(
                    customer -> customer.getPermanentAccountNumber().equals(pan))
            ) {
                linkedBankAccounts.add(bankAccount);
            }
        });

        return linkedBankAccounts;
    }
}
