package Exams.GenericsLab._1_Jar;

import java.util.ArrayDeque;
import java.util.Deque;

public class Jar <T>{
    Deque<T> data;

    public Jar() {
        this.data = new ArrayDeque<>();
    }
    public void add(T element) {
        data.push(element);
    }
    public T remove() {
        return data.pop();
    }
}
