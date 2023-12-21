package ObjectsAndClassesLab;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> text = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());
        int length = text.size();

        for (int i = 0; i < length; i++) {
            Random rnd = new Random();
            int index = rnd.nextInt(text.size());
            System.out.println(text.get(index));
            text.remove(index);
        }
    }
}
