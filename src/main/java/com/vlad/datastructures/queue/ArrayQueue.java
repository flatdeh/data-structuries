package com.vlad.datastructures.queue;

import java.util.NoSuchElementException;

public class ArrayQueue<T> implements Queue<T> {
    private final static int INITIAL_CAPACITY = 10;
    private T[] array = (T[]) new Object[INITIAL_CAPACITY];
    private int size;

    private void increaseArray() {
        T[] newArray = (T[]) new Object[(int) (size * 1.5)];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    @Override
    public void enqueue(T value) {
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
        T value = array[0];
        System.arraycopy(array, 1, array, 0, size - 1);
        size--;
        return value;
    }

    @Override
    public int getSize() {
        return size;
    }
}
