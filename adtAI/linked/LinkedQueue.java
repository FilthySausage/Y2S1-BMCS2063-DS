package com.java.adtAI.linked;

import java.util.NoSuchElementException;

/**
 * Linked List implementation of Queue ADT
 * Follows FIFO (First In, First Out) principle
 */
public class LinkedQueue<T> {
    private Node<T> front; // Front of queue
    private Node<T> rear;  // Rear of queue
    private int size;
    
    // Node class for queue
    private static class Node<T> {
        T data;
        Node<T> next;
        
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public LinkedQueue() {
        front = null;
        rear = null;
        size = 0;
    }
    
    // Add element to rear of queue
    public void enqueue(T element) {
        Node<T> newNode = new Node<>(element);
        
        if (rear == null) {
            // Queue is empty
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }
    
    // Remove and return front element
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        
        T element = front.data;
        front = front.next;
        
        if (front == null) {
            // Queue became empty
            rear = null;
        }
        
        size--;
        return element;
    }
    
    // Return front element without removing it
    public T front() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return front.data;
    }
    
    // Check if queue is empty
    public boolean isEmpty() {
        return front == null;
    }
    
    // Get number of elements in queue
    public int size() {
        return size;
    }
    
    @Override
    public String toString() {
        if (front == null) return "[]";
        
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = front;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        sb.append("] front->rear");
        return sb.toString();
    }
}
