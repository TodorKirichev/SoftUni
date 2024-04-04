package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2020.easterRaces.io;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2020.easterRaces.io.interfaces.OutputWriter;

public class ConsoleWriter implements OutputWriter {
    @Override
    public void writeLine(String text) {
        System.out.println(text);
    }
}
