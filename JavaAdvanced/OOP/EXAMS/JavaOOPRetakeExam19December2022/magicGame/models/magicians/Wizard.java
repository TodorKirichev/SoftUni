package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2022.magicGame.models.magicians;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2022.magicGame.models.magics.Magic;

public class Wizard extends MagicianImpl {
    public Wizard(String username, int health, int protection, Magic magic) {
        super(username, health, protection, magic);
    }
}
