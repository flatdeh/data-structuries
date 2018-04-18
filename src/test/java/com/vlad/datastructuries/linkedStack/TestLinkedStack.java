package com.vlad.datastructuries.linkedStack;

import com.vlad.datastructuries.stack.LinkedStack;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestLinkedStack {
    @Test
    public void testPush() {
        LinkedStack<String> linkedStack = new LinkedStack<String>();
        linkedStack.push("a");
        linkedStack.push("b");
        linkedStack.push("c");
        assertEquals(3,linkedStack.getSize());
    }

    @Test
    public void testPeek() {
        LinkedStack<String> linkedStack = new LinkedStack<String>();
        linkedStack.push("a");
        linkedStack.push("b");
        linkedStack.push("c");

        assertEquals("c", linkedStack.peek());
        assertEquals("c", linkedStack.peek());
        assertEquals(3,linkedStack.getSize());
    }

    @Test
    public void testPop() {
        LinkedStack<String> linkedStack = new LinkedStack<String>();
        linkedStack.push("a");
        linkedStack.push("b");
        linkedStack.push("c");

        assertEquals("c", linkedStack.pop());
        assertEquals("b", linkedStack.pop());
        assertEquals("a", linkedStack.pop());
        assertEquals(0,linkedStack.getSize());
    }

    @Test
    public void testGetSize() {
        LinkedStack<String> linkedStack = new LinkedStack<String>();
        linkedStack.push("a");
        linkedStack.push("b");
        linkedStack.push("c");

        assertEquals("c", linkedStack.pop());
        assertEquals("b", linkedStack.pop());
        assertEquals(1,linkedStack.getSize());
    }
}
