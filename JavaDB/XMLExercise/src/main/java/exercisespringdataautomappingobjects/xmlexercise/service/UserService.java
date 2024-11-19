package exercisespringdataautomappingobjects.xmlexercise.service;

import exercisespringdataautomappingobjects.xmlexercise.model.dto.UserSeedDto;
import exercisespringdataautomappingobjects.xmlexercise.model.dto.UserViewRootDto;
import exercisespringdataautomappingobjects.xmlexercise.model.entity.User;

import java.util.List;

public interface UserService {

    long getCount();

    void seedUsers(List<UserSeedDto> users);

    User getRandomUser();

    UserViewRootDto findUsersWithMoreThanOneSoldProduct();
}
