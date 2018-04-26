package com.vlad.datastructures.queue;

public class LinkedQueueTest extends AbstractQueueTest{
    @Override
    public Queue getQueue() {
        return new LinkedQueue();
    }

}
