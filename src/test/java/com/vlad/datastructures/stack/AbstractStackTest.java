package com.vlad.datastructures.stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class AbstractStackTest {
    private Stack<String> stack = getStack();

    public abstract Stack getStack();


    @Test
    public void testPush() {
        stack.push("a");
        stack.push("b");
        stack.push("c");

        assertEquals("c", stack.peek());
        assertEquals("c", stack.peek());
        assertEquals("c", stack.peek());
        assertEquals(3, stack.getSize());
    }

    @Test
    public void testPop() {
        stack.push("a");
        stack.push("b");
        stack.push("c");

        assertEquals(3, stack.getSize());
        assertEquals("c", stack.pop());
        assertEquals("b", stack.pop());
        assertEquals("a", stack.pop());
        assertEquals(0, stack.getSize());
    }

    @Test
    public void testPeek() {
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");

        assertEquals("d", stack.peek());
        assertEquals("d", stack.peek());
        assertEquals("d", stack.peek());
        assertEquals("d", stack.peek());
        assertEquals(4, stack.getSize());
    }

    @Test
    public void testGetSize() {
        LinkedStack<String> linkedStack = new LinkedStack<String>();
        linkedStack.push("a");
        linkedStack.push("b");
        linkedStack.push("c");

        assertEquals("c", linkedStack.pop());
        assertEquals("b", linkedStack.pop());
        assertEquals(1, linkedStack.getSize());
    }
}
