package com.vlad.datastructures.stack;

import java.util.NoSuchElementException;

public class ArrayStack<T> extends AbstractStack<T> {
    ArrayStack() {
    }

    @Override
    public void push(T value) {
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
        return (T) array[size - 1];
    }

    @Override
    public T pop() {
        if (size == 0) {
            throw new NoSuchElementException("Nothing to pop, size = 0");
        }
        T value = (T) array[size - 1];
        array[size - 1] = null;
        size--;
        return value;
    }

    @Override
    public int getSize() {
        return size;
    }

}
