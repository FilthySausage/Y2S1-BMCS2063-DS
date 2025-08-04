package com.java.adtSelf;

public interface StackADT<T> {
    public void push(T obj);
    public T peak();
    public T pop();
    public boolean isEmpty();
}
