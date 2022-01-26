package com.revature.services;

import com.revature.entities.Customer;
import com.revature.exceptions.CustomerNotFoundException;
import com.revature.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findCustomerById(Long id) throws CustomerNotFoundException {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (!customerOptional.isPresent()) {
            throw new CustomerNotFoundException("Customer not found with id: "+id);
        }
        return customerOptional.get();
    }

    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer editCustomer(Customer customer) {
        Optional<Customer> customerOptional = customerRepository.findById(customer.getId());
        if (!customerOptional.isPresent()) {
            new CustomerNotFoundException("Customer not found with id: "+customer.getId());
        }
        return customerRepository.save(customer);
    }

    public Customer deleteCustomer(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (!customerOptional.isPresent()) {
            new CustomerNotFoundException("Customer not found with id: "+id);
        }
        Customer customer = customerOptional.get();
        customerRepository.deleteById(id);
        return customer;
    }
}
