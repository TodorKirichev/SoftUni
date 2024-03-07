package SoftUni.JavaAdvanced.OOP.UnitTesting.rpg_lab_test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DummyTest {
    private Dummy aliveDummy;

    private Dummy deadDummy;

    private static final int DUMMY_HEALTH = 10;

    private static final int DUMMY_EXPERIENCE = 10;

    private static final int ATTACK_POINTS_TO_TAKE = 10;


    @Before
    public void setup() {
        aliveDummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
        deadDummy = new Dummy(DUMMY_HEALTH - DUMMY_HEALTH, DUMMY_EXPERIENCE);
    }

    @Test
    public void DummyLosesHealthWhenAttacked() {

        aliveDummy.takeAttack(ATTACK_POINTS_TO_TAKE);

        Assert.assertEquals(DUMMY_HEALTH - ATTACK_POINTS_TO_TAKE, aliveDummy.getHealth());
    }
    @Test(expected = IllegalStateException.class)
    public void DeadDummyThrowsExceptionWhenAttacked() {

        deadDummy.takeAttack(ATTACK_POINTS_TO_TAKE);
    }
    @Test
    public void DeadDummyGivesExperience() {

        int experience = deadDummy.giveExperience();

        Assert.assertEquals(DUMMY_EXPERIENCE, experience);
    }
    @Test(expected = IllegalStateException.class)
    public void AliveDummyCantGiveExperience() {

        aliveDummy.giveExperience();
    }
}