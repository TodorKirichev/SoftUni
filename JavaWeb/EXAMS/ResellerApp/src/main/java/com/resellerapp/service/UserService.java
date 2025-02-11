package com.resellerapp.service;

import com.resellerapp.config.UserSession;
import com.resellerapp.model.dto.LoginRequest;
import com.resellerapp.model.dto.RegisterRequest;
import com.resellerapp.model.entity.Offer;
import com.resellerapp.model.entity.User;
import com.resellerapp.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserSession userSession;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserSession userSession) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userSession = userSession;
    }

    public Optional<String> register(RegisterRequest registerRequest) {
        Optional<User> byUsername = userRepository.findByUsername(registerRequest.getUsername());
        if (byUsername.isPresent()) {
            return Optional.of("Username already exists");
        }

        Optional<User> byEmail = userRepository.findByEmail(registerRequest.getEmail());
        if (byEmail.isPresent()) {
            return Optional.of("Email already exists");
        }

        if (!registerRequest.getPassword().equals(registerRequest.getConfirmPassword())) {
            return Optional.of("Passwords do not match");
        }

        saveUser(registerRequest);

        return Optional.empty();
    }

    private void saveUser(RegisterRequest registerRequest) {
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setEmail(registerRequest.getEmail());
        userRepository.save(user);
    }

    public boolean login(LoginRequest loginRequest) {
        Optional<User> byUsername = userRepository.findByUsername(loginRequest.getUsername());
        if (byUsername.isEmpty()) {
            return false;
        }

        if (!passwordEncoder.matches(loginRequest.getPassword(), byUsername.get().getPassword())) {
            return false;
        }

        userSession.login(byUsername.get().getId(), loginRequest.getUsername());
        return true;
    }

    public List<Offer> getLoggedInUserOffers(UUID id) {
        Optional<User> byId = userRepository.findById(id);

        return byId.get().getOffers();
    }
}
