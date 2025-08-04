package com.java.adtAI.array;

import java.util.NoSuchElementException;

/**
 * Array-based Queue with dynamic front implementation
 * Follows FIFO (First In, First Out) principle
 * Both front and rear move as elements are added/removed
 */
public class DynamicFrontQueue<T> {
    private T[] queue;
    private int front; // Index of front element
    private int rear;  // Index of rear element
    private int size;  // Number of elements in queue
    private static final int DEFAULT_CAPACITY = 10;
    
    @SuppressWarnings("unchecked")
    public DynamicFrontQueue() {
        queue = (T[]) new Object[DEFAULT_CAPACITY];
        front = 0;
        rear = -1;
        size = 0;
    }
    
    // Add element to rear of queue
    public void enqueue(T element) {
        if (size == queue.length) {
            throw new IllegalStateException("Queue is full");
        }
        
        rear = (rear + 1) % queue.length; // Circular increment
        queue[rear] = element;
        size++;
    }
    
    // Remove and return front element
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        
        T element = queue[front];
        queue[front] = null; // Help GC
        front = (front + 1) % queue.length; // Circular increment
        size--;
        return element;
    }
    
    // Return front element without removing it
    public T front() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return queue[front];
    }
    
    // Check if queue is empty
    public boolean isEmpty() {
        return size == 0;
    }
    
    // Get number of elements in queue
    public int size() {
        return size;
    }
    
    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % queue.length;
            sb.append(queue[index]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("] front->rear");
        return sb.toString();
    }
}

