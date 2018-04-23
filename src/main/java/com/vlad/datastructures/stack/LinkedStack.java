package com.vlad.datastructures.stack;

public class LinkedStack<T> {
    private Node<T> head;
    private T value;
    private int size;

    public void push(T value) {
        Node<T> newNode = new Node<T>(value);
        if (size == 0) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public T peek() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Nothing to peek");
        }
        return head.value;
    }

    public T pop() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Nothing to pop");
        }
        T value = head.value;
        head = head.next;
        size--;
        return value;
    }

    public int getSize(){
        return size;
    }
}
