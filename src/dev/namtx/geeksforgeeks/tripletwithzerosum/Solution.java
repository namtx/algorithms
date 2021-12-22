package dev.namtx.geeksforgeeks.tripletwithzerosum;

import java.util.ArrayList;
import java.util.Arrays;

// https://www.geeksforgeeks.org/find-triplets-array-whose-sum-equal-zero/
public class Solution {
    public ArrayList<ArrayList<Integer>> findTriplets(int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            int l = i + 1;
            int r = arr.length - 1;

            while (l < r) {
                if (arr[l] + arr[r] + arr[i] == 0) {
                    // found
                    ArrayList<Integer> rr = new ArrayList<>();
                    rr.add(arr[i]);
                    rr.add(arr[l]);
                    rr.add(arr[r]);
                    result.add(rr);
                    break;
                } else if (arr[l] + arr[r] + arr[i] < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return result;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findTriplets(new int[]{-3, -1, 0, 1, 2}));
    }
}
