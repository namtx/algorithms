package dev.namtx.leetcode.longesthappystring;

import java.util.HashMap;

public class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder str = new StringBuilder();
        int total = a + b + c;
        int countA = 0;
        int countB = 0;
        int countC = 0;
        for (int i = 0; i < total; i++) {
            if ((a >= b && a >= c && countA != 2) || (a > 0 && (countB == 2 || countC == 2))) {
                a--;
                countA++;
                str.append("a");
                countB = 0;
                countC = 0;
            } else if ((b >= a && b >= c && countB != 2) || (b > 0 && (countA == 2 || countC == 2))) {
                b--;
                countB++;
                str.append("b");
                countA = 0;
                countC = 0;
            } else if ((c >= b && c >= a && countC != 2) || (c > 0 && (countB == 2 || countA == 2))) {
                c--;
                countC++;
                str.append("c");
                countA = 0;
                countB = 0;
            }
        }

        return str.toString();
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestDiverseString(1, 1, 7));
    }
}
