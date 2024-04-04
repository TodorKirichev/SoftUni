package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2020.viceCity.models.neighbourhood;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2020.viceCity.models.guns.Gun;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2020.viceCity.models.players.Player;

import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Collectors;

public class GangNeighbourhood implements Neighbourhood {
    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        Collection<Gun> guns = mainPlayer.getGunRepository().getModels();
        Iterator<Gun> gunIterator = guns.iterator();
        while (gunIterator.hasNext()) {
            Gun gun = gunIterator.next();
            for (Player civilPlayer : civilPlayers) {
                while (civilPlayer.isAlive() && gun.canFire()) {
                    civilPlayer.takeLifePoints(gun.fire());
                }
            }
        }
        civilPlayers = civilPlayers.stream().filter(Player::isAlive).collect(Collectors.toList());
        for (Player civilPlayer : civilPlayers) {
            Iterator<Gun> civilGuns = civilPlayer.getGunRepository().getModels().iterator();
            while (civilGuns.hasNext()) {
                Gun gun = civilGuns.next();
                while (gun.canFire()) {
                    mainPlayer.takeLifePoints(gun.fire());
                    if (!mainPlayer.isAlive()) {
                        return;
                    }
                }
            }
        }
    }
}
