package Advanced.WorkshopExercise;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class DoublyLinkedList {
    private class Node {
        private Node next;
        private Node prev;
        private int value;
        private Node (int i) {
            value = i;
        }
    }
    private Node head;
    private Node tail;
    private int size;
    public void addFirst(int number) {
        Node newNode = new Node(number);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }
    public void addLast(int number) {
        if (isEmpty()) {
            addFirst(number);
        } else {
            Node newNode = new Node(number);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }
    public int removeFirst() {
        isRemovingPossible();
        int element = head.value;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        size--;
        return element;
    }
    public int removeLast() {
        isRemovingPossible();
        int element = tail.value;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
        }
        size--;
        return element;
    }

    public int get(int index) {
        int element;
        Node current ;
        validateIndex(index);
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            element = current.value;
        } else {
            current = tail;
            for (int i = 0; i < size - 1 - index - 1; i++) {
                current = current.prev;
            }
            element = current.value;
        }
        return element;
    }
    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < size - 1; i++) {
            consumer.accept(head.value);
            head = head.next;
        }
    }
    public int[] toArray() {
        int[] temporary = new int[size - 1];
        for (int i = 0; i < size - 1; i++) {
            temporary[i] = head.value;
            head = head.next;
        }
        return temporary;
    }
    private void isRemovingPossible() {
        if (head == null || tail == null) {
            throw new NoSuchElementException("There are no elements inside");
        }
    }
    private void validateIndex(int index) {
        if (index < 0 || index >= size - 1) {
            throw new IndexOutOfBoundsException("Invalid Index");
        }
    }
    private boolean isEmpty() {
        return size == 0;
    }
}








