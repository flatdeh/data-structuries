package com.vlad.datastructures.list;

// com.vlad.datastructures.list.List, Set, Map
public interface List<T> {
    // add value to the end of the list
    void add(T value);

    // we can add value by index between [0, getSize]
    // otherwise throw new IndexOutOfBoundsException
    void add(T value, int index);

    // we can remove value by index between [0, getSize - 1]
    // otherwise throw new IndexOutOfBoundsException

    // [A, B, C] remove = 0
    // [B (index = 0) , C (index = 1)]
    T remove(int index);

    // [A, B, C] getSize = 3
    // we can get value by index between [0, getSize - 1]
    // otherwise throw new IndexOutOfBoundsException
    T get(int index);

    // we can set value by index between [0, getSize - 1]
    // otherwise throw new IndexOutOfBoundsException
    T set(T value, int index);

    void clear();

    int size();

    boolean isEmpty();

    boolean contains(T value);

    int indexOf(T value);

    int lastIndexOf(T value);

    // [A, B, C]
    String toString();
}