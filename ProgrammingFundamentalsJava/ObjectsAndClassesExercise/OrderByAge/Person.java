package ObjectsAndClassesExercise.OrderByAge;

public class Person {
    String name;
    String ID;
    int age;

    public Person(String name, String ID, int age) {
        this.name = name;
        this.ID = ID;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public int getAge() {
        return age;
    }
}
