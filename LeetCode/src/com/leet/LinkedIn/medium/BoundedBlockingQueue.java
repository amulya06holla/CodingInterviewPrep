package com.leet.LinkedIn.medium;
//https://leetcode.com/problems/design-bounded-blocking-queue/
// THIS IS THE INBUILD BOUNDED QUEUE ARTICLE: https://www.baeldung.com/java-blocking-queue
// this cant be used in coding. instead something like this has to be implemented.
//https://leetcode.com/problems/design-bounded-blocking-queue/discuss/1451461/3-Semaphore-oror-Easy-to-understand-oror-Java-oror-Explained-in-detail

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Semaphore;

public class BoundedBlockingQueue {

    Deque <Integer> dq;
    Semaphore capacityMax;
    Semaphore capacityMin;
    Semaphore queueMutex;   // for the deque -> named using mutex because of mutext property of locking on 1 thread

    public BoundedBlockingQueue(int capacity) {
        dq = new ArrayDeque <>();
        capacityMax = new Semaphore(capacity); // there are as many max semaphores as the capacity.
        capacityMin = new Semaphore(0); // min semaphore is set to 0. bcz this value can also be negative,
        // and if negative then it must be first released to be used.
        // as and how the capacitymin is released, it becomes available.
        queueMutex = new Semaphore(1);
    }

    public void enqueue(int element) throws InterruptedException {
        capacityMax.acquire(); // acquiring max semaphore (1 of the many maxsemaphores avaialble will be acquired.)
        // if all are taken then it blocks the call until one is avaialble.
        queueMutex.acquire(); // queue one is specific for any queue related activity

        dq.addFirst(element);

        queueMutex.release();
        capacityMin.release(); // releasing minsemaphore because now there are more than one element in the queue for sure and no need to worry about capacity being 0.
    }

    public int dequeue() throws InterruptedException {
        capacityMin.acquire(); // acquring one of the min semaphores bcz something is getting dequeued.
        queueMutex.acquire();

        int val = dq.removeLast();

        queueMutex.release();
        capacityMax.release(); // capacitymax is released. since one of the element is removed from queue definitely one of the maxsemaphores became avaialble.

        return val;

    }

    public int size() throws InterruptedException {
        queueMutex.acquire();
        int size = dq.size();
        queueMutex.release();

        return size;
    }
}
