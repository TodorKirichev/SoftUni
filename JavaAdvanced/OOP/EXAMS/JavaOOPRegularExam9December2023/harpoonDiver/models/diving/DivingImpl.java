package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam9December2023.harpoonDiver.models.diving;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam9December2023.harpoonDiver.models.diver.Diver;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam9December2023.harpoonDiver.models.divingSite.DivingSite;

import java.util.Collection;

public class DivingImpl implements Diving{
    @Override
    public void searching(DivingSite divingSite, Collection<Diver> divers) {
        for (Diver diver : divers) {
            while (diver.canDive() && divingSite.getSeaCreatures().iterator().hasNext()) {
                diver.shoot();
                String currentCreature = divingSite.getSeaCreatures().iterator().next();
                diver.getSeaCatch().getSeaCreatures().add(currentCreature);
                divingSite.getSeaCreatures().remove(currentCreature);
            }
        }
    }
}
