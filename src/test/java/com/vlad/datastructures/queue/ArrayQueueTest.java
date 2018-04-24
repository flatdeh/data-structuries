package com.vlad.datastructures.queue;


import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class ArrayQueueTest {
    @Test
    public void testArrayQueue() {
        ArrayQueue<String> arrayQueue = new ArrayQueue<>();
        arrayQueue.enqueue("a");
        arrayQueue.enqueue("b");
        arrayQueue.enqueue("c");
        assertEquals(3, arrayQueue.getSize());
        assertEquals("a", arrayQueue.dequeue());
        assertEquals("b", arrayQueue.dequeue());
        assertEquals("c", arrayQueue.dequeue());
        assertEquals(0, arrayQueue.getSize());
    }

    @Test(expected = NoSuchElementException.class)
    public void testNoSuchElementException() {
        ArrayQueue<String> arrayQueue = new ArrayQueue<>();
        assertEquals("a", arrayQueue.dequeue());

        arrayQueue.enqueue("a");
        arrayQueue.enqueue("b");
        arrayQueue.enqueue("c");

        assertEquals("a", arrayQueue.dequeue());
        assertEquals("b", arrayQueue.dequeue());
        assertEquals("c", arrayQueue.dequeue());
        assertEquals("c", arrayQueue.dequeue());
    }
}
