package Exams.IteratorsAndComparatorsExercises._3_StackIterator;

import java.util.Iterator;
import java.util.function.Consumer;

public class StackIterator implements Iterable<Integer>{
    private Integer[] data;
    private int inedx;

    public StackIterator() {
        this.data = new Integer[16];
        this.inedx = 0;
    }
    public void push(Integer element) {
        data[inedx++] = element;
    }

    public Integer pop() {
        try {
            Integer element = data[inedx - 1];
            data[inedx - 1] = null;
            inedx--;
            return element;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("No elements");
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new CustomIterator();
    }

    public class CustomIterator implements Iterator<Integer>{
        private int currentIndex = inedx;
        @Override
        public boolean hasNext() {
            return currentIndex > 0;
        }

        @Override
        public Integer next() {
            return data[--currentIndex];
        }
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        Iterable.super.forEach(action);
    }
}
