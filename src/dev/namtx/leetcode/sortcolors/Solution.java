package dev.namtx.leetcode.sortcolors;

/**
 * https://leetcode.com/problems/sort-colors/
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * v         v
 * [2,0,2,1,1,0]
 */
class Solution {
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        int i = 0;
        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, left, i);
                left++;
            } else if (nums[i] == 2) {
                swap(nums, right, i);
                right--;
                i--;
            }
            i++;
        }
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{2, 0, 1};
        solution.sortColors(arr);
    }
}
