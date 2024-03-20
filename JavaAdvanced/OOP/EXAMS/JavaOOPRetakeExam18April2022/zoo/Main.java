package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2022.zoo;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2022.zoo.core.Engine;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2022.zoo.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
