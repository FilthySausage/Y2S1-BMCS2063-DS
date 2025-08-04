package com.java.adtSelf;

public interface QueueADT<T> {
    public void enqueue(T obj);
    public T dequeue();
    public boolean isEmpty();
}
