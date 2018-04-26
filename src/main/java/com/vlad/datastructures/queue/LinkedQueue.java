package com.vlad.datastructures.queue;

import java.util.NoSuchElementException;

public class LinkedQueue<T> {
    private Node<T> tail;
    private Node<T> head;
    private int size;

    public LinkedQueue() {
    }

    public void enqueue(T value) {
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

    public String toString() {
        String result = "";
        if (size != 0) {
            Node<T> curNode = head;
            while (curNode.next != null) {
                result += curNode.value.toString();
                curNode = curNode.next;
            }
            result += curNode.value.toString();
        }
        return result;
    }
}
