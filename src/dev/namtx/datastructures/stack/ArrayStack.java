package dev.namtx.datastructures.stack;

public class ArrayStack<T> implements IStack<T> {
    private int size;
    private int capacity;
    private Object[] data;

    public ArrayStack() {
        capacity = 16;
        data = new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void push(T element) {
        if (size == capacity) {
            increaseCapacity();
        }

        data[size++] = element;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) throw new java.util.EmptyStackException();
        T element = (T) data[--size];
        data[size] = null;
        return element;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) throw new java.util.EmptyStackException();

        return (T) data[size-1];
    }

    private void increaseCapacity() {
        capacity *= 2;
        data = java.util.Arrays.copyOf(data, capacity);
    }
}
