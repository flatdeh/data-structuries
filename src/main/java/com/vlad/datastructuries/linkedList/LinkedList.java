package com.vlad.datastructuries.linkedList;

import com.vlad.datastructuries.List;

public class LinkedList<T> implements List<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
    }

    public void add(T value) {
        add(value, size);
    }

    public void add(T value, int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("\"index\" should be between 0 and " + size + ", but was : " + index);
        }

        Node<T> newNode = new Node<T>(value);
        if (size == 0) {
            head = tail = newNode;
            size++;
            return;
        }

        if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            size++;
            return;
        }

        if (index == size) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            size++;
            return;
        }

        Node<T> curNode = getNodeByIndex(index);

        newNode.prev = curNode.prev;
        newNode.next = curNode;
        curNode.prev.next = newNode;
        curNode.prev = newNode;

        size++;
    }

    private Node<T> getNodeByIndex(int index) {
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

    public T remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("\"index\" should be between 0 and " + size + ", but was : " + index);
        }

        Node<T> curNode = getNodeByIndex(index);

        T valueToRemove = curNode.value;

        if (size == 1) {
            head = tail = null;
            size--;
            return valueToRemove;
        }

        if (index == 0) {
            head = head.next;
            head.prev = null;
            size--;
            return valueToRemove;
        }

        if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
            size--;
            return valueToRemove;
        }

        curNode.next.prev = curNode.prev;
        curNode.prev.next = curNode.next;

        size--;
        return valueToRemove;
    }

    private void validateIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("\"index\" should be between 0 and " + size + "(inclusive), but was : " + index);
        }
    }

    public T get(int index) {
        validateIndex(index);
        return getNodeByIndex(index).value;
    }

    public T set(T value, int index) {
        validateIndex(index);
        Node<T> curNode = getNodeByIndex(index);
        T oldValue = curNode.value;
        curNode.value = value;
        return oldValue;
    }

    public void clear() {
        size = 0;
        head = tail = null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(T value) {
        return indexOf(value) != -1;
    }

    public int indexOf(T value) {
        Node curNode = head;
        for (int i = 0; i < size; i++) {
            if (curNode.value.equals(value)) {
                return i;
            }
            curNode = curNode.next;
        }
        return -1;
    }

    public int lastIndexOf(T value) {
        Node curNode = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (curNode.value.equals(value)) {
                return i;
            }
            curNode = curNode.prev;
        }
        return -1;
    }

    public String toString() {
        Node newNode = head;
        String result = "";
        if (size > 0) {
            for (int i = 0; i < size - 1; i++) {
                result += newNode.value + ", ";
                newNode = newNode.next;

            }
            result += newNode.next.value;
        }
        return "[" + result + "]";
    }
}
