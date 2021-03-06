package com.vlad.datastructures.stack;

import java.util.NoSuchElementException;

public class ArrayStack<T> implements Stack<T> {
    private static final int INITIAL_CAPACITY = 10;
    private T[] array = (T[]) new Object[INITIAL_CAPACITY];
    private int size;

    private void increaseArray() {
        T[] newArray = (T[]) new Object[(int) (array.length * 1.5) + 1];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    ArrayStack() {
    }

    @Override
    public void push(T value) {
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
    public T peek() {
        if (size == 0) {
            throw new NoSuchElementException("Nothing to peek, size = 0");
        }
        return array[size - 1];
    }

    @Override
    public T pop() {
        if (size == 0) {
            throw new NoSuchElementException("Nothing to pop, size = 0");
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

    private static class Node<T> {
        private Node<T> prev;
        private T value;

        private Node() {
        }

        private Node(T value) {
            this.value = value;
        }
    }

}
