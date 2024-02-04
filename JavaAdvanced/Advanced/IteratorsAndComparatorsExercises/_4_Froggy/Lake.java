package Exams.IteratorsAndComparatorsExercises._4_Froggy;

import java.util.Iterator;

public class Lake implements Iterable<Integer>{
    private Integer[] data;
    private int index;

    public Lake(Integer... data) {
        this.data = data;
        this.index = 0;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    public class Frog implements Iterator<Integer> {
        private int currentIndex = index;
        boolean isFirstTimeFinished = false;
        @Override
        public boolean hasNext() {
            return currentIndex < data.length;
        }

        @Override
        public Integer next() {
            Integer element = data[currentIndex];
            currentIndex += 2;
            if (currentIndex >= data.length && !isFirstTimeFinished) {
                currentIndex = 1;
                isFirstTimeFinished = true;
            }
            return element;
        }
    }
}
