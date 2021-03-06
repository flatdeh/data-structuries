package com.vlad.datastructures.list;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public abstract class AbstractListTest {
    private List<String> list = getList();

    public abstract List<String> getList();

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

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddWithNegativeIndex() {
        list.add("a",-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddToTheEnd() {
        list.add("a", 1);
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

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveWithNegativeIndex() {
        list.remove(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveWithNullElements() {
        list.remove(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveWithFiveElements() {
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.remove(6);
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
        assertEquals(5, list.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetWithNegativeElements() {
        list.get(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetWithNullElements() {
        list.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetWithFiveElements() {
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.get(6);
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
        assertEquals(5, list.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetWithNegativeElements() {
        list.set("a", -1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetWithNullElements() {
        list.set("a", 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetWithFiveElements() {
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.set("a", 6);
    }

    @Test
    public void testClear() {
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        list.clear();

        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals(0, list.size());

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        list.set("a", 0);

        list.get(0);

        assertEquals(5, list.size());

        list.remove(0);
        list.remove(3);
        list.remove(2);
        list.remove(1);
        list.remove(0);

        assertEquals(0, list.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(list.isEmpty());

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        assertFalse(list.isEmpty());

        list.remove(0);
        list.remove(0);
        list.remove(0);
        list.remove(0);
        list.remove(0);
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    public void testContains() {
        assertFalse(list.contains("a"));

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        assertTrue(list.contains("b"));
        assertTrue(list.contains("d"));
        assertTrue(list.contains("a"));
        assertFalse(list.contains("1asdasd"));
        assertEquals(4, list.size());
    }

    @Test
    public void testIndexOf() {
        assertEquals(-1, list.indexOf("a"));

        list.add("a");
        list.add("b");
        list.add("b");
        list.add("d");

        assertEquals(0, list.indexOf("a"));
        assertEquals(3, list.indexOf("d"));
        assertEquals(1, list.indexOf("b"));
        assertEquals(-1, list.indexOf("bbbbbb"));
        assertEquals(4, list.size());
    }

    @Test
    public void testLastIndexOf() {
        assertEquals(-1, list.lastIndexOf("d"));

        list.add("a");
        list.add("b");
        list.add("d");
        list.add("d");

        assertEquals(3, list.lastIndexOf("d"));
        assertEquals(0, list.lastIndexOf("a"));
        assertEquals(-1, list.lastIndexOf("aaaa"));
        assertEquals(4, list.size());
    }

    @Test
    public void testToString() {
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("d");

        System.out.println(list.toString());
    }
}
