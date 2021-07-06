package dev.namtx.datastructures.stack;

public class Main {
    public static void main(String[] args) {
        int n = 10000000;

        // benchmark ArrayStack
        long start = System.nanoTime();
        IStack<Integer> arrayStack = new ArrayStack<>();

        for (int i = 0; i < n; i++) arrayStack.push(i);
        for (int i = 0; i < n; i++) arrayStack.pop();

        long end = System.nanoTime();
        System.out.println("ArrayStack Time: " + (end - start) / 1e9);

        // benchmark ListStack
        start = System.nanoTime();
        IStack<Integer> listStack = new ListStack<>();

        for (int i = 0; i < n; i++) listStack.push(i);
        for (int i = 0; i < n; i++) listStack.pop();

        end = System.nanoTime();
        System.out.println("ListStack Time: " + (end - start) / 1e9);
    }
}
