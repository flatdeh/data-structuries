package com.vlad.datastructures.queue;

import java.util.NoSuchElementException;

public class LinkedQueue<T> implements Queue<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    LinkedQueue() {
    }

    public void enqueue(T value) {
        if (value == null) {
            throw new NullPointerException("Value can not be Null");
        }
        Node<T> newNode = new Node<>(value);
        if (size == 0) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
    }

    public T dequeue() {
        if (size == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        T headValue = head.value;
        head = head.next;
        size--;
        return headValue;
    }

    public int getSize() {
        return size;
    }

}
