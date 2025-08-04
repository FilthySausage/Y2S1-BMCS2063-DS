package com.java.adtAI.linked;

/**
 * Singly Linked List implementation
 * Each node contains data and reference to next node
 */
public class LinkedList<T> {
    private Node<T> head; // First node
    private int size;
    
    // Node class for linked list
    private static class Node<T> {
        T data;
        Node<T> next;
        
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public LinkedList() {
        head = null;
        size = 0;
    }
    
    // Add element at the beginning
    public void addFirst(T element) {
        Node<T> newNode = new Node<>(element);
        newNode.next = head;
        head = newNode;
        size++;
    }
    
    // Add element at the end
    public void addLast(T element) {
        Node<T> newNode = new Node<>(element);
        
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }
    
    // Add element at specific position (0-based)
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        if (index == 0) {
            addFirst(element);
            return;
        }
        
        Node<T> newNode = new Node<>(element);
        Node<T> current = head;
        
        // Traverse to node before insertion point
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }
    
    // Remove first element
    public T removeFirst() {
        if (head == null) {
            return null;
        }
        
        T element = head.data;
        head = head.next;
        size--;
        return element;
    }
    
    // Remove element at specific index
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        if (index == 0) {
            return removeFirst();
        }
        
        Node<T> current = head;
        
        // Traverse to node before the one to remove
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        
        T element = current.next.data;
        current.next = current.next.next;
        size--;
        return element;
    }
    
    // Get element at specific index
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
    
    // Check if list contains element
    public boolean contains(T element) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(element)) {
                return true;
            }
            current = current.next;
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
    
    @Override
    public String toString() {
        if (head == null) return "[]";
        
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
