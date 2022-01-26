package com.revature.controllers;

import com.revature.entities.Role;
import com.revature.exceptions.RoleNotFoundException;
import com.revature.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Long id) throws RoleNotFoundException {
        return new ResponseEntity<Role>(roleService.findRoleById(id), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> employees = roleService.findAllRoles();
        ResponseEntity<List<Role>> responseEntity = new ResponseEntity<List<Role>>(employees, HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping("")
    public ResponseEntity<Role> addRole(@RequestBody Role role) {
        return new ResponseEntity<Role>(roleService.saveRole(role), HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<Role> editRole(@RequestBody Role role) {
        return new ResponseEntity<Role>(roleService.editRole(role),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Role> deleteRole(@PathVariable Long id) {
        return new ResponseEntity<Role>(roleService.deleteRole(id),HttpStatus.OK);
    }
}
