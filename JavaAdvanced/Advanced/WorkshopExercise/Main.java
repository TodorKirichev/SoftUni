package Advanced.WorkshopExercise;

import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        DoublyLinkedList list = new DoublyLinkedList();

       list.addLast(1);
       list.addLast(2);
       list.addLast(3);
       list.addLast(4);
       list.addLast(5);

        for (int i : list.toArray()) {
            System.out.println(i);
        }


    }
}
