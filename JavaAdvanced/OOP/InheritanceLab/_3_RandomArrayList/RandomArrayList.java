package SoftUni.JavaAdvanced.OOP.InheritanceLab._3_RandomArrayList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class RandomArrayList extends ArrayList {
    private List<Object> data;

    public RandomArrayList() {
        this.data = new ArrayList<>();
    }

    public Object getRandomElement() {
        Random random = new Random();
        int index = random.nextInt(data.size() - 1);
        Object object = data.get(index);
        data.remove(index);
        return object;
    }
}
