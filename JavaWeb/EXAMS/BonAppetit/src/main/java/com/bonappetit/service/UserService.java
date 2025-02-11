package com.bonappetit.service;

import com.bonappetit.config.UserSession;
import com.bonappetit.dto.LoginRequest;
import com.bonappetit.dto.RegisterRequest;
import com.bonappetit.model.entity.Recipe;
import com.bonappetit.model.entity.User;
import com.bonappetit.repo.UserRepository;
import jakarta.validation.Valid;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    public Optional<String> registerUser(RegisterRequest registerRequest) {

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

        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setEmail(registerRequest.getEmail());
        userRepository.save(user);

        return Optional.empty();
    }

    public boolean login(LoginRequest loginRequest) {

        Optional<User> byUsername = userRepository.findByUsername(loginRequest.getUsername());
        if (byUsername.isEmpty()) {
            return false;
        }

        User user = byUsername.get();
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            return false;
        }

        userSession.login(byUsername.get().getId(), user.getUsername());

        return true;
    }

    public User findById(UUID id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional
    public List<Recipe> findFavouriteRecipes() {
        return userRepository.findById(userSession.getId())
                .map(u -> u.getFavouriteRecipes())
                .orElse(new ArrayList<>());
    }
}
