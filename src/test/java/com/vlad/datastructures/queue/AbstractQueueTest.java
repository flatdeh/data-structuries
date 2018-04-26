package com.vlad.datastructures.queue;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public abstract class AbstractQueueTest {
    Queue<String> queue = getQueue();

    public abstract Queue getQueue();

    @Test
    public void testEnqueue() {
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        assertEquals(3, queue.getSize());
        assertEquals("a", queue.dequeue());
        assertEquals("b", queue.dequeue());
        assertEquals("c", queue.dequeue());
        assertEquals(0, queue.getSize());
    }

    @Test
    public void testDequeue() {
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        assertEquals("a", queue.dequeue());
        assertEquals("b", queue.dequeue());
        assertEquals("c", queue.dequeue());
    }

    @Test(expected = NoSuchElementException.class)
    public void testNoSuchElementException() {
        assertEquals("a", queue.dequeue());

        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");

        assertEquals("a", queue.dequeue());
        assertEquals("b", queue.dequeue());
        assertEquals("c", queue.dequeue());
        assertEquals("c", queue.dequeue());
    }

    @Test
    public void testGetSize() {
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        assertEquals("a", queue.dequeue());
        assertEquals("b", queue.dequeue());
        assertEquals("c", queue.dequeue());

        assertEquals(0, queue.getSize());
    }
}
