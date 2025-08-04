package com.java.adtSelf;

public class ArrayList<T> implements ListADT<T> {

    final static int DEFAULT_SIZE = 10;
    T[] array;
    int size;

    public ArrayList() {
        this(DEFAULT_SIZE);
    }

    @SuppressWarnings("unchecked")
    public ArrayList(int initSize) {
        size = 0;
        array = (T[]) new Object[initSize];
    }

    @Override
    public boolean add(T obj) {
        array[size] = obj;
        size++;

        return true;
    }

    @Override
    public boolean addAt(int position, T obj) {

        if (position < 1 || (position > size + 1)) {
            return false;
        }

        array[position - 1] = obj;
        size++;
        return true;
    }

    @Override
    public T removeAt(int position) {
        if (position < 1 || position > size + 1) {
            return null;
        }

        return array[position - 1];
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
