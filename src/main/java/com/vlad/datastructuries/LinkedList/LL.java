package com.vlad.datastructuries.LinkedList;

public class LL {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        System.out.println("LastIndexOf-> "+linkedList.lastIndexOf(4));

    }
}
