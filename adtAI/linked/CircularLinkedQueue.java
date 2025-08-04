package com.java.adtAI.linked;

import java.util.NoSuchElementException;

/**
 * Circular Linked List implementation of Queue ADT
 * Last node points back to first node (circular structure)
 * Efficient for both enqueue and dequeue operations
 */
public class CircularLinkedQueue<T> {
    private Node<T> rear; // Reference to rear node (we maintain only one pointer)
    private int size;
    
    // Node class for circular queue
    private static class Node<T> {
        T data;
        Node<T> next;
        
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public CircularLinkedQueue() {
        rear = null;
        size = 0;
    }
    
    // Add element to rear of queue
    public void enqueue(T element) {
        Node<T> newNode = new Node<>(element);
        
        if (rear == null) {
            // First element
            rear = newNode;
            rear.next = rear; // Point to itself
        } else {
            // Insert after rear
            newNode.next = rear.next; // New node points to front
            rear.next = newNode;     // Old rear points to new node
            rear = newNode;          // Update rear to new node
        }
        
        size++;
    }
    
    // Remove and return front element
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        
        // When only one element
        if (rear.next == rear) {
            T element = rear.data;
            rear = null;
            size--;
            return element;
        }
        
        // Get front element (right after rear)
        Node<T> front = rear.next;
        T element = front.data;
        
        // Update rear's next to skip the front node
        rear.next = front.next;
        size--;
        return element;
    }
    
    // Return front element without removing it
    public T front() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return rear.next.data; // Front is right after rear
    }
    
    // Check if queue is empty
    public boolean isEmpty() {
        return rear == null;
    }
    
    // Get number of elements in queue
    public int size() {
        return size;
    }
    
    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = rear.next; // Start at front
        
        do {
            sb.append(current.data);
            if (current.next != rear.next) sb.append(", ");
            current = current.next;
        } while (current != rear.next); // Stop when we circle back to front
        
        sb.append("] front->rear");
        return sb.toString();
    }
}
