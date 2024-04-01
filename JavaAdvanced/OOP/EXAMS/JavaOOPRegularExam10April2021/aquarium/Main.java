package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10April2021.aquarium;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10April2021.aquarium.core.Engine;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10April2021.aquarium.core.EngineImpl;


public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
