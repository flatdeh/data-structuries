package com.vlad.datastructures.list;

public class ArrayList<T> extends AbstractList<T> {

    ArrayList() {
        this(INITIAL_CAPACITY);
    }

    private ArrayList(int capacity) {
        this.array = (T[]) new Object[capacity];
    }


    public void add(T value) {
        add(value, size);
    }

    public void add(T value, int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("\"index\" should be between 0 and " + size + ", but was : " + index);
        }
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
        size--;
        return valueToRemove;
    }

    public T get(int index) {
        validateIndex(index);
        return array[index];
    }

    public T set(T value, int index) {
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

    public String toString() {
        String result = "";
        if (size > 0) {
            for (int i = 0; i < size - 1; i++) {
                result += array[i] + ", ";
            }
            result += array[size - 1];
        }
        return "[" + result + "]";
    }
}
