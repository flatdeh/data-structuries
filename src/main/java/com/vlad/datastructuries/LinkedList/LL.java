package com.vlad.datastructuries.LinkedList;

public class LL {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

       // System.out.println(linkedList.isEmpty());
        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        System.out.println("LastIndexOf-> "+linkedList.lastIndexOf(4));
        System.out.println(linkedList.toString());
        System.out.println("Head-> "+linkedList.getHead().value);
        System.out.println("Tail-> "+linkedList.getTail().value);
        //System.out.println(linkedList.remove(3));
        //System.out.println(linkedList.set(4,0));
        //linkedList.clear();
//        linkedList.add(1);
//        linkedList.add(2);
//        linkedList.add(3);
//        linkedList.add(4);
        //System.out.println(linkedList.toString());
        //System.out.println("Tail->"+linkedList.getTail().value);
       // linkedList.add(4,4);
       // linkedList.remove(4);
        //System.out.println(linkedList.toString());

    }
}
