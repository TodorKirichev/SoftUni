package ObjectsAndClassesExercise.Articles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String [] input = scan.nextLine().split(", ");
        String title = input[0];
        String content = input[1];
        String author = input[2];

        Articles article = new Articles(title,content,author);

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String [] command = scan.nextLine().split(": ");
            String commandName = command[0];
            String commandArgs = command[1];

            switch (commandName) {
                case "Edit":
                    article.edit(commandArgs);
                    break;
                case "ChangeAuthor":
                    article.changeAuthor(commandArgs);
                    break;
                case "Rename":article.rename(commandArgs);
                    break;
            }
        }
        System.out.println(article.toString());
    }
}
