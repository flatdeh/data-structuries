package com.vlad.datastructuries.LinkedList;

import com.vlad.datastructuries.List;

public class LinkedList<T> implements List<T> {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
    }

    public void add(T value) {
        Node newNode = new Node(value);
        if (size != 0) {
            tail.next = newNode;
            newNode.prev = tail;
        } else {
            head = newNode;
        }
        tail = newNode;
        size++;
    }

    public void add(T value, int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("\"index\" should be between 0 and " + size + ", but was : " + index);
        }

        if (index == size) {
            add(value);
            return;
        }

        Node curNode = new Node();
        curNode = tail;
        for (int i = size; i > index + 1; i--) {
            curNode = curNode.prev;
        }
        Node newNode = new Node(value);

        newNode.prev = curNode.prev;
        if (curNode.prev != null) {
            newNode.next = curNode.prev.next;
        }
        curNode.prev = newNode;
        curNode.prev.next = newNode;
        size++;
    }

    public T remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("\"index\" should be between 0 and " + size + ", but was : " + index);
        }

        Node curNode = new Node();
        curNode = tail;
        T removeValue = (T) curNode.value;

        if (size == 1) {
            tail.value = null;
            tail.prev = null;
            tail.next = null;
            size--;
            return removeValue;
        }

        if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
            size--;
            return removeValue;
        }

        for (int i = size; i > index + 1; i--) {
            curNode = curNode.prev;
        }

        removeValue = (T) curNode.value;

        if (curNode.prev != null) {
            curNode.prev.next = curNode.next;
        }
        if (curNode.next != null) {
            curNode.next.prev = curNode.prev;
        }

        size--;
        return removeValue;
    }

    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("\"index\" should be between 0 and " + size + ", but was : " + index);
        }
        Node curNode = new Node();
        curNode = tail;
        for (int i = size; i > index + 1; i--) {
            curNode = curNode.prev;
        }
        return (T) curNode.value;
    }

    public T set(T value, int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("\"index\" should be between 0 and " + size + ", but was : " + index);
        }
        Node curNode = new Node();

        curNode = tail;
        for (int i = size; i > index + 1; i--) {
            curNode = curNode.prev;
        }
        T oldValue = (T) curNode.value;
        curNode.value = value;
        return oldValue;
    }

    public void clear() {
        Node curNode = new Node();
        curNode = tail;
        for (int i = 0; i < size; i++) {
            curNode.value = null;
            curNode = curNode.prev;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(T value) {
        Node curNode = new Node();
        curNode = tail;
        for (int i = 0; i > size; i++) {
            if (curNode.value.equals(value)) {
                return true;
            }
            curNode = curNode.prev;
        }
        return false;
    }

    public int indexOf(T value) {
        Node curNode = new Node();
        curNode = tail;
        for (int i = 0; i < size; i++) {
            if (curNode.value.equals(value)) {
                return i;
            }
            curNode = curNode.prev;
        }
        return -1;
    }

    public int lastIndexOf(T value) {
        Node curNode = new Node();
        curNode = head;
        for (int i = 0; i < size; i++) {
            if (curNode.value.equals(value)) {
                return i;
            }
            curNode = curNode.next;
        }
        return -1;
    }

    public String toString() {
        Node newNode = new Node();
        newNode= tail;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        if (size > 0) {
            while (newNode.prev != null) {
                stringBuilder.append(newNode.value + ", ");
                newNode = newNode.prev;
            }
            stringBuilder.append(newNode.value + ", ");
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
