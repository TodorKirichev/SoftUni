package SoftUni.JavaAdvanced.OOP.SOLID.solidLab.p04_InterfaceSegregation.p02_identity.interfaces;

public interface Service {
    Iterable<User> getAllUsersOnline();

    Iterable<User> getAllUsers();

    User getUserByName(String name);
}
