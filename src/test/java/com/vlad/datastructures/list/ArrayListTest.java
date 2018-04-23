package com.vlad.datastructures.list;

import com.vlad.datastructures.list.ArrayList;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayListTest {
    @Test
    public void testAdd() {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("d");
        arrayList.add("e", 3);
        arrayList.add("a", 0);
        assertEquals(5, arrayList.size());

        assertEquals("a", arrayList.get(0));
        assertEquals("b", arrayList.get(1));
        assertEquals("c", arrayList.get(2));
        assertEquals("d", arrayList.get(3));
        assertEquals("e", arrayList.get(4));

    }

    @Test
    public void testRemove() {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("d");

        assertEquals("b", arrayList.remove(1));
        assertEquals("a", arrayList.get(0));
        assertEquals("c", arrayList.get(1));
        assertEquals("d", arrayList.get(2));

        assertEquals("a", arrayList.remove(0));
        assertEquals("d", arrayList.remove(1));
        assertEquals("c", arrayList.get(0));

        assertEquals(1, arrayList.size());
    }

    @Test
    public void testGet() {
        ArrayList<String> arrayList = new ArrayList<String>();
        System.out.println(arrayList.toString());
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("d");
        arrayList.add("e");
        System.out.println(arrayList.toString());
        assertEquals("a", arrayList.get(0));
        assertEquals("b", arrayList.get(1));
        assertEquals("c", arrayList.get(2));
        assertEquals("d", arrayList.get(3));
        assertEquals("e", arrayList.get(4));
    }

    @Test
    public void testSet() {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");

        assertEquals("1", arrayList.set("a", 0));
        assertEquals("2", arrayList.set("b", 1));
        assertEquals("3", arrayList.set("c", 2));
        assertEquals("4", arrayList.set("d", 3));
        assertEquals("5", arrayList.set("e", 4));

        assertEquals("a", arrayList.get(0));
        assertEquals("b", arrayList.get(1));
        assertEquals("c", arrayList.get(2));
        assertEquals("d", arrayList.get(3));
        assertEquals("e", arrayList.get(4));
    }

    @Test
    public void testClear() {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");

        arrayList.clear();

        assertNull(arrayList.get(0));
        assertEquals(0, arrayList.size());
    }

    @Test
    public void testSize() {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3",0);
        arrayList.add("4");
        arrayList.add("5",2);
        arrayList.remove(0);
        arrayList.remove(1);
        arrayList.remove(1);
        arrayList.remove(0);
        arrayList.remove(0);
        assertEquals(0, arrayList.size());
    }

    @Test
    public void testIsEmpty() {
        ArrayList<String> arrayList = new ArrayList<String>();
        assertTrue(arrayList.isEmpty());
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3",0);
        arrayList.add("4");
        arrayList.add("5",2);
        assertFalse(arrayList.isEmpty());

    }

    @Test
    public void testContains() {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("d");

        assertTrue(arrayList.contains("b"));
        assertTrue(arrayList.contains("d"));
        assertTrue(arrayList.contains("a"));
        assertFalse(arrayList.contains("1asdasd"));
    }

    @Test
    public void testIndexOf() {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("b");
        arrayList.add("d");

        assertEquals(0, arrayList.indexOf("a"));
        assertEquals(3, arrayList.indexOf("d"));
        assertEquals(1, arrayList.indexOf("b"));
    }

    @Test
    public void testLastIndexOf() {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("d");
        arrayList.add("d");

        assertEquals(3, arrayList.lastIndexOf("d"));
        assertEquals(0, arrayList.lastIndexOf("a"));
    }

}
