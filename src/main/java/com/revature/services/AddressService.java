package com.revature.services;

import com.revature.entities.Address;
import com.revature.exceptions.AddressNotFoundException;
import com.revature.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address findAddressById(Long id) throws AddressNotFoundException {
        Optional<Address> addressOptional = addressRepository.findById(id);
        if (!addressOptional.isPresent()) {
            throw new AddressNotFoundException("Address not found with id: "+id);
        }
        return addressOptional.get();
    }

    public List<Address> findAllAddresss() {
        return addressRepository.findAll();
    }

    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address editAddress(Address address) {
        Optional<Address> addressOptional = addressRepository.findById(address.getId());
        if (!addressOptional.isPresent()) {
            new AddressNotFoundException("Address not found with id: "+address.getId());
        }
        return addressRepository.save(address);
    }

    public Address deleteAddress(Long id) {
        Optional<Address> addressOptional = addressRepository.findById(id);
        if (!addressOptional.isPresent()) {
            new AddressNotFoundException("Address not found with id: "+id);
        }
        Address address = addressOptional.get();
        addressRepository.deleteById(id);
        return address;
    }
}
