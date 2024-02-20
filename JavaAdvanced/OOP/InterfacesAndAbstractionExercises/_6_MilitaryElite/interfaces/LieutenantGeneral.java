package SoftUni.JavaAdvanced.OOP.InterfacesAndAbstractionExercises._6_MilitaryElite.interfaces;

import SoftUni.JavaAdvanced.OOP.InterfacesAndAbstractionExercises._6_MilitaryElite.calsses.PrivateImpl;

import java.util.List;

public interface LieutenantGeneral extends Private{
    void addPrivate(PrivateImpl priv);
    List<PrivateImpl> getPrivates();
}
