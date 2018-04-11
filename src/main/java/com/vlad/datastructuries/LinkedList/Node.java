package com.vlad.datastructuries.LinkedList;

public class Node<T> {
    public Node next;
    public Node prev;
    public T value;

    public Node() {
    }

    public Node(T value) {
        this.value = value;
    }

}
