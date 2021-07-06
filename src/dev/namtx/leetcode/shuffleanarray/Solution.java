package dev.namtx.leetcode.shuffleanarray;

import java.util.Arrays;
import java.util.Random;

class Solution {
    int[] original;

    Random rand = new Random();

    public Solution(int[] nums) {
        original = Arrays.copyOf(nums, nums.length);
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] shuffled = Arrays.copyOf(original, original.length);
        for (int i = 1; i < shuffled.length; i++) {
            int randIndex = rand(i+1);
            // swap
            int tmp = shuffled[i];
            shuffled[i] = shuffled[randIndex];
            shuffled[randIndex] = tmp;
        }

        return shuffled;
    }

    // Get a random number in range 0..range by XORShift generator
    private int rand(int range) {
        return rand.nextInt(range);
    }
}

class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        Solution solution = new Solution(arr);
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.reset()));
    }
}
