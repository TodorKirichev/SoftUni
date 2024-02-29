package SoftUni.JavaAdvanced.OOP.ReflectionExercises._3_BarracksWars.core.factories;

import SoftUni.JavaAdvanced.OOP.ReflectionExercises._3_BarracksWars.interfaces.Unit;
import SoftUni.JavaAdvanced.OOP.ReflectionExercises._3_BarracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"SoftUni.JavaAdvanced.OOP.ReflectionExercises._3_BarracksWars.units.";

	public Unit createUnit(String unitType) {
		try{
			Class clazz = Class.forName(UNITS_PACKAGE_NAME + unitType);
			Constructor constructor = clazz.getConstructor();
			return (Unit)constructor.newInstance();
		}catch (Exception ex){
			ex.printStackTrace();
		}

		return null;
	}
}
