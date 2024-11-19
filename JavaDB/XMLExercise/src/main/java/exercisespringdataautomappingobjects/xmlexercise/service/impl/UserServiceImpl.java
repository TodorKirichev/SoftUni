package exercisespringdataautomappingobjects.xmlexercise.service.impl;

import exercisespringdataautomappingobjects.xmlexercise.model.dto.UserSeedDto;
import exercisespringdataautomappingobjects.xmlexercise.model.dto.UserViewRootDto;
import exercisespringdataautomappingobjects.xmlexercise.model.dto.UserWithProducts;
import exercisespringdataautomappingobjects.xmlexercise.model.entity.User;
import exercisespringdataautomappingobjects.xmlexercise.repository.UserRepository;
import exercisespringdataautomappingobjects.xmlexercise.service.UserService;
import exercisespringdataautomappingobjects.xmlexercise.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public long getCount() {
        return userRepository.count();
    }

    @Override
    public void seedUsers(List<UserSeedDto> users) {
        users.stream()
                .filter(validationUtil::isValid)
                .map(userSeedDto -> modelMapper.map(userSeedDto, User.class))
                .forEach(userRepository::save);
    }

    @Override
    public User getRandomUser() {
        long randomId = ThreadLocalRandom.current().nextLong(1, userRepository.count());
        return userRepository.findById(randomId).orElse(null);
    }

    @Override
    public UserViewRootDto findUsersWithMoreThanOneSoldProduct() {
        UserViewRootDto userViewRootDto = new UserViewRootDto();

        userViewRootDto.setUsers(userRepository.findAllWithMoreThanOneSoldProduct()
                .stream()
                .map(user -> modelMapper.map(user, UserWithProducts.class))
                .collect(Collectors.toList()));
        return userViewRootDto;
    }
}
