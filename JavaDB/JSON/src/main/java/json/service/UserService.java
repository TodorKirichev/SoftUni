package json.service;

import json.model.dto.UserAndProductsDto;
import json.model.dto.UserSoldDto;
import json.model.entity.User;

import java.io.IOException;
import java.util.List;

public interface UserService {
    void seedUsers() throws IOException;

    User findRandomUser();

    List<UserSoldDto> findAllUsersWithMoreThenOneSoldProduct();

}
