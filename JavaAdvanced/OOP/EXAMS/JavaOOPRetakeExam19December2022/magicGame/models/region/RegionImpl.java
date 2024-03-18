package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2022.magicGame.models.region;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2022.magicGame.models.magicians.Magician;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class RegionImpl implements Region {
    @Override
    public String start(Collection<Magician> magicians) {
        List<Magician> wizards = magicians
                .stream()
                .filter(m -> m.getClass().getSimpleName().equals("Wizard"))
                .collect(Collectors.toList());
        List<Magician> blackWidows = magicians
                .stream()
                .filter(m -> m.getClass().getSimpleName().equals("BlackWidow"))
                .collect(Collectors.toList());

        boolean isAnyWizardAlive = wizards
                .stream().anyMatch(Magician::isAlive);
        boolean isAnyBlackWidowsAlive = blackWidows
                .stream().anyMatch(Magician::isAlive);

        String output = null;

        while (isAnyWizardAlive && isAnyBlackWidowsAlive) {
            for (Magician wizard : wizards) {
                if (wizard.isAlive() && wizard.getMagic().getBulletsCount() > 1) {
                    int damage = wizard.getMagic().fire();
                    blackWidows.forEach(b -> b.takeDamage(damage));
                    isAnyBlackWidowsAlive = blackWidows
                            .stream().anyMatch(Magician::isAlive);
                    if (!isAnyBlackWidowsAlive) {
                        output = "Wizards win!";
                    }
                }
            }
            for (Magician blackWidow : blackWidows) {
                if (blackWidow.isAlive() && blackWidow.getMagic().getBulletsCount() > 10) {
                    int damage = blackWidow.getMagic().fire();
                    wizards.forEach(w -> w.takeDamage(damage));
                    isAnyWizardAlive = wizards
                            .stream().anyMatch(Magician::isAlive);
                    if (!isAnyWizardAlive) {
                        output = "Black widows win!";
                    }
                }
            }
        }
        return output;
    }
}
