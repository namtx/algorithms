package dev.namtx.leetcode.minstack;

import java.util.ArrayList;

public class MinStack {


    /**
     * initialize your data structure here.
     */
    MyStack mins;
    MyStack nums;

    public MinStack() {
        mins = new MyStack();
        nums = new MyStack();
    }

    public void push(int val) {
        nums.push(val);

        if (mins.size() == 0 || val <= mins.peek()) {
            mins.push(val);
        }
    }

    public void pop() {
        int val = nums.peek();
        nums.pop();
        if (val == mins.peek()) {
            mins.pop();
        }
    }

    public int top() {
        return nums.peek();
    }

    public int getMin() {
        return mins.peek();
    }

    class MyStack {
        ArrayList<Integer> arr;

        public MyStack() {
            arr = new ArrayList<>();
        }

        public void push(int val) {
            arr.add(val);
        }

        public int peek() {
            return arr.get(arr.size() - 1);
        }

        public void pop() {
            arr.remove(arr.size() - 1);
        }

        public int size() {
            return arr.size();
        }
    }
}
