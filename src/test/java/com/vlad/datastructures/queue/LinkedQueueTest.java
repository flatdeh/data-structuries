package com.vlad.datastructures.queue;



public class LinkedQueueTest extends AbstractQueueTest{
    @Override
    public Queue getQueue() {
        return new LinkedQueue();
    }
    //    @Test
//    public void testEnqueue() {
//        LinkedQueue<String> linkedQueue = new LinkedQueue<>();
//        linkedQueue.enqueue("a");
//        assertEquals("a", linkedQueue.toString());
//        linkedQueue.enqueue("b");
//        linkedQueue.enqueue("c");
//        assertEquals("abc", linkedQueue.toString());
//        assertEquals(3, linkedQueue.getSize());
//    }
//
//    @Test
//    public void testDequeue() {
//        LinkedQueue<String> linkedQueue = new LinkedQueue<String>();
//        linkedQueue.enqueue("a");
//        linkedQueue.enqueue("b");
//        linkedQueue.enqueue("c");
//        assertEquals("a", linkedQueue.dequeue());
//        assertEquals("b", linkedQueue.dequeue());
//        assertEquals("c", linkedQueue.dequeue());
//
//        assertEquals("", linkedQueue.toString());
//    }
//
//    @Test
//    public void testGetSize() {
//        LinkedQueue<String> linkedQueue = new LinkedQueue<String>();
//        linkedQueue.enqueue("a");
//        linkedQueue.enqueue("b");
//        linkedQueue.enqueue("c");
//        assertEquals("a", linkedQueue.dequeue());
//        assertEquals("b", linkedQueue.dequeue());
//        assertEquals("c", linkedQueue.dequeue());
//
//        assertEquals("", linkedQueue.toString());
//        assertEquals(0, linkedQueue.getSize());
//    }
}
