package TextProcessingMoreExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HTML {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> htmlData = new ArrayList<>();

        String title = scan.nextLine();
        htmlData.add(title);
        String content = scan.nextLine();
        htmlData.add(content);

        String command = scan.nextLine();

        while (!command.equals("end of comments")) {
            htmlData.add(command);
            command = scan.nextLine();
        }
        System.out.printf("<h1>\n    %s\n</h1>\n",htmlData.get(0));
        System.out.printf("<article>\n    %s\n</article>\n",htmlData.get(1));
        for (int i = 2; i < htmlData.size(); i++) {
            System.out.printf("<div>\n    %s\n</div>\n",htmlData.get(i));
        }
    }
}
