package com.java.adtAI.linked;

import java.util.EmptyStackException;

/**
 * Linked List implementation of Stack ADT
 * Follows LIFO (Last In, First Out) principle
 */
public class LinkedStack<T> {
    private Node<T> top; // Top of stack
    private int size;
    
    // Node class for stack
    private static class Node<T> {
        T data;
        Node<T> next;
        
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public LinkedStack() {
        top = null;
        size = 0;
    }
    
    // Add element to top of stack
    public void push(T element) {
        Node<T> newNode = new Node<>(element);
        newNode.next = top;
        top = newNode;
        size++;
    }
    
    // Remove and return top element
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        
        T element = top.data;
        top = top.next; // Move top to next element
        size--;
        return element;
    }
    
    // Return top element without removing it
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }
    
    // Check if stack is empty
    public boolean isEmpty() {
        return top == null;
    }
    
    // Get number of elements in stack
    public int size() {
        return size;
    }
    
    @Override
    public String toString() {
        if (top == null) return "[]";
        
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = top;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        sb.append("] top");
        return sb.toString();
    }
}
