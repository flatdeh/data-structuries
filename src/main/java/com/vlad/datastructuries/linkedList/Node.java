package com.vlad.datastructuries.linkedList;

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
