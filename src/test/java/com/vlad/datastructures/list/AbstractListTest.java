package com.vlad.datastructures.list;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public abstract class AbstractListTest {
    List list = getList();

    public abstract List getList();

    @Test
    public void testAdd() {

        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e", 3);
        list.add("a", 0);
        assertEquals(5, list.size());

        assertEquals("a", list.get(0));
        assertEquals("b", list.get(1));
        assertEquals("c", list.get(2));
        assertEquals("d", list.get(3));
        assertEquals("e", list.get(4));
    }

    @Test
    public void testRemove() {
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        assertEquals("b", list.remove(1));
        assertEquals("a", list.get(0));
        assertEquals("c", list.get(1));
        assertEquals("d", list.get(2));

        assertEquals("a", list.remove(0));
        assertEquals("d", list.remove(1));
        assertEquals("c", list.get(0));

        assertEquals(1, list.size());
    }

    @Test
    public void testGet() {
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        assertEquals("a", list.get(0));
        assertEquals("b", list.get(1));
        assertEquals("c", list.get(2));
        assertEquals("d", list.get(3));
        assertEquals("e", list.get(4));
    }

    @Test
    public void testSet() {
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        assertEquals("1", list.set("a", 0));
        assertEquals("2", list.set("b", 1));
        assertEquals("3", list.set("c", 2));
        assertEquals("4", list.set("d", 3));
        assertEquals("5", list.set("e", 4));

        assertEquals("a", list.get(0));
        assertEquals("b", list.get(1));
        assertEquals("c", list.get(2));
        assertEquals("d", list.get(3));
        assertEquals("e", list.get(4));
    }

    @Test
    public void testClear() {
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        list.clear();

        assertEquals(0, list.size());
    }

    @Test
    public void testSize() {
        list.add("1");
        list.add("2");
        list.add("3", 0);
        list.add("4");
        list.add("5", 2);
        list.remove(0);
        list.remove(1);
        list.remove(1);
        list.remove(0);
        list.remove(0);
        assertEquals(0, list.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add("1");
        list.add("2");
        list.add("3", 0);
        list.add("4");
        list.add("5", 2);
        assertFalse(list.isEmpty());

    }

    @Test
    public void testContains() {
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        assertTrue(list.contains("b"));
        assertTrue(list.contains("d"));
        assertTrue(list.contains("a"));
        assertFalse(list.contains("1asdasd"));
    }

    @Test
    public void testIndexOf() {
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("d");

        assertEquals(0, list.indexOf("a"));
        assertEquals(3, list.indexOf("d"));
        assertEquals(1, list.indexOf("b"));
    }

    @Test
    public void testLastIndexOf() {
        list.add("a");
        list.add("b");
        list.add("d");
        list.add("d");

        assertEquals(3, list.lastIndexOf("d"));
        assertEquals(0, list.lastIndexOf("a"));
    }
}
