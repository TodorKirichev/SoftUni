package Exams.GenericsLab._4_ListUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        List<Integer> numbers = new ArrayList<>();

        Collections.addAll(numbers,1,2,3,3,4);

        System.out.println(ListUtils.getMax(numbers));
    }
}
