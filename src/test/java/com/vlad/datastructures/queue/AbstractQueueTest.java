package com.vlad.datastructures.queue;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public abstract class AbstractQueueTest {
  private Queue<String> queue = getQueue();

  public abstract Queue<String> getQueue();

  @Test
  public void testEnqueue() {
    queue.enqueue("a");
    queue.enqueue("b");
    queue.enqueue("c");
    queue.enqueue("d");

    assertEquals("a", queue.dequeue());
    assertEquals("b", queue.dequeue());
    assertEquals("c", queue.dequeue());
    assertEquals("d", queue.dequeue());
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
    queue.dequeue();

    queue.enqueue("a");
    queue.enqueue("b");
    queue.enqueue("c");

    queue.dequeue();
    queue.dequeue();
    queue.dequeue();
    queue.dequeue();
  }

  @Test
  public void testGetSize() {
    assertEquals(0, queue.getSize());

    queue.enqueue("a");
    queue.enqueue("b");
    queue.enqueue("c");

    assertEquals(3, queue.getSize());

    queue.dequeue();
    queue.dequeue();
    queue.dequeue();

    assertEquals(0, queue.getSize());
  }
}
