package com.revature.controllers;

import com.revature.entities.Address;
import com.revature.exceptions.AddressNotFoundException;
import com.revature.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long accountNumber) throws AddressNotFoundException {
        return new ResponseEntity<Address>(addressService.findAddressById(accountNumber), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Address>> getAllAddresss() {
        return new ResponseEntity<List<Address>>(addressService.findAllAddresss(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Address> addAddress(@RequestBody Address address) {
        return new ResponseEntity<Address>(addressService.saveAddress(address), HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<Address> editAddress(@RequestBody Address address) {
        return new ResponseEntity<Address>(addressService.editAddress(address), HttpStatus.OK);
    }

    @DeleteMapping("/{accountNumber}")
    public ResponseEntity<Address> deleteAddress(@PathVariable Long accountNumber) throws AddressNotFoundException{
        return new ResponseEntity<Address>(addressService.deleteAddress(accountNumber), HttpStatus.OK);
    }
}