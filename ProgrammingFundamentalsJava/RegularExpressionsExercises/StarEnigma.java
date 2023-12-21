package RegularExpressionsExercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.in;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        int n = Integer.parseInt(scan.nextLine());
        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            Pattern pattern = Pattern.compile("[star]");
            Matcher matcher = pattern.matcher(input.toLowerCase());
            int key = 0;
            while (matcher.find()) {
                key++;
            }
            StringBuilder decrypted = new StringBuilder();
            for (char ch : input.toCharArray()) {
                decrypted.append((char)(ch - key));
            }
            Pattern pattern1 = Pattern.compile("@(?<planet>[A-Za-z]+)[^@!:>-]*:(?<population>\\d+)[^@\\-!:>]*!(?<attackType>[AD])![^@\\-!:>]*->(?<soldiers>\\d+)");
            Matcher matcher1 = pattern1.matcher(decrypted);
            if (matcher1.find()) {
                String planet = matcher1.group("planet");
                String attackType = matcher1.group("attackType");
                switch (attackType) {
                    case "A":
                        attackedPlanets.add(planet);
                        break;
                    case "D" :
                        destroyedPlanets.add(planet);
                        break;
                }
            }
        }
        Collections.sort(attackedPlanets);
        Collections.sort(destroyedPlanets);
        System.out.printf("Attacked planets: %d\n",attackedPlanets.size());
        for (String planet : attackedPlanets) {
            System.out.printf("-> %s\n",planet);
        }
        System.out.printf("Destroyed planets: %d\n",destroyedPlanets.size());
        for (String planet : destroyedPlanets) {
            System.out.printf("-> %s\n",planet);
        }
    }
}
