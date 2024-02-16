package SoftUni.JavaAdvanced.Advanced.EXAMS.JavaAdvancedRegularExam26Oct2019.Rabbits;

public class Rabbit {
    private String name;
    private String species;
    private boolean available;

    public Rabbit(String name, String species) {
        this.name = name;
        this.species = species;
        this.available = true;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean bol) {
        this.available = bol;
    }
    @Override
    public String toString() {
        return String.format("Rabbit (%s): %s",species,name);
    }
}
