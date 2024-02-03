package JavaAdvanced.SetsAndMapsAdvancedLab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _2_SoftUniParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<String> VIP = new TreeSet<>();
        Set<String> regular = new TreeSet<>();

        while (true) {
            String guest = scan.nextLine();
            if (guest.equals("PARTY")) {
                break;
            }
            if (isVIP(guest)) {
                VIP.add(guest);
            } else  {
                regular.add(guest);
            }

        }
        while (true) {
            String guest = scan.nextLine();
            if (guest.equals("END")) {
                break;
            }
            VIP.remove(guest);
            regular.remove(guest);
        }
        System.out.println(VIP.size() + regular.size());
        VIP.forEach(System.out::println);
        regular.forEach(System.out::println);
    }

    private static boolean isVIP(String guest) {
        return Character.isDigit(guest.charAt(0));
    }
}
