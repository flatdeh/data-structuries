package com.vlad.datastructuries.ArrayList;

import com.vlad.datastructuries.List;

public class ArrayList<T> implements List<T> {
    private static final int INITIAL_CAPASITY = 10;
    private int size;
    private T[] arrayList;

    public ArrayList() {
        this(INITIAL_CAPASITY);
    }

    public ArrayList(int capasity) {
        this.arrayList = (T[]) new Object[capasity];
    }

    private void increaseArrayList() {
        T[] newArray = (T[]) new Object[(int) (arrayList.length * 1.5)];
        System.arraycopy(arrayList, 0, newArray, 0, size);
        arrayList = newArray;
    }

    private void validateIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("\"index\" should be between 0 and " + size + "(inclusive), but was : " + index);
        }
    }

    public void add(T value) {
        add(value, size);
    }

    public void add(T value, int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("\"index\" should be between 0 and " + size + ", but was : " + index);
        }
        if (size == arrayList.length) {
            increaseArrayList();
        }
        System.arraycopy(arrayList, index, arrayList, index + 1, size - index);
        arrayList[index] = value;
        size++;
    }

    public T remove(int index) {
        validateIndex(index);
        T valueToRemove = arrayList[index];
        System.arraycopy(arrayList, index + 1, arrayList, index, size - index);
        size--;
        return valueToRemove;
    }

    public T get(int index) {
        validateIndex(index);
        return arrayList[index];
    }

    public T set(T value, int index) {
        validateIndex(index);

        T oldValue = arrayList[index];
        arrayList[index] = value;
        return oldValue;
    }

    public void clear() {
        arrayList = (T[]) new Object[size];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size != 0;
    }

    public boolean contains(T value) {
        return indexOf(value) != -1;
    }

    public int indexOf(T value) {
        for (int i = 0; i < size; i++) {
            if (arrayList[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T value) {
        for (int i = size - 1; i >= 0; i--) {
            if (arrayList[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                stringBuilder.append(arrayList[i] + ", ");
            }
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
