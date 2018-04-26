package com.vlad.datastructures.stack;

public class LinkedStackTest extends AbstractStackTest {
  @Override
  public Stack<String> getStack() {
    return new LinkedStack<String>();
  }

}
