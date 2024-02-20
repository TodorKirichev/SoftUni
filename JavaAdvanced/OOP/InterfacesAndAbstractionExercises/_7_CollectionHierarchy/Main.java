package SoftUni.JavaAdvanced.OOP.InterfacesAndAbstractionExercises._7_CollectionHierarchy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myList = new MyListImpl();

        String[] elements = scan.nextLine().split("\\s+");
        int n = Integer.parseInt(scan.nextLine());

        add(addCollection, elements);
        add(addRemoveCollection, elements);
        add(myList, elements);


        remove(addRemoveCollection, n);
        remove(myList, n);
    }

    private static void remove(AddRemovable addRemovable, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(addRemovable.remove() + " ");
        }
        System.out.println();
    }

    private static void add(Addable addable, String[] elements) {
        for (String element : elements) {
            System.out.print(addable.add(element) + " ");
        }
        System.out.println();
    }
}
