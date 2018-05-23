package com.vlad.datastructures.list;

import java.util.Iterator;
import java.util.StringJoiner;

public class LinkedList<T> extends AbstractList<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;

    public LinkedList() {
    }

    public void add(T value) {
        add(value, size);
    }

    public void add(T value, int index) {
        validateAddIndex(index);
        validateValue(value);

        Node<T> newNode = new Node<>(value);
        if (size == 0) {
            head = tail = newNode;
        } else if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else if (index == size) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            Node<T> curNode = getNode(index);
            newNode.prev = curNode.prev;
            newNode.next = curNode;
            curNode.prev.next = newNode;
            curNode.prev = newNode;
        }
        size++;
    }

    public T remove(int index) {
        validateIndex(index);

        Node<T> curNode = getNode(index);

        T valueToRemove = curNode.value;

        if (size == 1) {
            head = tail = null;
        } else if (index == 0) {
            head = head.next;
            head.prev = null;
        } else if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
        } else {
            curNode.next.prev = curNode.prev;
            curNode.prev.next = curNode.next;
        }
        size--;
        return valueToRemove;
    }

    public T get(int index) {
        validateIndex(index);
        return getNode(index).value;
    }

    public T set(T value, int index) {
        validateValue(value);
        validateIndex(index);
        Node<T> curNode = getNode(index);
        T oldValue = curNode.value;
        curNode.value = value;
        return oldValue;
    }

    public void clear() {
        Node<T> nextNode;
        Node<T> curNode = head;
        while (curNode != null) {
            nextNode = curNode.next;
            curNode.value = null;
            curNode.next = null;
            curNode.prev = null;
            curNode = nextNode;
        }
        head = tail = null;
        size = 0;
    }

    public int indexOf(T value) {
        Node<T> curNode = head;
        for (int i = 0; i < size; i++) {
            if (curNode.value.equals(value)) {
                return i;
            }
            curNode = curNode.next;
        }
        return -1;
    }

    public int lastIndexOf(T value) {
        Node<T> curNode = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (curNode.value.equals(value)) {
                return i;
            }
            curNode = curNode.prev;
        }
        return -1;
    }

    private Node<T> getNode(int index) {
        Node<T> curNode;
        if (index >= size / 2) {
            curNode = tail;
            for (int i = size; i > index + 1; i--) {
                curNode = curNode.prev;
            }
        } else {
            curNode = head;
            for (int i = 0; i < index; i++) {
                curNode = curNode.next;
            }
        }
        return curNode;
    }

    public String toString() {
        Node<T> newNode = head;
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");

        for (int i = 0; i < size; i++) {
            stringJoiner.add(newNode.value.toString());
            newNode = newNode.next;
        }

        return stringJoiner.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private static class Node<T> {
        private Node<T> next;
        private Node<T> prev;
        private T value;

        private Node() {
        }

        private Node(T value) {
            this.value = value;
        }

    }

    private class LinkedListIterator implements Iterator<T> {
        private Node<T> currentNode = head;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            T value = currentNode.value;
            currentNode = currentNode.next;
            return value;
        }
    }

}
