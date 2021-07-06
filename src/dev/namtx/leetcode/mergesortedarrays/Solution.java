package dev.namtx.leetcode.mergesortedarrays;

import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;

        int i = 0;
        int j = 0;
        int zeroIndex = m;
        while (i < nums1.length && j < nums2.length) {
            if (i == zeroIndex) {
                nums1[i++] = nums2[j++];
                zeroIndex++;
                continue;
            }
            if (nums1[i] < nums2[j]) {
                i++;
            } else {
                if (zeroIndex - i >= 0) System.arraycopy(nums1, i, nums1, i + 1, zeroIndex - i);
                nums1[i++] = nums2[j++];
                zeroIndex++;
            }
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        m--;
        n--;
        while (n >= 0 && m >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[index--] = nums1[m--];
            } else {
                nums1[index--] = nums2[n--];
            }
        }
        while (n >= 0) {
            nums1[index--] = nums2[n--];
        }
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = new int[]{-1,0,0,3,3,3,0,0,0};
        int[] nums2 = new int[]{1,2,2};
        solution.merge(nums1, 6, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
