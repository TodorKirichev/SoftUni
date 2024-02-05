package SoftUni.JavaAdvanced.Advanced.GenericsExercises.CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class CustomList<T extends Comparable<T>> implements Iterable<T>{
    private List<T> data;

    public CustomList() {
        this.data = new ArrayList<>();
    }

    public void add(T element) {
        data.add(element);
    }

    public T remove(int index) {
        return data.remove(index);
    }

    public boolean contains(T element) {
        return data.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        Collections.swap(data, firstIndex, secondIndex);
    }

    public int countGreater(T element) {
        return (int) data.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public T getMax() {
        return Collections.max(data);
    }

    public T getMin() {
        return Collections.min(data);
    }

    public int size() {
        return data.size();
    }

    public T get(int index) {
        return data.get(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        data.forEach(e -> sb.append(e).append("\n"));
        return sb.toString().trim();
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }
}
