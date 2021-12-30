package dev.namtx.leetcode.intervalsbetweenidenticallelements;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/intervals-between-identical-elements/

public class Solution {
    public long[] getDistances(int[] arr) {
        Map<Integer, Long> backOccurrences = new HashMap<>();
        Map<Integer, Long> backSum = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            long occurrences = backOccurrences.getOrDefault(arr[i], 0L);
            long s = backSum.getOrDefault(arr[i], 0L);
            backOccurrences.put(arr[i], occurrences + 1);
            backSum.put(arr[i], s + i);
        }

        Map<Integer, Long> frontOccurrences = new HashMap<>();
        Map<Integer, Long> frontSum = new HashMap<>();

        long[] result = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            long fo = frontOccurrences.getOrDefault(arr[i], 0L);
            long bo = backOccurrences.getOrDefault(arr[i], 0L);
            long fs = frontSum.getOrDefault(arr[i], 0L);
            long bs = backSum.getOrDefault(arr[i], 0L);

            result[i] = fo * i - (fs) + (bs - i) - (bo - 1) * i;
            frontOccurrences.put(arr[i], fo + 1);
            backOccurrences.put(arr[i], bo - 1);
            frontSum.put(arr[i], fs + i);
            backSum.put(arr[i], bs - i);
        }

        return result;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.getDistances(new int[]{2, 1, 3, 1, 2, 3, 3})));
        System.out.println(Arrays.toString(solution.getDistances(new int[]{10, 5, 10, 10})));
        System.out.println(Arrays.toString(solution.getDistances(new int[]{1})));
        System.out.println(Arrays.toString(solution.getDistances(new int[]{1, 2})));
    }
}
