package com.shantisagar.restaurant_mgnt_service.services.auth;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.shantisagar.restaurant_mgnt_service.Mapper.UserMapper;
import com.shantisagar.restaurant_mgnt_service.dtos.SignUpRequest;
import com.shantisagar.restaurant_mgnt_service.dtos.UserDto;
import com.shantisagar.restaurant_mgnt_service.entities.User;
import com.shantisagar.restaurant_mgnt_service.enums.UserRole;
import com.shantisagar.restaurant_mgnt_service.repositories.UserRepository;

import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl {
    private final UserRepository userRepository;

    public void createAnAdminAccount() {
        // UserRole.ADMIN.name() == "ADMIN"
        Optional<User> adminAccount = userRepository.findByUserRole(UserRole.ADMIN);
        if (adminAccount.isEmpty()) {
            User adminUser = new User();
            adminUser.setEmail("admin@gmail.com");
            adminUser.setName("Admin");
            adminUser.setPassword(new BCryptPasswordEncoder().encode("admin"));
            adminUser.setUserRole(UserRole.ADMIN);
            userRepository.save(adminUser);
            log.info("========= Admin Account is Created =========");
        } else {
            log.warn("Admin User is Already Exists");
        }
    }

    public UserDto createUser(SignUpRequest signUpRequest) {
        Optional<User> FoundSUser = userRepository.findFirstByEmail(signUpRequest.getEmail());
        if (FoundSUser.isPresent()) {
            throw new EntityExistsException("USer is already created");

        }
        User user = new User();
        user.setEmail(signUpRequest.getEmail());
        user.setName(signUpRequest.getName());
        user.setPassword(new BCryptPasswordEncoder().encode(signUpRequest.getPassword()));
        user.setUserRole(UserRole.CUSTOMER);
        User createdUSer = userRepository.save(user);
        return UserMapper.mapToDto(createdUSer);

    }

    

}
