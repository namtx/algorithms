package dev.namtx.datastructures.stack;

public interface IStack<T> {
    public int size();

    public boolean isEmpty();

    public void push(T element);

    public T pop();

    public T peek();
}
