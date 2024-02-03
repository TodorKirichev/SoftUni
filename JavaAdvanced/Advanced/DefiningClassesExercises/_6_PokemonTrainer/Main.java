package JavaAdvanced.DefiningClassesExercises._6_PokemonTrainer;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        Map<String,Trainer> trainers = new LinkedHashMap<>();

        while (true) {
            String line = scan.nextLine();
            if (line.equals("Tournament")) {
                break;
            }
            String[] info = line.split("\\s+");
            String trainerName = info[0];
            String pokemonName = info[1];
            String pokemonElement = info[2];
            int pokemonHealth = Integer.parseInt(info[3]);

            Pokemon pokemon = new Pokemon(pokemonName,pokemonElement,pokemonHealth);

            if (trainers.containsKey(trainerName)) {
                trainers.get(trainerName).addPokemon(pokemon);
            } else {
                trainers.put(trainerName,new Trainer(trainerName,pokemon));
            }
        }
        while (true) {
            String line = scan.nextLine();
            if (line.equals("End")) {
                break;
            }
            trainers.forEach((key, value) -> value.checkElement(line));
        }
        trainers.entrySet().stream()
                .sorted((f,s) -> s.getValue().getNumOfBadges() - f.getValue().getNumOfBadges())
                .forEach((entry) -> {
            System.out.printf("%s %d %d\n",entry.getKey(),entry.getValue().getNumOfBadges(),entry.getValue().getCollectionOfPokemon().size());
        });
    }
}
