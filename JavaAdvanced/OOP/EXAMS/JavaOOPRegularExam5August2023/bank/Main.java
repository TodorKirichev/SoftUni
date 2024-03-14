package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam5August2023.bank;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam5August2023.bank.core.Engine;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam5August2023.bank.core.EngineImpl;

public class Main {
    public static void main(String[] args) {

        Engine engine = new EngineImpl();
        engine.run();
    }
}
