package SoftUni.JavaAdvanced.OOP.UnitTesting.rpg_lab_test;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class HeroTest {
    private static final int TARGET_EXPERIENCE = 10;

    @Test
    public void attacksGivesExperienceWhenTargetIsDead() {
//        Target target = new Target() {
//            @Override
//            public int getHealth() {
//                return 0;
//            }
//
//            @Override
//            public int getExperience() {
//                return 0;
//            }
//
//            @Override
//            public void takeAttack(int attackPoints) {
//
//            }
//
//            @Override
//            public int giveExperience() {
//                return TARGET_EXPERIENCE;
//            }
//
//            @Override
//            public boolean isDead() {
//                return true;
//            }
//        };
//
//        Weapon weapon = new Weapon() {
//            @Override
//            public int getAttackPoints() {
//                return 0;
//            }
//
//            @Override
//            public int getDurabilityPoints() {
//                return 0;
//            }
//
//            @Override
//            public void attack(Target target) {
//
//            }
//        };

        Target target = Mockito.mock(Target.class);
        Weapon weapon = Mockito.mock(Weapon.class);

        Mockito.when(target.isDead()).thenReturn(true);
        Mockito.when(target.giveExperience()).thenReturn(TARGET_EXPERIENCE);

        Hero hero = new Hero("Maven", weapon);

        hero.attack(target);

        Assert.assertEquals(TARGET_EXPERIENCE, hero.getExperience());
    }
}