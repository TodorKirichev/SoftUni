package JavaAdvanced.DefiningClassesExercises._6_PokemonTrainer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Trainer {
    String trainerName;
    int numOfBadges = 0;
    List<Pokemon> collectionOfPokemon = new ArrayList<>();
    public Trainer(String trainer,Pokemon pokemon) {
        this.trainerName = trainer;
        this.collectionOfPokemon.add(pokemon);

    }
    public String getTrainerName() {
        return trainerName;
    }

    public int getNumOfBadges() {
        return numOfBadges;
    }

    public List<Pokemon> getCollectionOfPokemon() {
        return collectionOfPokemon;
    }
    public void addBadge() {
        this.numOfBadges = getNumOfBadges() + 1;
    }

    public void addPokemon(Pokemon pokemon) {
        this.collectionOfPokemon.add(pokemon);
    }
    public void checkElement(String element) {
        boolean isCollectionContainElement = false;
        for (Pokemon pokemon : getCollectionOfPokemon()) {
            if (pokemon.getElement().equals(element)) {
                addBadge();
                isCollectionContainElement = true;
                break;
            }
        }
        if (!isCollectionContainElement) {
            getCollectionOfPokemon().forEach(pokemon -> pokemon.setHealth(pokemon.getHealth() - 10));
            this.collectionOfPokemon = getCollectionOfPokemon().stream().filter(p -> p.getHealth() > 0).collect(Collectors.toList());
        }
    }
}

