package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2021.spaceStation;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2021.spaceStation.core.ControllerImpl;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2021.spaceStation.core.Engine;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2021.spaceStation.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl(new ControllerImpl());
        engine.run();
    }
}
