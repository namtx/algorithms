package dev.namtx.leetcode.reducearraytohalfsize;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> h = new HashMap<>();
        int N = arr.length;
        for (int i: arr) {
            int count = h.getOrDefault(i, 0);
            count++;
            h.put(i, count);
        }

        int[] occurrences = new int[h.keySet().size()];
        int i = 0;
        for (int v: h.values()) {
            occurrences[i++] = v;
        }

        Arrays.sort(occurrences); // ascending
        int n = occurrences.length;

        int k = 1;
        while (k < N) {
            int sum = 0;
            for (int j = n - 1; j >= n - k; j--) {
                sum += occurrences[j];
            }
            if (sum >= N/2) {
                return k;
            }
            k++;
        }

        return k;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{3,3,3,3,5,5,5,2,2,7};
        System.out.println(solution.minSetSize(arr));
    }
}

