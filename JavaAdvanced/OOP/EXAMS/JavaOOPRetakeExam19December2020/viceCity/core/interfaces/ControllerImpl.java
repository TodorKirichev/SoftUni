package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2020.viceCity.core.interfaces;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2020.viceCity.models.guns.Gun;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2020.viceCity.models.guns.Pistol;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2020.viceCity.models.guns.Rifle;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2020.viceCity.models.players.CivilPlayer;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2020.viceCity.models.players.Player;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2020.viceCity.repositories.GunRepository;

import java.util.ArrayDeque;
import java.util.Deque;

import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2020.viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private Deque<Player> civilPlayers;
    private GunRepository gunRepository;

    public ControllerImpl() {
        civilPlayers = new ArrayDeque<>();
        gunRepository = new GunRepository();
    }

    @Override
    public String addPlayer(String name) {
        Player player = new CivilPlayer(name);
        civilPlayers.offer(player);
        return String.format(PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun;
        switch (type) {
            case "Pistol":
                gun = new Pistol(name);
                break;
            case "Rifle":
                gun = new Rifle(name);
                break;
            default:
                return GUN_TYPE_INVALID;
        }
        return String.format(GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {
        return null;
    }

    @Override
    public String fight() {
        return null;
    }
}
