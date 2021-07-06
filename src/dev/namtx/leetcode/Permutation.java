package dev.namtx.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Permutation {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.permute(new int[]{1,2,3}));
    }
}

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();

        backtrack(nums, result, tmp);

        return result;
    }

    public void backtrack(int[] nums, List<List<Integer>> result, List<Integer> tmp) {
        if (tmp.size()== nums.length) {
            result.add(new ArrayList<>(tmp));
        } else {
            for (int num : nums) {
                if (tmp.contains(num)) continue;

                tmp.add(num);
                backtrack(nums, result, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
