package com.vlad.datastructuries.stack;

public class Node<T> {
    Node<T> next;
    T value;

    public Node() {
    }

    public Node(T value) {
        this.value = value;
    }
}
