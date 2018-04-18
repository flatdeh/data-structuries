package com.vlad.datastructuries.queue;

public class LinkedQueue<T> {
    private Node<T> head;
    private int size;

    public LinkedQueue() {
    }

    public void enqueue(T value) {
        Node<T> newNode = new Node<T>(value);
        if (size == 0) {
            head = newNode;
        } else {
            Node<T> curNode = head;
            while (curNode.next != null) {
                curNode = curNode.next;
            }
            curNode.next = newNode;
        }
        size++;
    }

    public T dequeue() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Queue size = 0");
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
