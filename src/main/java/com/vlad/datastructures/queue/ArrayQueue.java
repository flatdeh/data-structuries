package com.vlad.datastructures.queue;

import java.util.NoSuchElementException;

public class ArrayQueue<T> extends AbstractQueue<T> {

    ArrayQueue() {
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
        T value = (T) array[0];
        System.arraycopy(array, 1, array, 0, size - 1);
        size--;
        return value;
    }

    @Override
    public int getSize() {
        return size;
    }
}
