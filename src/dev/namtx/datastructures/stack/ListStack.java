package dev.namtx.datastructures.stack;

public class ListStack<T> implements IStack<T>{
    private java.util.LinkedList<T> list = new java.util.LinkedList<>();

    public ListStack() {}

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void push(T element) {
        list.addLast(element);
    }

    @Override
    public T pop() {
        if (isEmpty()) throw new java.util.EmptyStackException();
        return list.removeLast();
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new java.util.EmptyStackException();

        return list.peekLast();
    }
}
