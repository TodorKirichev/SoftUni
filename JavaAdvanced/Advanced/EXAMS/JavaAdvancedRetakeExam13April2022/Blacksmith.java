package SoftUni.JavaAdvanced.Advanced.EXAMS.JavaAdvancedRetakeExam13April2022;

import java.util.*;

public class Blacksmith {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Deque<Integer> steel = new ArrayDeque<>();
        Deque<Integer> carbon = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).forEach(steel::offer);
        Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).forEach(carbon::push);

        Map<String,Integer> swords = fillSwords();


        while (!steel.isEmpty() && ! carbon.isEmpty()) {
            int pieceOfSteel = steel.poll();
            int pieceOfCarbon = carbon.pop();

            int sum = pieceOfSteel + pieceOfCarbon;

            forgeSword(carbon, swords, pieceOfCarbon, sum);
        }
        int totalSwords = swords.values().stream().mapToInt(Integer::intValue).sum();

        printTotalSowrds(totalSwords);
        printSteel(steel);
        printCarbon(carbon);

        swords.entrySet().stream().filter(s -> s.getValue() > 0)
                .forEach(s -> System.out.printf("%s: %d\n",s.getKey(),s.getValue()));
    }

    private static void printCarbon(Deque<Integer> carbon) {
        if (carbon.isEmpty()) {
            System.out.println("Carbon left: none");
        } else {
            StringBuilder sb = new StringBuilder();
            carbon.forEach(c -> sb.append(c).append(" "));
            System.out.printf("Carbon left: %s\n",String.join(", ",sb.toString().split(" ")));
        }
    }

    private static void printSteel(Deque<Integer> steel) {
        if (steel.isEmpty()) {
            System.out.println("Steel left: none");
        } else {
            StringBuilder sb = new StringBuilder();
            steel.forEach(s -> sb.append(s).append(" "));
            System.out.printf("Steel left: %s\n",String.join(", ",sb.toString().split(" ")));
        }
    }

    private static void printTotalSowrds(int totalSwords) {
        if (totalSwords > 0) {
            System.out.printf("You have forged %d swords.\n", totalSwords);
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }
    }

    private static void forgeSword(Deque<Integer> carbon, Map<String, Integer> swords, int pieceOfCarbon, int sum) {
        switch (sum) {
            case 70:
                swords.put("Gladius", swords.get("Gladius") + 1);
                break;
            case 80:
                swords.put("Shamshir", swords.get("Shamshir") + 1);
                break;
            case 90:
                swords.put("Katana", swords.get("Katana") + 1);
                break;
            case 110:
                swords.put("Sabre", swords.get("Sabre") + 1);
                break;
            default:
                carbon.push(pieceOfCarbon + 5);
                break;
        }
    }

    private static Map<String, Integer> fillSwords() {
        Map<String,Integer> swords = new TreeMap<>();
        swords.put("Gladius",0);
        swords.put("Shamshir",0);
        swords.put("Katana",0);
        swords.put("Sabre",0);
        return swords;
    }
}
