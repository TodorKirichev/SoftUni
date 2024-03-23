package SoftUni.JavaAdvanced.OOP.EXAMS.OOPRegularExam11December2021.catHouse;

import SoftUni.JavaAdvanced.OOP.EXAMS.OOPRegularExam11December2021.catHouse.core.Engine;
import SoftUni.JavaAdvanced.OOP.EXAMS.OOPRegularExam11December2021.catHouse.core.EngineImpl;

public class Main {
    public static void main(String[] args) {

        Engine engine = new EngineImpl();
        engine.run();
    }
}
