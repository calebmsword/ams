package com.revature.services;

import com.revature.entities.Role;
import com.revature.exceptions.RoleNotFoundException;
import com.revature.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findRoleById(Long id) throws RoleNotFoundException {
        Optional<Role> employeeOptional = roleRepository.findById(id);
        if(!employeeOptional.isPresent()) {
            throw new RoleNotFoundException("Role not found with id: "+id);
        }
        return employeeOptional.get();
    }

    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }

    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }


    public Role editRole(Role employee) {
        Optional<Role> employeeOptional = roleRepository.findById(employee.getId());
        if(!employeeOptional.isPresent()) {
            new RoleNotFoundException("Role not found with id: "+employee.getId());
        }
        return roleRepository.save(employee);
    }

    public Role deleteRole(Long id) {
        Optional<Role> employeeOptional = roleRepository.findById(id);
        if(!employeeOptional.isPresent()) {
            new RoleNotFoundException("Role not found with id: "+id);
        }
        Role role = employeeOptional.get();
        roleRepository.deleteById(id);
        return role;
    }
}
