package SoftUni.JavaAdvanced.OOP.InterfacesAndAbstractionExercises._6_MilitaryElite;


import SoftUni.JavaAdvanced.OOP.InterfacesAndAbstractionExercises._6_MilitaryElite.calsses.*;
import SoftUni.JavaAdvanced.OOP.InterfacesAndAbstractionExercises._6_MilitaryElite.interfaces.Soldier;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<Soldier> soldiers = new ArrayList<>();

        String line = scan.nextLine();

        while (!"End".equals(line)) {

            String[] soldierInfo = line.split("\\s+");
            String soldierType = soldierInfo[0];
            int id = Integer.parseInt(soldierInfo[1]);
            String firstName = soldierInfo[2];
            String lastName = soldierInfo[3];

            switch (soldierType) {
                case "Private":
                    PrivateImpl priv = new PrivateImpl(id, firstName, lastName, Double.parseDouble(soldierInfo[4]));
                    soldiers.add(priv);
                    break;
                case "LieutenantGeneral":
                    LieutenantGeneralImpl lieutenantGeneral = new LieutenantGeneralImpl(id, firstName, lastName
                            , Double.parseDouble(soldierInfo[4]));
                    for (int i = 5; i < soldierInfo.length; i++) {
                        int privId = Integer.parseInt(soldierInfo[i]);
                        PrivateImpl privX = (PrivateImpl) soldiers.stream()
                                .filter(s -> s.getId() == privId).findFirst().get();
                        lieutenantGeneral.addPrivate(privX);
                    }
                    soldiers.add(lieutenantGeneral);
                    break;
                case "Engineer":
                    try {
                        EngineerImpl engineer = new EngineerImpl(id, firstName, lastName
                                , Double.parseDouble(soldierInfo[4]), soldierInfo[5]);
                        for (int i = 6; i < soldierInfo.length; i += 2) {
                            String partName = soldierInfo[i];
                            int hours = Integer.parseInt(soldierInfo[i + 1]);
                            Repair repair = new Repair(partName, hours);
                            engineer.addRepair(repair);
                        }
                        soldiers.add(engineer);
                    } catch (IllegalArgumentException ignored) {
                        line = scan.nextLine();
                        continue;
                    }
                    break;
                case "Commando":
                    try {
                        CommandoImpl commando = new CommandoImpl(id, firstName, lastName
                                , Double.parseDouble(soldierInfo[4]), soldierInfo[5]);
                        for (int i = 6; i < soldierInfo.length; i += 2) {
                            String codeName = soldierInfo[i];
                            String state = soldierInfo[i + 1];
                            try {
                                Mission mission = new Mission(codeName, state);
                                commando.addMission(mission);
                            } catch (IllegalArgumentException ignored) {

                            }
                        }
                        soldiers.add(commando);
                    } catch (IllegalArgumentException ignored) {
                        line = scan.nextLine();
                        continue;
                    }
                    break;
                case "Spy":
                    String codeNumber = soldierInfo[4];
                    SpyImpl spy = new SpyImpl(id, firstName, lastName, codeNumber);
                    soldiers.add(spy);
                    break;
            }
            line = scan.nextLine();
        }
        soldiers.forEach(System.out::println);
    }
}
