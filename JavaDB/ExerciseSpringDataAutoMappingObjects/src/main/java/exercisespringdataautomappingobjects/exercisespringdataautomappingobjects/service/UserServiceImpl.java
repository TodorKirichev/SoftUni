package exercisespringdataautomappingobjects.exercisespringdataautomappingobjects.service;

import exercisespringdataautomappingobjects.exercisespringdataautomappingobjects.model.dto.UserLoginDto;
import exercisespringdataautomappingobjects.exercisespringdataautomappingobjects.model.dto.UserRegisterDto;
import exercisespringdataautomappingobjects.exercisespringdataautomappingobjects.model.entity.User;
import exercisespringdataautomappingobjects.exercisespringdataautomappingobjects.repository.UserRepository;
import exercisespringdataautomappingobjects.exercisespringdataautomappingobjects.util.ValidationUtil;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private User loggedUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void register(UserRegisterDto userDto) {
        if (!userDto.getPassword().equals(userDto.getConfirmPassword())) {
            System.out.println("Passwords do not match");
            return;
        }

        Set<ConstraintViolation<UserRegisterDto>> violations = validationUtil.getViolations(userDto);
        if (!violations.isEmpty()) {
            violations.stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return;
        }

        User user = modelMapper.map(userDto, User.class);
        userRepository.save(user);
        System.out.println("User registered successfully");
    }

    @Override
    public void login(UserLoginDto userLoginDto) {
        Set<ConstraintViolation<UserLoginDto>> violations = validationUtil.getViolations(userLoginDto);

        if (!violations.isEmpty()) {
            violations.stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return;
        }

        User user = userRepository.findByEmailAndPassword(userLoginDto.getEmail(), userLoginDto.getPassword()).orElse(null);

        if (user == null) {
            System.out.println("User not found");
            return;
        }

        loggedUser = user;
        System.out.println("Successfully logged in");
    }

    @Override
    public void logout() {
        if (loggedUser == null) {
            System.out.println("Cannot log out. No user was logged in");
        } else {
            System.out.println("Logged out successfully");
            loggedUser = null;
        }
    }
}
