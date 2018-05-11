package com.vlad.datastructures.queue;

import java.util.NoSuchElementException;

public class ArrayQueue<T> implements Queue<T> {
    private static final int INITIAL_CAPACITY = 10;
    private T[] array = (T[]) new Object[INITIAL_CAPACITY];
    private int size;

    ArrayQueue() {
    }

    @Override
    public void enqueue(T value) {
        if (value == null) {
            throw new NullPointerException("Value can not be Null");
        }
        if (size == array.length) {
            increaseArray();
        }
        array[size] = value;
        size++;
    }

    @Override
    public T dequeue() {
        if (size == 0) {
            throw new NoSuchElementException("Queue size = 0");
        }
        T value = (T) array[0];
        System.arraycopy(array, 1, array, 0, size - 1);
        size--;
        return value;
    }

    @Override
    public int getSize() {
        return size;
    }

    private void increaseArray() {
        T[] newArray = (T[]) new Object[(int) (array.length * 1.5) + 1];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    private static class Node<T> {
        private Node<T> next;
        private T value;

        private Node() {
        }

        private Node(T value) {
            this.value = value;
        }
    }

}
