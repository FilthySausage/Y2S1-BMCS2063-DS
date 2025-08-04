package com.java.adtSelf;

public interface ListADT<T> {
    public boolean add(T obj);
    public boolean addAt(int position, T obj);
    public T removeAt(int position);
    public boolean isEmpty();
    public int getSize();
}
