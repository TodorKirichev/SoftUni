package ProgrammingFundamentalsFinalExamRetake01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        int totalCalories = 0;
        List<String> items = new ArrayList<>();
        List<String> dates = new ArrayList<>();
        List<Integer> calories = new ArrayList<>();

        Pattern pattern = Pattern.compile("([|#])(?<item>[A-Za-z\\s]+)\\1(?<expirationDate>\\d{2}\\/\\d{2}\\/\\d{2})\\1(?<calories>\\d+)\\1");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String item = matcher.group("item");
            String expirationDate = matcher.group("expirationDate");
            int calorie = Integer.parseInt(matcher.group("calories"));
            totalCalories += calorie;
            items.add(item);
            dates.add(expirationDate);
            calories.add(calorie);
        }
        System.out.printf("You have food to last you for: %d days!\n",totalCalories / 2000);
        for (int i = 0; i < items.size(); i++) {
            System.out.printf("Item: %s, Best before: %s, Nutrition: %d\n",items.get(i),dates.get(i),calories.get(i));
        }
    }
}
