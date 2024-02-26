package SoftUni.JavaAdvanced.OOP.SOLID.solidLab.p04_InterfaceSegregation.p02_identity;

import SoftUni.JavaAdvanced.OOP.SOLID.solidLab.p04_InterfaceSegregation.p02_identity.interfaces.Account;
import SoftUni.JavaAdvanced.OOP.SOLID.solidLab.p04_InterfaceSegregation.p02_identity.interfaces.Service;
import SoftUni.JavaAdvanced.OOP.SOLID.solidLab.p04_InterfaceSegregation.p02_identity.interfaces.User;
import SoftUni.JavaAdvanced.OOP.SOLID.solidLab.p04_InterfaceSegregation.p02_identity.interfaces.Validations;

public class AccountManager implements Account, Validations, Service {
    private boolean requireUniqueEmail;

    private int minRequiredPasswordLength;

    private int maxRequiredPasswordLength;


    @Override
    public boolean getRequireUniqueEmail() {
        return this.requireUniqueEmail;
    }

    @Override
    public int getMinRequiredPasswordLength() {
        return this.minRequiredPasswordLength;
    }

    @Override
    public int getMaxRequiredPasswordLength() {
        return this.maxRequiredPasswordLength;
    }

    @Override
    public void register(String username, String password) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void login(String username, String password) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void changePassword(String oldPass, String newPass) {
        //change password
    }

    @Override
    public Iterable<User> getAllUsersOnline() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<User> getAllUsers() {
        throw new UnsupportedOperationException();
    }

    @Override
    public User getUserByName(String name) {
        throw new UnsupportedOperationException();
    }
}
