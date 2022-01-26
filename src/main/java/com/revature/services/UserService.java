package com.revature.services;

import com.revature.entities.User;
import com.revature.exceptions.UserNotFoundException;
import com.revature.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserById(Long id) throws UserNotFoundException {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()) {
            throw new UserNotFoundException("User not found with id: "+id);
        }
        return userOptional.get();
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User editUser(User user) {
        Optional<User> userOptional = userRepository.findById(user.getId());
        if (!userOptional.isPresent()) {
            new UserNotFoundException("User not found with id: "+user.getId());
        }
        return userRepository.save(user);
    }

    public User deleteUser(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()) {
            new UserNotFoundException("User not found with id: "+id);
        }
        User user = userOptional.get();
        userRepository.deleteById(id);
        return user;
    }

}
