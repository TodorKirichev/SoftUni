package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2022.magicGame.models.magics;

public class RedMagic extends MagicImpl {
    public RedMagic(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (getBulletsCount() < 1) {
            setBulletsCount(0);
            return 0;
        }
        setBulletsCount(getBulletsCount() - 1);
        return 1;
    }
}
