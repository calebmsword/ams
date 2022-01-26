package com.revature.repositoryTests;

import com.revature.entities.Role;
import com.revature.entities.User;
import com.revature.repositories.RoleRepository;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@DataJpaTest
@Tag("Integration")
public class RoleRepositoryTests {

    @Mock
    RoleRepository roleRepository;

    @Test
    void saveRole_addsNewRoleIntoDb() {
        List<User> users = new ArrayList<User>();
        users.add(new User());
        Role testRole = new Role(1L, "test",users);
        when(roleRepository.findById(1L)).thenReturn(java.util.Optional.of(testRole));
        roleRepository.save(testRole);

        assertEquals(roleRepository.findById(1L).get().getName(), testRole.getName());
    }
}
