package SoftUni.JavaAdvanced.Advanced.EXAMS.JavaAdvancedRetakeExam14April2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

import static java.lang.System.in;

public class Bouquets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        Deque<Integer> daffodils = new ArrayDeque<>();
        Deque<Integer> tulips = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt).forEach(daffodils::push);
        Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt).forEach(tulips::offer);
        
        int bouquetsCreated = 0;
        int storedFlowers = 0;
        
        while (!daffodils.isEmpty() && !tulips.isEmpty()) {
            int daffodil = daffodils.pop();
            int tulip = tulips.poll();
            int sum = daffodil + tulip;

            if (sum == 15) {
                bouquetsCreated++;
            } else if (sum > 15) {
                while (sum > 15) {
                    tulip -= 2;
                    sum = tulip + daffodil;
                }
                if (sum == 15) {
                    bouquetsCreated++;
                } else {
                    storedFlowers += sum;
                }
            } else storedFlowers += sum;
        }
        bouquetsCreated += storedFlowers / 15;
        if (bouquetsCreated < 5) {
            System.out.printf("You failed... You need more %d bouquets.\n",5 - bouquetsCreated);
        } else {
            System.out.printf("You made it! You go to the competition with %d bouquets!\n",bouquetsCreated);
        }
    }
}
