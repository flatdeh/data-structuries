package com.vlad.datastructures.list;

public abstract class AbstractList<T> implements List<T> {
    protected int size;

    protected void validateValue(T value) {
        if (value == null) {
            throw new NullPointerException("Value can not be Null");
        }
    }

    protected void validateAddIndex(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("\"index\" should be between 0 and " + size + "(inclusive), but was : " + index);
        }
    }

    protected void validateIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("\"index\" should be between 0 and " + size + "(inclusive), but was : " + index);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(T value) {
        return indexOf(value) != -1;
    }

}
