package com.java.adtAI.array;

import java.util.EmptyStackException;

/**
 * Array-based implementation of Stack ADT
 * Follows LIFO (Last In, First Out) principle
 */
public class ArrayStack<T> {
    private T[] stack;
    private int top; // Index of top element
    private static final int DEFAULT_CAPACITY = 10;
    
    @SuppressWarnings("unchecked")
    public ArrayStack() {
        stack = (T[]) new Object[DEFAULT_CAPACITY];
        top = -1; // Stack is empty when top = -1
    }
    
    // Add element to top of stack
    public void push(T element) {
        if (top == stack.length - 1) {
            resize(); // Expand if full
        }
        stack[++top] = element; // Increment top and add element
    }
    
    // Remove and return top element
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException(); // Cannot pop from empty stack
        }
        T element = stack[top];
        stack[top--] = null; // Help GC and decrement top
        return element;
    }
    
    // Return top element without removing it
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[top];
    }
    
    // Check if stack is empty
    public boolean isEmpty() {
        return top == -1;
    }
    
    // Get number of elements in stack
    public int size() {
        return top + 1;
    }
    
    // Double the stack capacity
    @SuppressWarnings("unchecked")
    private void resize() {
        int newCapacity = stack.length * 2;
        T[] newStack = (T[]) new Object[newCapacity];
        System.arraycopy(stack, 0, newStack, 0, top + 1);
        stack = newStack;
    }
    
    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i <= top; i++) {
            sb.append(stack[i]);
            if (i < top) sb.append(", ");
        }
        sb.append("] top");
        return sb.toString();
    }
}

