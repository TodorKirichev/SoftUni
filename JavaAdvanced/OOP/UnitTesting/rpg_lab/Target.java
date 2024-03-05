package SoftUni.JavaAdvanced.OOP.UnitTesting.rpg_lab;

public interface Target {
    int getHealth();

    int getExperience();

    void takeAttack(int attackPoints);

    int giveExperience();

    boolean isDead();
}
