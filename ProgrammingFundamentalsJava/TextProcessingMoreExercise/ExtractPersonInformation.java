package TextProcessingMoreExercise;

import java.util.Scanner;

public class ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < rows; i++) {
            String data = scan.nextLine();

            int index1 = data.indexOf('@') + 1;
            int index2 = data.indexOf('|');
            int index3 = data.indexOf('#') + 1;
            int index4 = data.indexOf('*');

            String name = data.substring(index1,index2);
            String age = data.substring(index3,index4);

            System.out.printf("%s is %s years old.\n",name,age);
        }
    }
}
