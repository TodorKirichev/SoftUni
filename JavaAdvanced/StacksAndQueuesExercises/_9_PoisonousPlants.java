package JavaAdvanced.StacksAndQueuesExercises;

import java.util.*;

public class _9_PoisonousPlants {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        List<Integer> plants = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            plants.add(scan.nextInt());
        }
        Deque<Integer> indices = new ArrayDeque<>();
        int days = 0;

        while (true) {
            boolean isNoMoreDeaths = true;
            for (int i = 0; i < plants.size() - 1; i++) {
                int plant = plants.get(i);
                if (plant < plants.get(i + 1)) {
                    indices.push(i + 1);
                    isNoMoreDeaths = false;
                }
            }
            if (isNoMoreDeaths) {
                break;
            }
            for (Integer index : indices) {
                int indexOfPlant = index;
                plants.remove(indexOfPlant);
            }
            days++;
            indices.clear();
        }
        System.out.println(days);
    }
}
