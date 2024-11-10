package json.service;

import com.google.gson.Gson;
import json.constants.Constants;
import json.model.dto.UserAndProductsDto;
import json.model.dto.UserSeedDto;
import json.model.dto.UserSoldDto;
import json.model.entity.User;
import json.repository.UserRepository;
import json.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static json.constants.Constants.RESOURCE_FILE_PATH;

@Service
public class UserServiceImpl implements UserService {

    public static final String USER_PATH = "users.json";

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }

    @Override
    public void seedUsers() throws IOException {
        if (userRepository.count() > 0) {
            return;
        }

        Arrays.stream(gson.fromJson(Files.readString(Path.of(RESOURCE_FILE_PATH + USER_PATH)), UserSeedDto[].class))
                .filter(validationUtil::isValid)
                .map(user -> modelMapper.map(user, User.class))
                .forEach(userRepository::save);
    }

    @Override
    public User findRandomUser() {
        long randomId = ThreadLocalRandom.current().nextLong(1, userRepository.count() + 1);
        return userRepository.findById(randomId).orElse(null);
    }

    @Override
    public List<UserSoldDto> findAllUsersWithMoreThenOneSoldProduct() {
        return userRepository.findAllUsersWithMoreThanOneSoldProduct().stream()
                .map(user -> modelMapper.map(user, UserSoldDto.class))
                .collect(Collectors.toList());
    }


}
