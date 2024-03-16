package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam8April2023.robotService;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam8April2023.robotService.core.Engine;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam8April2023.robotService.core.EngineImpl;

public class Main {
    public static void main(String[] args) {

        Engine engine = new EngineImpl();
        engine.run();
    }
}
