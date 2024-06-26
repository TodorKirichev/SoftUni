package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2020.viceCity.models.guns;

public class Rifle extends BaseGun {
    private static final int BULLETS_PER_BARREL = 50;
    private static final int TOTAL_BULLETS = 500;

    private static final int BULLETS_PER_FIRE = 5;
    public Rifle(String name) {
        super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
        setBulletsPerFire(BULLETS_PER_FIRE);
    }
}
