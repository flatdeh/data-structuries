package com.vlad.datastructures.stack;

import java.util.NoSuchElementException;

public class ArrayStack<T> implements Stack<T> {
    private static final int INITIAL_CAPACITY = 10;
    private T[] array = (T[]) new Object[INITIAL_CAPACITY];
    private int size;

    @Override
    public void push(T value) {
        if (size == array.length) {
            increaseArray();
        }
        array[size] = value;
        size++;
    }

    private void increaseArray() {
        T[] newArray = (T[]) new Object[(int) (size * 1.5)];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    @Override
    public T peek() {
        if (size == 0) {
            throw new NoSuchElementException("Nothing to peek");
        }
        return array[size - 1];
    }

    @Override
    public T pop() {
        if (size == 0) {
            throw new NoSuchElementException("Nothing to pop");
        }
        T value = array[size - 1];
        array[size - 1] = null;
        size--;
        return value;
    }

    @Override
    public int getSize() {
        return size;
    }

}
