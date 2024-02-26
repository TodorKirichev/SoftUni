package SoftUni.JavaAdvanced.OOP.SOLID.solidLab.p04_InterfaceSegregation.p02_identity;

import SoftUni.JavaAdvanced.OOP.SOLID.solidLab.p04_InterfaceSegregation.p02_identity.interfaces.Account;

public class AccountController {
    private final Account account;

    public AccountController(Account account) {
        this.account = account;
    }
    public void changePassword(String oldPass,String newPass){
        this.account.changePassword(oldPass,newPass);
    }
}
