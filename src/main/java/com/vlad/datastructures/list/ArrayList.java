package com.vlad.datastructures.list;

public class ArrayList<T> extends AbstractList<T> {
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
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("\"index\" should be between 0 and " + size + ", but was : " + index);
        }
        if (value == null) {
            throw new NullPointerException("Value can not be Null");
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
        if (value == null) {
            throw new NullPointerException("Value can not be Null");
        }
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
        T[] newArray = (T[]) new Object[(int) (array.length * 1.5)];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (size > 0) {
            sb.append("[");
            for (int i = 0; i < size - 1; i++) {
                sb.append(array[i]).append(", ");
            }
            sb.append(array[size - 1]).append("]");
        } else {
            sb.append("[]");
        }

        return sb.toString();
    }
}
