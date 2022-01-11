package dev.namtx.leetcode.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 56. Merge Intervals
 * https://leetcode.com/problems/merge-intervals/
 * <p>
 * Example 1:
 * <p>
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 */

class Interval {
    public int left;
    public int right;

    public Interval(int left, int right) {
        this.left = left;
        this.right = right;
    }
}

class IntervalComparator implements Comparator<Interval> {
    @Override
    public int compare(Interval o1, Interval o2) {
        return o1.left - o2.left;
    }
}

public class Solution {
    public int[][] merge(int[][] intervals) {
        Interval[] intervalArr = new Interval[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            intervalArr[i] = new Interval(intervals[i][0], intervals[i][1]);
        }

        ArrayList<Interval> r = new ArrayList<>();
        Arrays.sort(intervalArr, new IntervalComparator());

        int i = 0;
        while (i < intervals.length) {
            int j = i + 1;
            int min = intervalArr[i].left;
            int max = intervalArr[i].right;
            while (j < intervals.length && intervalArr[j].left >= min && intervalArr[j].left <= max) {
                max = Math.max(max, intervalArr[j].right);
                j++;
            }
            if (j == intervals.length) {
                r.add(new Interval(min, max));
                break;
            } else {
                r.add(new Interval(min, max));
                i = j;
            }
        }

        int[][] rr = new int[r.size()][2];
        for (int k = 0; k < r.size(); k++) {
            rr[k] = new int[]{r.get(k).left, r.get(k).right};
        }

        return rr;
    }
}

class Main {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        // int[][] arr = new int[][]{{1, 4}, {4, 5}};
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.merge(arr)));
    }
}
