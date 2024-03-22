package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam9April2022.fairyShop;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam9April2022.fairyShop.core.Engine;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam9April2022.fairyShop.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
