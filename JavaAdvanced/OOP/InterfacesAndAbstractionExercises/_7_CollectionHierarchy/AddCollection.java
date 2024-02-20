package SoftUni.JavaAdvanced.OOP.InterfacesAndAbstractionExercises._7_CollectionHierarchy;

public class AddCollection extends Collection implements Addable{
    @Override
    public int add(String element) {
        getItems().add(element);
        return getItems().size() - 1;
    }
}
