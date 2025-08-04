package com.java.adtAI.linked;

import java.util.NoSuchElementException;

/**
 * Doubly Linked List implementation of Queue ADT
 * Each node has references to both next and previous nodes
 * Follows FIFO (First In, First Out) principle
 */
public class DoublyLinkedQueue<T> {
    private Node<T> front; // Front of queue
    private Node<T> rear;  // Rear of queue
    private int size;
    
    // Node class for doubly linked list
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;
        
        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    
    public DoublyLinkedQueue() {
        front = null;
        rear = null;
        size = 0;
    }
    
    // Add element to rear of queue
    public void enqueue(T element) {
        Node<T> newNode = new Node<>(element);
        
        if (rear == null) {
            // First element
            front = rear = newNode;
        } else {
            // Add to rear
            newNode.prev = rear;
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
        
        if (front == rear) {
            // Only one element
            front = rear = null;
        } else {
            // Move front to next element
            front = front.next;
            front.prev = null;
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
