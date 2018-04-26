package com.vlad.datastructures;

public abstract class AbstractArray<T> {
    protected static final int INITIAL_CAPACITY = 10;
    protected T[] array = (T[]) new Object[INITIAL_CAPACITY];
    public int size;

    protected void increaseArray() {
        T[] newArray = (T[]) new Object[(int) (array.length * 1.5)];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }
}
