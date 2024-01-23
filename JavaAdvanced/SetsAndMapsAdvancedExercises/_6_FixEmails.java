package JavaAdvanced.SetsAndMapsAdvancedExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _6_FixEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String,String> emails = new LinkedHashMap<>();

        String name = scan.nextLine();
        while (!name.equals("stop")) {

            String email = scan.nextLine();
            if (!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")) {
                emails.put(name,email);
            }
            name = scan.nextLine();
        }
        emails.forEach((k,v) -> {
            System.out.printf("%s -> %s\n",k,v);
        });
    }
}
