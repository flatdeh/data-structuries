package com.vlad.datastructuries.linkedList;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

    @Test
    public void testAdd() {
        LinkedList<String> linkedList = new LinkedList<String>();

        linkedList.add("b", 0);
        linkedList.add("c", 1);
        linkedList.add("a",0);
        linkedList.add("d");
        linkedList.add("e", 4);

        System.out.println(linkedList.toString());

        assertEquals("a", linkedList.get(0));
        assertEquals("b", linkedList.get(1));
        assertEquals("c", linkedList.get(2));
        assertEquals("d", linkedList.get(3));
        assertEquals("e", linkedList.get(4));
    }

    @Test
    public void testRemove() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("a");
        assertEquals("a", linkedList.remove(0));
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d");
        linkedList.add("e");

        assertEquals("b", linkedList.remove(0));
        assertEquals("e", linkedList.remove(2));

        assertEquals("c", linkedList.get(0));
        assertEquals("d", linkedList.get(1));
        assertEquals(2, linkedList.size());
        assertEquals("c", linkedList.remove(0));
        assertEquals("d", linkedList.remove(0));
        assertEquals(0, linkedList.size());
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d",3);

        assertEquals("a", linkedList.get(0));
        assertEquals("c", linkedList.get(2));
        assertEquals("d", linkedList.get(3));
    }

    @Test
    public void testGet(){
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("a");
        assertEquals("a", linkedList.get(0));
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d");
        linkedList.add("e");
        assertEquals("e", linkedList.get(4));
    }

    @Test
    public void testSet() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("dsf");
        assertEquals("dsf", linkedList.set("a",0));
        assertEquals("a", linkedList.get(0));

        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d");
        linkedList.add("errr");
        assertEquals("errr", linkedList.set("e",4));
    }

    @Test
    public void testClear() {
        LinkedList<String> linkedList = new LinkedList<String>();

        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d");
        linkedList.add("e");

        linkedList.clear();

        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        assertEquals("1", linkedList.get(0));
        assertEquals("2", linkedList.get(1));
        assertEquals("3", linkedList.get(2));

        System.out.println(linkedList.toString());

    }

    @Test
    public void testSize() {
        LinkedList<String> linkedList = new LinkedList<String>();
        assertEquals(0, linkedList.size());
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        assertEquals(3, linkedList.size());

        linkedList.remove(0);
        linkedList.remove(0);
        linkedList.remove(0);

        assertEquals(0, linkedList.size());
    }

    @Test
    public void isEmpty() {
        LinkedList<String> linkedList = new LinkedList<String>();
        assertTrue(linkedList.isEmpty());

        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        assertFalse(linkedList.isEmpty());

        linkedList.remove(0);
        linkedList.remove(0);
        linkedList.remove(0);

        assertTrue(linkedList.isEmpty());
    }

    @Test
    public void testContains() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        assertTrue(linkedList.contains("b"));

        linkedList.remove(0);
        linkedList.remove(0);
        linkedList.remove(0);
        assertFalse(linkedList.contains("b"));


    }

    @Test
    public void testIndexOf() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("c");

        assertEquals(2, linkedList.indexOf("c"));
        assertEquals(0, linkedList.indexOf("a"));
    }

    @Test
    public void testLastIndexOf() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("c");
        linkedList.add("d");

        assertEquals(3, linkedList.lastIndexOf("c"));
        assertEquals(0, linkedList.lastIndexOf("a"));
        assertEquals(4, linkedList.lastIndexOf("d"));

    }

}
