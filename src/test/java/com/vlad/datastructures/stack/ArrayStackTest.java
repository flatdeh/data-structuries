package com.vlad.datastructures.stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrayStackTest {
    @Test
    public void testPush() {
        ArrayStack<String> arrayStack = new ArrayStack<>();
        arrayStack.push("a");
        arrayStack.push("b");
        arrayStack.push("c");

        assertEquals("c", arrayStack.peek());
        assertEquals("c", arrayStack.peek());
        assertEquals("c", arrayStack.peek());
        assertEquals(3, arrayStack.getSize());
    }

    @Test
    public void testPop() {
        ArrayStack<String> arrayStack = new ArrayStack<>();
        arrayStack.push("a");
        arrayStack.push("b");
        arrayStack.push("c");

        assertEquals(3, arrayStack.getSize());
        assertEquals("c", arrayStack.pop());
        assertEquals("b", arrayStack.pop());
        assertEquals("a", arrayStack.pop());
        assertEquals(0, arrayStack.getSize());
    }

    @Test
    public void testPeek(){
        ArrayStack<String> arrayStack = new ArrayStack<>();
        arrayStack.push("a");
        arrayStack.push("b");
        arrayStack.push("c");
        arrayStack.push("d");

        assertEquals("d", arrayStack.peek());
        assertEquals("d", arrayStack.peek());
        assertEquals("d", arrayStack.peek());
        assertEquals("d", arrayStack.peek());
        assertEquals(4, arrayStack.getSize());
    }

}
