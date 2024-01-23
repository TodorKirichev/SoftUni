package JavaAdvanced.DefiningClassesExercises._7_Google;

public class Pokemon {
    String pokemonName;
    String type;

    public Pokemon(String pokemonName, String type) {
        this.pokemonName = pokemonName;
        this.type = type;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return String.format("%s %s\n",getPokemonName(),getType());
    }
}
