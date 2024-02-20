package SoftUni.JavaAdvanced.OOP.InterfacesAndAbstractionExercises._5_Telephony;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("\\d");

        for (String url : urls) {
            Matcher matcher = pattern.matcher(url);
            if (matcher.find()) {
                sb.append("Invalid URL!\n");
            } else {
                sb.append(String.format("Browsing: %s!\n",url));
            }
        }
        return sb.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("\\b\\d+\\b");

        for (String number : numbers) {
            Matcher matcher = pattern.matcher(number);
            if (matcher.find()) {
                sb.append(String.format("Calling... %s\n",matcher.group()));
            } else {
                sb.append("Invalid number!\n");
            }
        }
        return sb.toString().trim();
    }
}
