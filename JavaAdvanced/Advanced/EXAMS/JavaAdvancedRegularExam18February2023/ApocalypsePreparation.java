package Advanced.EXAMS.JavaAdvancedRegularExam18February2023;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.in;

public class ApocalypsePreparation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        Deque<Integer> textiles = new ArrayDeque<>();
        Deque<Integer> medicaments = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).forEach(textiles::offer);
        Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).forEach(medicaments::push);

        TreeMap<String,Integer> items = new TreeMap<>();
        items.put("Patch",0);
        items.put("Bandage",0);
        items.put("MedKit",0);

        while (!textiles.isEmpty() && !medicaments.isEmpty()) {
            int textile = textiles.poll();
            int medicament = medicaments.pop();
            int result = textile + medicament;

            if (result == 30) {
                items.put("Patch",items.get("Patch") + 1);
            } else if (result == 40) {
                items.put("Bandage",items.get("Bandage") + 1);
            } else if (result == 100) {
                items.put("MedKit",items.get("MedKit") + 1);
            } else if (result > 100) {
                items.put("MedKit",items.get("MedKit") + 1);
                medicaments.push(medicaments.pop() + result - 100);
            } else {
                medicaments.push(medicament + 10);
            }
        }
        if (textiles.isEmpty() && medicaments.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
        } else if (textiles.isEmpty()) {
            System.out.println("Textiles are empty.");
        } else {
            System.out.println("Medicaments are empty.");
        }
        items.entrySet().stream().filter(i -> i.getValue() > 0).sorted((f,s) -> s.getValue().compareTo(f.getValue())).forEach(entry -> {
            System.out.printf("%s - %s\n",entry.getKey(),entry.getValue());
        });
        if (!medicaments.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            medicaments.forEach(m -> sb.append(m).append(" "));
            System.out.printf("Medicaments left: %s\n",String.join(", ",sb.toString().split(" ")));
        }
        if (!textiles.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            textiles.forEach(t -> sb.append(t).append(" "));
            System.out.printf("Textiles left: %s\n",String.join(", ",sb.toString().split(" ")));
        }
    }
}
