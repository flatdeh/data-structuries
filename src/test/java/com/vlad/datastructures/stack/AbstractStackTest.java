package com.vlad.datastructures.stack;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public abstract class AbstractStackTest {
  private Stack<String> stack = getStack();

  public abstract Stack<String> getStack();

  @Test
  public void testPush() {
    stack.push("a");
    stack.push("b");
    stack.push("c");

    assertEquals("c", stack.peek());
    assertEquals("c", stack.peek());
    assertEquals("c", stack.peek());
    assertEquals(3, stack.getSize());
    assertEquals("c", stack.pop());
    assertEquals("b", stack.pop());
    assertEquals("a", stack.pop());
    assertEquals(0, stack.getSize());
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

  @Test(expected = NoSuchElementException.class)
  public void testPopWithNoSuchElementException() {
    stack.pop();

    stack.push("a");
    stack.push("b");
    stack.push("c");

    stack.pop();
    stack.pop();
    stack.pop();

  }

  @Test(expected = NoSuchElementException.class)
  public void testPeekWithNoSuchElementException() {
    stack.peek();

    stack.push("a");
    stack.push("b");
    stack.push("c");

    stack.peek();
    stack.peek();
    stack.peek();
    stack.peek();
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
    assertEquals(0, stack.getSize());
    stack.push("a");
    stack.push("b");
    stack.push("c");

    stack.pop();
    stack.pop();
    stack.peek();
    assertEquals(1, stack.getSize());
  }
}
