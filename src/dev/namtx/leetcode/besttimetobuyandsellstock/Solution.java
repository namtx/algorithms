package dev.namtx.leetcode.besttimetobuyandsellstock;

public class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] prices = new int[] {1,7};

        System.out.println(solution.maxProfit(prices));
    }
}
