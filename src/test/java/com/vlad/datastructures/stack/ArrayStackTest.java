package com.vlad.datastructures.stack;

public class ArrayStackTest extends AbstractStackTest {
  @Override
  public Stack<String> getStack() {
    return new ArrayStack<String>();
  }

}
