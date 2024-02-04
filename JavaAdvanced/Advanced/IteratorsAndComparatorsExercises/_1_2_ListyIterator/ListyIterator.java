package Exams.IteratorsAndComparatorsExercises._1_2_ListyIterator;

import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String>{
    private List<String> data;
    private int index;

    public ListyIterator(String... data) {
        this.data = List.of(data);
        this.index = 0;
    }

    public boolean Move() {
        if (hasNext()) {
            index++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return index < data.size() - 1;
    }

    public void Print() {
        if (!data.isEmpty()) {
            System.out.println(data.get(index));
        } else {
            System.out.println("Invalid Operation!");
        }
    }

    public void PrintAll() {
        Iterator<String> it = data.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return index < data.size() - 1;
            }

            @Override
            public String next() {
                return data.get(index++);
            }
        };
    }
}
