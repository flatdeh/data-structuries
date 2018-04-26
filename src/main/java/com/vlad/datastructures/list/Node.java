package com.vlad.datastructures.list;

public class Node<T> {
    Node<T> next;
    Node<T> prev;
    T value;

    public Node() {
    }

    public Node(T value) {
        this.value = value;
    }

}
