package com.vlad.datastructures.stack;

public interface Stack<T> {
    void push (T value);
    T peek ();
    T pop ();
    int getSize();
}
