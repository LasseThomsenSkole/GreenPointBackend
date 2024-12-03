package org.example.greenpointbackend.service;

import lombok.RequiredArgsConstructor;
import org.example.greenpointbackend.model.Enums.Role;
import org.example.greenpointbackend.model.Enums.JobTitle;
import org.example.greenpointbackend.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.example.greenpointbackend.model.User;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private static final String EXISTING_USERNAME = "UserTest";
    //TODO skal laves om til database
    //dette er en hardcoder bruger
    public User getUserByUsername(String username) {
        if (! EXISTING_USERNAME.equals(username)) {
            throw new UsernameNotFoundException("User not found");
        }

        User user = new User();
        user.setId(1);
        user.setUsername(EXISTING_USERNAME);
        user.setPassword("$2a$12$G20tn3gThoAyHKBp6nJyh.SCUivWS7MN5qtc6AU687vkfiOSiSA9C"); // password: "test"
        user.setRole(Role.USER);
        user.setJobTitle(JobTitle.IN_STORE_TRAINER);
        return user;
    }
    /*
    public User getUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }*/
}