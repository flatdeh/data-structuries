package com.vlad.datastructures.stack;

public class LinkedStackTest extends AbstractStackTest{
    @Override
    public Stack getStack() {
        return new LinkedStack();
    }

}
