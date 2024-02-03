package JavaAdvanced.DefiningClassesExercises._7_Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    String personName;
    Company company;
    Car car;
    List<Pokemon> pokemons = new ArrayList<>();
    List<Parent> parents = new ArrayList<>();
    List<Children> childrens = new ArrayList<>();
    public Person(String personName) {
        this.personName = personName;

    }
    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(String companyName,String department,double salary) {
        this.company = new Company(companyName,department,salary);
    }

    public Car getCar() {
        return car;
    }

    public void setCar(String model,String speed) {
        this.car = new Car(model,speed);
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void addPokemons(String pokemonName,String type) {
        this.pokemons.add(new Pokemon(pokemonName,type));
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void addParents(String parentName,String parentBirthday) {
        this.parents.add(new Parent(parentName,parentBirthday));
    }

    public List<Children> getChildrens() {
        return childrens;
    }

    public void addChildrens(String childrenName,String childrenBirthday) {
        this.childrens.add(new Children(childrenName,childrenBirthday));
    }
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        output.append(getPersonName()).append(System.lineSeparator());
        output.append("Company:\n");
        if (getCompany() != null) {
            output.append(company);
        }
        output.append("Car:\n");
        if (getCar() != null) {
            output.append(car);
        }
        output.append("Pokemon:\n");
        getPokemons().forEach(output::append);
        output.append("Parents:\n");
        getParents().forEach(output::append);
        output.append("Children:\n");
        getChildrens().forEach(output::append);

        return output.toString();
    }
}
