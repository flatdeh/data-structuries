package com.vlad.datastructures.queue;


public class ArrayQueueTest extends AbstractQueueTest {
    @Override
    public Queue getQueue() {
        return new ArrayQueue();
    }
}
