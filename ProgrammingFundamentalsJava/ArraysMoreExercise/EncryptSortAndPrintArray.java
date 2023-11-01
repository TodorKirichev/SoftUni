package ArraysMoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        String [] array = new String[n];
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scan.nextLine();
            int sum = 0;
            for (int j = 0; j < array[i].length(); j++) {
                char symbol = array[i].charAt(j);
                switch (symbol){
                    case 'a':
                    case 'o':
                    case 'u':
                    case 'i':
                    case 'e':
                    case 'A':
                    case 'O':
                    case 'U':
                    case 'I':
                    case 'E':
                        sum += symbol * array[i].length();
                        break;
                    default:
                        sum += symbol / array[i].length();
                        break;
                }
            }
            numbers[i] = sum;
        }
        Arrays.sort(numbers);
        for (int e : numbers) {
            System.out.println(e);
        }
    }
}
