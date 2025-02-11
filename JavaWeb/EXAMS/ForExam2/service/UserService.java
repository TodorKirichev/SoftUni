package com.likebookapp.service;

import com.likebookapp.model.dto.LoginRequest;
import com.likebookapp.model.dto.RegisterRequest;
import com.likebookapp.model.entity.User;
import com.likebookapp.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import static com.likebookapp.util.ErrorMessages.*;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<String> registerUser(RegisterRequest registerRequest) {
        if (!registerRequest.getPassword().equals(registerRequest.getConfirmPassword())) {
            return Optional.of(PASSWORD_DO_NOT_MATCH);
        }

        Optional<User> byUsername = userRepository.findByUsername(registerRequest.getUsername());
        if (byUsername.isPresent()) {
            return Optional.of(USERNAME_EXISTS);
        }

        Optional<User> byEmail = userRepository.findByEmail(registerRequest.getEmail());
        if (byEmail.isPresent()) {
            return Optional.of(EMAIL_EXISTS);
        }

        User user = User.builder()
                .username(registerRequest.getUsername())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .build();

        return Optional.empty();
    }

    public User loginUser(LoginRequest loginRequest) {

        Optional<User> byUsername = userRepository.findByUsername(loginRequest.getUsername());

        if (byUsername.isPresent() && passwordEncoder.matches(loginRequest.getPassword(), byUsername.get().getPassword())) {
            return byUsername.get();
        }

        return null;
//        throw new RuntimeException("Invalid username or password");
    }

    public User findUserById(UUID currentUserId) {
        return userRepository.findById(currentUserId).get();
    }
}
