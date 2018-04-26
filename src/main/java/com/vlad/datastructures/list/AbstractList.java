package com.vlad.datastructures.list;

import com.vlad.datastructures.AbstractArray;

public abstract class AbstractList<T> extends AbstractArray<T> implements List<T> {

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
