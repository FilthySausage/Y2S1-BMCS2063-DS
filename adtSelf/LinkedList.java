package com.java.adtSelf;

public class LinkedList<T> implements ListADT<T> {
    int size;
    Node firstNode;

    public LinkedList() {
        size = 0;
        firstNode = null;
    }

    public class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    @Override
    public boolean add(T obj) {
        Node n = new Node(obj);

        if (firstNode == null) {
            firstNode = n;
        } else {
            Node current = firstNode;
            while (current.next != null) {
                current = current.next;
            }
            current.next = n;
        }

        size++;
        return true;
    }

    @Override
    public boolean addAt(int position, T obj) {
        if (position < 1 || (position > size + 1)) {
            return false;
        } else {
            Node n = new Node(obj);

            if (position == 1) {
                firstNode = n;
            } else {
                Node before = firstNode;
                for (int i = 1; i < position - 1; i++) {
                    before = before.next;
                }
                n.next = before.next;
                before.next = n;
            }
        }

        size++;
        return true;
    }

    @Override
    public T removeAt(int position) {
        T result = null;

        if (position < 1 || position > size) {
            return null;
        } else {
            if (position == 1) {
                result = firstNode.data;
                firstNode = null;
            } else {
                Node before = firstNode;
                for (int i = 1; i < position - 1; i++) {
                    before = before.next;
                }
                result = before.next.data;
                before.next = before.next.next;
            }
        }

        size--;
        return result;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

}
