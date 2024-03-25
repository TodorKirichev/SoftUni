package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2021.glacialExpedition;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2021.glacialExpedition.core.Controller;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2021.glacialExpedition.core.ControllerImpl;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2021.glacialExpedition.core.Engine;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2021.glacialExpedition.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
