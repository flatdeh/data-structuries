package com.vlad.datastructures.queue;

public interface Queue<T> {
    void enqueue(T value);

    T dequeue();

    int getSize();
}
