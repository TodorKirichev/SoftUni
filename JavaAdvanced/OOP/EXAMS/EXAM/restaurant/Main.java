package SoftUni.JavaAdvanced.OOP.EXAMS.EXAM.restaurant;

import SoftUni.JavaAdvanced.OOP.EXAMS.EXAM.restaurant.core.Controller;
import SoftUni.JavaAdvanced.OOP.EXAMS.EXAM.restaurant.core.ControllerImpl;
import SoftUni.JavaAdvanced.OOP.EXAMS.EXAM.restaurant.core.Engine;
import SoftUni.JavaAdvanced.OOP.EXAMS.EXAM.restaurant.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
