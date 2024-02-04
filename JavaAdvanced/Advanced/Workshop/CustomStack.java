package Advanced.Workshop;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class CustomStack {
    private static final int INITIAL_CAPACITY = 4;
    private int[] data;
    private int size;
    private int capacity;

    public CustomStack() {
        this.capacity = INITIAL_CAPACITY;
        this.data = new int[this.capacity];
    }
    public int size() {
        return this.size;
    }
    public void push(int element) {
        if (this.size == this.capacity) {
            resize();
        }
        this.data[this.size] = element;
        size++;
    }
    public int pop() {
        isEmpty();
        if (this.size <= this.capacity / 4) {
            shrink();
        }
        int removedElement = this.data[this.size - 1];
        this.data[this.size - 1] = 0;
        this.size--;
        return removedElement;
    }
    public int peek() {
        isEmpty();
        return this.data[this.size - 1];
    }
    public void forEach(Consumer<Integer> consumer) {
        for (int i = this.size - 1; i >= 0; i--) {
            consumer.accept(this.data[i]);
        }
    }

    private void isEmpty() {
        if (this.size == 0) {
            throw new NoSuchElementException ("Stack Is Empty");
        }
    }

    private void shrink() {
        this.capacity /= 2;
        int[] temporary = new int[this.capacity];
        for (int i = 0; i < this.size; i++) {
            temporary[i] = this.data[i];
        }
        this.data = temporary;
    }

    private void resize() {
        this.capacity *= 2;
        int[] temporary = new int[this.capacity];
        for (int i = 0; i < this.size; i++) {
            temporary[i] = this.data[i];
        }
        this.data = temporary;
    }
}
