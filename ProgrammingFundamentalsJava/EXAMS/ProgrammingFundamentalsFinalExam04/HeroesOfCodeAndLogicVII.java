package ProgrammingFundamentalsFinalExam04;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Map<String,Integer> heroHP = new LinkedHashMap<>();
        Map<String,Integer> heroMP = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] heroesData = scan.nextLine().split(" ");
            String hero = heroesData[0];
            int HP = Integer.parseInt(heroesData[1]);
            int MP = Integer.parseInt(heroesData[2]);
            heroHP.put(hero,HP);
            heroMP.put(hero,MP);
        }
        while (true) {
            String input = scan.nextLine();
            if (input.equals("End")) {
                break;
            }
            String[] commandParts = input.split(" - ");
            String command = commandParts[0];
            String hero = commandParts[1];
            if (command.equals("CastSpell")) {
                int neededMP = Integer.parseInt(commandParts[2]);
                String spell = commandParts[3];
                if (heroMP.get(hero) >= neededMP) {
                    heroMP.put(hero,heroMP.get(hero) - neededMP);
                    System.out.printf("%s has successfully cast %s and now has %d MP!\n",hero,spell,heroMP.get(hero));
                } else {
                    System.out.printf("%s does not have enough MP to cast %s!\n",hero,spell);
                }
            } else if (command.equals("TakeDamage")) {
                int damage = Integer.parseInt(commandParts[2]);
                String attacker = commandParts[3];
                heroHP.put(hero,heroHP.get(hero) - damage);
                if (heroHP.get(hero) > 0) {
                    System.out.printf("%s was hit for %d HP by %s and now has %d HP left!\n",hero,damage,attacker,heroHP.get(hero));
                } else {
                    heroHP.remove(hero);
                    heroMP.remove(hero);
                    System.out.printf("%s has been killed by %s!\n",hero,attacker);
                }
            } else if (command.equals("Recharge")) {
                int amountMP = Integer.parseInt(commandParts[2]);
                int initialMP = heroMP.get(hero);
                heroMP.put(hero,heroMP.get(hero) + amountMP);
                if (heroMP.get(hero) > 200) {
                    heroMP.put(hero,200);
                }
                System.out.printf("%s recharged for %d MP!\n",hero,heroMP.get(hero) - initialMP);
            } else if (command.equals("Heal")) {
                int amountHP = Integer.parseInt(commandParts[2]);
                int initialHP = heroHP.get(hero);
                heroHP.put(hero,heroHP.get(hero) + amountHP);
                if (heroHP.get(hero) > 100) {
                    heroHP.put(hero,100);
                }
                System.out.printf("%s healed for %d HP!\n",hero,heroHP.get(hero) - initialHP);
            }
        }
        for (Map.Entry <String,Integer> entry : heroHP.entrySet()) {
            String hero = entry.getKey();
            int HP = entry.getValue();
            int MP = heroMP.get(hero);
            System.out.printf("%s\n" +
                    "  HP: %d\n" +
                    "  MP: %d\n",hero,HP,MP);
        }
    }
}
