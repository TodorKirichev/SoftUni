package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2020.viceCity;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2020.viceCity.core.EngineImpl;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2020.viceCity.core.interfaces.Controller;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2020.viceCity.core.interfaces.Engine;

public class Main {
    public static void main(String[] args) {
        Controller controller = null; // TODO
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
