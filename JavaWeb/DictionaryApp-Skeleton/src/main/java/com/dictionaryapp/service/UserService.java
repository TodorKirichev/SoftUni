package com.dictionaryapp.service;

import com.dictionaryapp.config.UserSession;
import com.dictionaryapp.model.dto.UserLoginRequest;
import com.dictionaryapp.model.dto.UserRegisterRequest;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.repo.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserSession userSession;

    public UserService(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, UserSession userSession) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.userSession = userSession;
    }

    public boolean registerUser(UserRegisterRequest userRegisterRequest) {
        if (!userRegisterRequest.getPassword().equals(userRegisterRequest.getConfirmPassword())) {
            return false;
        }

       boolean isExist = userRepository.existsByUsernameOrEmail(userRegisterRequest.getUsername(), userRegisterRequest.getEmail());
        if (isExist) {
            return false;
        }
        User user = modelMapper.map(userRegisterRequest, User.class);
        user.setPassword(passwordEncoder.encode(userRegisterRequest.getPassword()));
        userRepository.save(user);
        return true;
    }

    public boolean login(UserLoginRequest userLoginRequest) {
        Optional<User> byUsername = userRepository
                .findByUsername(userLoginRequest.getUsername());

        if (byUsername.isEmpty()) {
            return false;
        }
        User user = byUsername.get();

        if (!passwordEncoder.matches(userLoginRequest.getPassword(), user.getPassword())) {
            return false;
        }

        userSession.login(user);

        return true;
    }
}
