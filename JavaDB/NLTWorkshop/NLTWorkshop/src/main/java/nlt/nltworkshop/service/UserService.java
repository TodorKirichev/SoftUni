package nlt.nltworkshop.service;

import nlt.nltworkshop.web.models.UserLoginModel;
import nlt.nltworkshop.web.models.UserRegisterModel;

public interface UserService {
    boolean validateRegisterModel(UserRegisterModel userRegisterModel);

    void register(UserRegisterModel userRegisterModel);

    boolean loggedIn(UserLoginModel userLoginModel);
}
