package JavaAdvanced.DefiningClassesExercises._7_Google;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        Map<String,Person> persons = new LinkedHashMap<>();

        while (true) {
            String line = scan.nextLine();
            if (line.equals("End")) {
                break;
            }
            String[] info = line.split("\\s+");

            String personName = info[0];

            if (!persons.containsKey(personName)) {
                persons.put(personName,new Person(personName));
            }
            switch (info[1]) {
                case "company":
                    String companyName = info[2];
                    String department = info[3];
                    double salary = Double.parseDouble(info[4]);
                    persons.get(personName).setCompany(companyName,department,salary);
                    break;
                case "pokemon":
                    String pokemonName = info[2];
                    String type = info[3];
                    persons.get(personName).addPokemons(pokemonName,type);
                    break;
                case "parents":
                    String parentName = info[2];
                    String parentBirthday = info[3];
                    persons.get(personName).addParents(parentName,parentBirthday);
                    break;
                case "children":
                    String childrenName = info[2];
                    String childrenBirthday = info[3];
                    persons.get(personName).addChildrens(childrenName,childrenBirthday);
                    break;
                case "car":
                    String model = info[2];
                    String speed = info[3];
                    persons.get(personName).setCar(model,speed);
                    break;
            }
        }
        String name = scan.nextLine();

        System.out.println(persons.get(name));
    }
}
