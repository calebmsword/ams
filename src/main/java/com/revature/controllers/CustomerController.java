package com.revature.controllers;

import com.revature.entities.Customer;
import com.revature.exceptions.CustomerNotFoundException;
import com.revature.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    
    private final CustomerService customerService;

    @Autowired
    CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) throws CustomerNotFoundException {
        return new ResponseEntity<Customer>(customerService.findCustomerById(id), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return new ResponseEntity<List<Customer>>(customerService.findAllCustomers(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<Customer>(customerService.saveCustomer(customer), HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<Customer> editCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<Customer>(customerService.editCustomer(customer), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Long id) {
        return new ResponseEntity<Customer>(customerService.deleteCustomer(id), HttpStatus.OK);
    }
}
