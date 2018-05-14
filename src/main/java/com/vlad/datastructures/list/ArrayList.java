package com.vlad.datastructures.list;

import java.util.Iterator;
import java.util.StringJoiner;

public class ArrayList<T> extends AbstractList<T> implements Iterable {
    private static final int INITIAL_CAPACITY = 10;
    private T[] array = (T[]) new Object[INITIAL_CAPACITY];

    ArrayList() {
        this(INITIAL_CAPACITY);
    }

    ArrayList(int capacity) {
        this.array = (T[]) new Object[capacity];
    }


    public void add(T value) {
        add(value, size);
    }

    public void add(T value, int index) {

        validateAddIndex(index);
        validateValue(value);

        if (size == array.length) {
            increaseArray();
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = value;
        size++;
    }

    public T remove(int index) {
        validateIndex(index);
        T valueToRemove = array[index];
        System.arraycopy(array, index + 1, array, index, size - index);
        array[size - 1] = null;
        size--;
        return valueToRemove;
    }

    public T get(int index) {
        validateIndex(index);
        return array[index];
    }

    public T set(T value, int index) {
        validateValue(value);
        validateIndex(index);

        T oldValue = array[index];
        array[index] = value;

        return oldValue;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    public int indexOf(T value) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T value) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    private void increaseArray() {
        T[] newArray = (T[]) new Object[(int) (array.length * 1.5) + 1];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");

        for (int i = 0; i < size; i++) {
            stringJoiner.add(array[i].toString());
        }

        return stringJoiner.toString();
    }

    @Override
    public Iterator iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator {
        private int count;

        @Override
        public boolean hasNext() {
            return count < size;
        }

        @Override
        public T next() {
            return array[count++];
        }
    }
}
