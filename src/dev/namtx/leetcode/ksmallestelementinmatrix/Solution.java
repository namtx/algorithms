package dev.namtx.leetcode.ksmallestelementinmatrix;

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int[] currentIndexes = new int[matrix[0].length];

        int min;

        int count = 0;
        while (true) {
            min = Integer.MAX_VALUE;
            int minColumn = 0;

            for (int j = 0; j < currentIndexes.length; j++) {
                if (currentIndexes[j] < matrix.length && matrix[currentIndexes[j]][j] < min) {
                    min = matrix[currentIndexes[j]][j];
                    minColumn = j;
                }
            }

            currentIndexes[minColumn]++;
            count++;
            if (count == k) {
                return min;
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
//         int[][] matrix = new int[][] {{1,2}, {1,3}};
//         int[][] matrix = new int[][] {{1,5,9}, {10,11,13}, {12, 13, 15}};
        int[][] matrix = new int[][]{
            {1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}
        };

         Solution solution = new Solution();

         System.out.println(solution.kthSmallest(matrix, 5));
    }
}
