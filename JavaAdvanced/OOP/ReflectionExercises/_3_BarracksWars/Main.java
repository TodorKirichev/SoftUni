package SoftUni.JavaAdvanced.OOP.ReflectionExercises._3_BarracksWars;

import SoftUni.JavaAdvanced.OOP.ReflectionExercises._3_BarracksWars.interfaces.Repository;
import SoftUni.JavaAdvanced.OOP.ReflectionExercises._3_BarracksWars.interfaces.Runnable;
import SoftUni.JavaAdvanced.OOP.ReflectionExercises._3_BarracksWars.interfaces.UnitFactory;
import SoftUni.JavaAdvanced.OOP.ReflectionExercises._3_BarracksWars.core.Engine;
import SoftUni.JavaAdvanced.OOP.ReflectionExercises._3_BarracksWars.core.factories.UnitFactoryImpl;
import SoftUni.JavaAdvanced.OOP.ReflectionExercises._3_BarracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
