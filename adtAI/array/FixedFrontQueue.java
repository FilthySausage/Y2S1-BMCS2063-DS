package com.java.adtAI.array;

import java.util.NoSuchElementException;

/**
 * Array-based Queue with fixed front implementation
 * Follows FIFO (First In, First Out) principle
 * Front stays at index 0, rear moves as elements are added
 */
public class FixedFrontQueue<T> {
    private T[] queue;
    private int rear; // Index of last element
    private static final int DEFAULT_CAPACITY = 10;
    
    @SuppressWarnings("unchecked")
    public FixedFrontQueue() {
        queue = (T[]) new Object[DEFAULT_CAPACITY];
        rear = -1; // Queue is empty when rear = -1
    }
    
    // Add element to rear of queue
    public void enqueue(T element) {
        if (rear == queue.length - 1) {
            throw new IllegalStateException("Queue is full");
        }
        queue[++rear] = element; // Add at rear and increment
    }
    
    // Remove and return front element
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        
        T element = queue[0]; // Front is always at index 0
        
        // Shift all elements one position left
        for (int i = 0; i < rear; i++) {
            queue[i] = queue[i + 1];
        }
        
        queue[rear--] = null; // Help GC and decrement rear
        return element;
    }
    
    // Return front element without removing it
    public T front() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return queue[0]; // Front is always at index 0
    }
    
    // Check if queue is empty
    public boolean isEmpty() {
        return rear == -1;
    }
    
    // Get number of elements in queue
    public int size() {
        return rear + 1;
    }
    
    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i <= rear; i++) {
            sb.append(queue[i]);
            if (i < rear) sb.append(", ");
        }
        sb.append("] front->rear");
        return sb.toString();
    }
}

