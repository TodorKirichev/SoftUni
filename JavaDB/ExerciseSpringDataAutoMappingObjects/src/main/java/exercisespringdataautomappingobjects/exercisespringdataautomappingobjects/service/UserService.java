package exercisespringdataautomappingobjects.exercisespringdataautomappingobjects.service;

import exercisespringdataautomappingobjects.exercisespringdataautomappingobjects.model.dto.UserLoginDto;
import exercisespringdataautomappingobjects.exercisespringdataautomappingobjects.model.dto.UserRegisterDto;

public interface UserService {
    void register(UserRegisterDto userDto);

    void login(UserLoginDto userLoginDto);

    void logout();
}
