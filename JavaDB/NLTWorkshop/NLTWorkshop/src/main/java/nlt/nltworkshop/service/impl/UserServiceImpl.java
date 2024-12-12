package nlt.nltworkshop.service.impl;

import nlt.nltworkshop.data.entity.User;
import nlt.nltworkshop.data.repository.UserRepository;
import nlt.nltworkshop.service.UserService;
import nlt.nltworkshop.web.models.UserLoginModel;
import nlt.nltworkshop.web.models.UserRegisterModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean validateRegisterModel(UserRegisterModel userRegisterModel) {
        return userRegisterModel.getPassword().equals(userRegisterModel.getConfirmPassword()) &&
                userRepository.findByUsername(userRegisterModel.getUsername()).isEmpty() &&
                userRepository.findByEmail(userRegisterModel.getEmail()).isEmpty();
    }

    @Override
    public void register(UserRegisterModel userRegisterModel) {
        userRepository.saveAndFlush(modelMapper.map(userRegisterModel, User.class));
    }

    @Override
    public boolean loggedIn(UserLoginModel userLoginModel) {
        if (userRepository.findByUsernameAndPassword(userLoginModel.getUsername(), userLoginModel.getPassword()).isEmpty()) {
            return false;
        }
        return true;
    }
}
