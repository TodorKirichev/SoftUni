package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam14August2022.football;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam14August2022.football.core.Engine;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam14August2022.football.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
