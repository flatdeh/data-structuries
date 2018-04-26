package com.vlad.datastructures.stack;

import java.util.NoSuchElementException;

public class LinkedStack<T> extends AbstractStack<T> {
    private Node<T> tail;
    private int size;

    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        if (size == 0) {
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public T peek() {
        if (size == 0) {
            throw new NoSuchElementException("Nothing to peek");
        }
        return tail.value;
    }

    public T pop() {
        if (size == 0) {
            throw new NoSuchElementException("Nothing to pop");
        }
        T value = tail.value;
        tail = tail.prev;
        size--;
        return value;
    }

    public int getSize() {
        return size;
    }
}
