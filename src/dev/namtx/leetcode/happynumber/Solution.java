package dev.namtx.leetcode.happynumber;

import java.util.HashMap;

public class Solution {
    public boolean isHappy(int n) {
        HashMap<Integer, Boolean> checked = new HashMap<>();
        checked.put(n, true);
        while (true) {
            int squared = computeSquare(n);
            // System.out.println(squared);
            if (squared == 1) return true;
            if (checked.getOrDefault(squared, false)) {
                return false;
            } else {
                checked.put(squared, true);
            }
            n = squared;
        }
    }

    public boolean isHappy2(int n) {
        int slow = n;
        int fast = n;

        while (slow != 1 && fast != 1) {
            slow = computeSquare(slow);
            fast = computeSquare(computeSquare(fast));
            if (slow == fast && slow != 1)
                return false;
        }

        return true;
    }

    public static int computeSquare(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }

        return sum;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isHappy2(2));
    }
}
