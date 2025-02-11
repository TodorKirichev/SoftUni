package com.paintingscollectors.service;

import com.paintingscollectors.model.dto.LoginRequest;
import com.paintingscollectors.model.dto.RegisterRequest;
import com.paintingscollectors.model.entity.Painting;
import com.paintingscollectors.model.entity.User;
import com.paintingscollectors.repository.PaintingRepository;
import com.paintingscollectors.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final PaintingRepository paintingRepository;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, PaintingRepository paintingRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.paintingRepository = paintingRepository;
    }

    public Optional<String> registerUser(RegisterRequest registerRequest) {
        if (!registerRequest.getPassword().equals(registerRequest.getConfirmPassword())) {
            return Optional.of("Passwords do not match");
        }

        Optional<User> byUsername = userRepository.findByUsername(registerRequest.getUsername());
        if (byUsername.isPresent()) {
            return Optional.of("Username already exists");
        }

        Optional<User> byEmail = userRepository.findByEmail(registerRequest.getEmail());
        if (byEmail.isPresent()) {
            return Optional.of("Email already exists");
        }

        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        userRepository.save(user);

        return Optional.empty();
    }

    public User loginUser(LoginRequest loginRequest) {
        Optional<User> byUsername = userRepository.findByUsername(loginRequest.getUsername());
        if (byUsername.isEmpty()) {
            return null;
        }
        User user = byUsername.get();

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            return null;
        }
        return user;
    }

    public User findUserById(UUID currentUserId) {
        return userRepository.findById(currentUserId).get();
    }

    public void addToFavourite(Painting painting, UUID currentUserId) {
        User user = userRepository.findById(currentUserId).get();
        user.getFavouritePaintings().add(painting);
        userRepository.save(user);
    }

    public void removeFromFavourites(Painting painting, UUID userId) {
        User user = userRepository.findById(userId).get();
        user.getFavouritePaintings().removeIf(p -> p.getId().equals(painting.getId()));
        userRepository.save(user);
    }
}
