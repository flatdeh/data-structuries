package com.vlad.datastructures.stack;

public class Node<T> {
    Node<T> prev;
    T value;

    public Node() {
    }

    public Node(T value) {
        this.value = value;
    }
}
