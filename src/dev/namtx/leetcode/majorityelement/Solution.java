package dev.namtx.leetcode.majorityelement;


public class Solution {
    public int majorityElement(int[] nums) {
        int curr = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                curr = nums[i];
                count++;
            } else {
                if (nums[i] == curr) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        return curr;
    }
}

class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{2,2,1,1,1,2,2};

        Solution solution = new Solution();
        System.out.println(solution.majorityElement(arr));
    }
}
