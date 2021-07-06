package dev.namtx.leetcode.findkclosestelements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int[] diff = new int[n];

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(x - arr[i]);
        }

        List<Integer> r = new ArrayList<>();

        if (x < arr[0]) {
            for (int i = 0; i < k; i++) {
                r.add(arr[i]);
            }

            return r;
        } else if (x > arr[n-1]) {
            for (int i = n - k; i < n; i++) {
                r.add(arr[i]);
            }
            return r;
        }

        int p1 = 0;
        int p2 = k;
        while(p2 < n) {
            if (diff[p1]  == diff[p2]) {
                p2++;
            } else if (diff[p1] > diff[p2]) {
                p2++;
                p1 = p2 - k;
            } else {
                break;
            }
        }
        for (int i = p1; i < p1+k; i++) {
            r.add(arr[i]);
        }
        return r;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{0,0,0,1,3,5,6,7,8,8};
        System.out.println(solution.findClosestElements(arr, 2, 2));
    }
}
