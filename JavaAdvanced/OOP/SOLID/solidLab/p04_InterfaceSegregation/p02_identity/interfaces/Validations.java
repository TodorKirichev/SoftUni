package SoftUni.JavaAdvanced.OOP.SOLID.solidLab.p04_InterfaceSegregation.p02_identity.interfaces;

public interface Validations {
    boolean getRequireUniqueEmail();

    int getMinRequiredPasswordLength();

    int getMaxRequiredPasswordLength();
}
