package WhileLoopExercise;

import java.util.Scanner;

public class OldBooks {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String book = scan.nextLine();
        String favBook = scan.nextLine();
        boolean isTrue = true;
        int books = 0;

        while (!favBook.equals(book)) {

            if (favBook.equals("No More Books")) {
                isTrue = false;
                break;
            }
            books++;
            favBook = scan.nextLine();
        }
        if (isTrue) {
            System.out.printf("You checked %d books and found it.", books);
        }else{
            System.out.println("The book you search is not here!");
            System.out.printf("You checked %d books.",books);
        }
    }
}
