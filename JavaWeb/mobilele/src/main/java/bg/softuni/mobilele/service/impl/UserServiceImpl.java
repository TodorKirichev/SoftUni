package bg.softuni.mobilele.service.impl;

import bg.softuni.mobilele.model.UserRegistrationDto;
import bg.softuni.mobilele.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void registerUser(UserRegistrationDto userRegistrationDto) {

        System.out.println("The user is : " + userRegistrationDto);
    }
}
