package JavaAdvanced.DefiningClassesExercises._9_CatLady;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        Map<String,Cat> cats = new HashMap<>();

        while (true) {
            String line = scan.nextLine();
            if (line.equals("End")) {
                break;
            }
            String[] info = line.split("\\s+");
            String breed = info[0];
            String name = info[1];

            Cat cat = null;

            switch (breed) {
                case "StreetExtraordinaire" :
                    double decibels = Double.parseDouble(info[2]);
                    cat = new StreetExtraordinaire(name,decibels);
                    break;
                case "Cymric" :
                    double furLength = Double.parseDouble(info[2]);
                    cat = new Cymric(name,furLength);
                    break;
                case "Siamese" :
                    double earSize = Double.parseDouble(info[2]);
                    cat = new Siamese(name,earSize);
                    break;
            }
            cats.put(name,cat);
        }
        String breed = scan.nextLine();

        cats.entrySet().stream().filter(c -> c.getKey().equals(breed)).forEach(c -> System.out.println(c.getValue()));
    }
}
