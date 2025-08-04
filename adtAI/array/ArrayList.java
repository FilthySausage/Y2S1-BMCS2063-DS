package com.java.adtAI.array;

/**
 * Array-based implementation of List ADT
 * Positions start from 1 (user-friendly)
 * Indices start from 0 (array requirement)
 */
public class ArrayList<T> {
    private T[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    
    @SuppressWarnings("unchecked")
    public ArrayList() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }
    
    @SuppressWarnings("unchecked")
    public ArrayList(int capacity) {
        array = (T[]) new Object[capacity];
        size = 0;
    }
    
    // Add element at the end
    public boolean add(T element) {
        if (size == array.length) {
            resize(); // Double the capacity if full
        }
        array[size] = element;
        size++;
        return true;
    }
    
    // Add element at specific position (1-based)
    public boolean add(int position, T element) {
        if (position < 1 || position > size + 1) {
            return false; // Invalid position
        }
        
        if (size == array.length) {
            resize();
        }
        
        // Shift elements to the right
        for (int i = size; i >= position; i--) {
            array[i] = array[i - 1];
        }
        
        array[position - 1] = element; // Convert to 0-based index
        size++;
        return true;
    }
    
    // Remove element at specific position (1-based)
    public T remove(int position) {
        if (position < 1 || position > size) {
            return null; // Invalid position
        }
        
        T removedElement = array[position - 1]; // Get element to remove
        
        // Shift elements to the left
        for (int i = position - 1; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        
        array[size - 1] = null; // Help GC
        size--;
        return removedElement;
    }
    
    // Get element at specific position (1-based)
    public T get(int position) {
        if (position < 1 || position > size) {
            return null; // Invalid position
        }
        return array[position - 1]; // Convert to 0-based index
    }
    
    // Replace element at specific position
    public T set(int position, T element) {
        if (position < 1 || position > size) {
            return null; // Invalid position
        }
        
        T oldElement = array[position - 1];
        array[position - 1] = element;
        return oldElement;
    }
    
    // Check if list contains element
    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                return true;
            }
        }
        return false;
    }
    
    // Get current size
    public int size() {
        return size;
    }
    
    // Check if list is empty
    public boolean isEmpty() {
        return size == 0;
    }
    
    // Double the array capacity
    @SuppressWarnings("unchecked")
    private void resize() {
        int newCapacity = array.length * 2;
        T[] newArray = (T[]) new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }
    
    @Override
    public String toString() {
        if (size == 0) return "[]";
        
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}

