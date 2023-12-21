package RegularExpressionsExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.in;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        String[] demons = scan.nextLine().replaceAll(" ","").split(",");
        Pattern patternForHealth = Pattern.compile("[^\\d+*/.-]");
        Pattern patternForDamage = Pattern.compile("-?\\d+\\.?\\d*");


        for (String name : demons) {
            int health = 0;
            double damage = 0;
            Matcher matcherForHealth = patternForHealth.matcher(name);
            while (matcherForHealth.find()) {
                health += matcherForHealth.group().charAt(0);
            }
            Matcher matcherForDamage = patternForDamage.matcher(name);
            while (matcherForDamage.find()) {
                damage += Double.parseDouble(matcherForDamage.group());
            }
            for (char ch : name.toCharArray()) {
                if (ch == '*') {
                    damage *= 2;
                } else if (ch == '/'){
                    damage /= 2;
                }
            }
            System.out.printf("%s - %d health, %.2f damage\n",name,health,damage);
        }
    }
}
