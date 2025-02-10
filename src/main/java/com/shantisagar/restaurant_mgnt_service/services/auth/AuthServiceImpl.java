package com.shantisagar.restaurant_mgnt_service.services.auth;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.shantisagar.restaurant_mgnt_service.entities.User;
import com.shantisagar.restaurant_mgnt_service.enums.UserRole;
import com.shantisagar.restaurant_mgnt_service.repositories.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl {
    private final UserRepository userRepository;

    public void createAnAdminAccount() {
        Optional<User> adminAccount = userRepository.findByUserRole(UserRole.ADMIN);
        if (adminAccount.isEmpty()) {
            User adminUser = new User();
            adminUser.setEmail("admin@gmail.com");
            adminUser.setName("Admin");
            adminUser.setPassword(new BCryptPasswordEncoder().encode("admin"));
            userRepository.save(adminUser);
            log.info("========= Admin Account is Created =========");
        } else {
            log.warn("Admin User is Already Exists");
        }
    }
}
