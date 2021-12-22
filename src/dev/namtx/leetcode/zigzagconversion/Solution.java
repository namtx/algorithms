package dev.namtx.leetcode.zigzagconversion;

import java.util.ArrayList;

public class Solution {
    public String convert(String s, int numRows) {
        ArrayList<ArrayList<Character>> zigzag = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            zigzag.add(new ArrayList<>());
        }

        if (numRows < 2) {
            return s;
        }

        int step = 1;
        int row = 0;
        for (int i = 0; i < s.length(); i++) {
            ArrayList<Character> rowStr = zigzag.get(row);
            rowStr.add(s.charAt(i));
            zigzag.set(row, rowStr);
            row += step;

            if (row < 0 && step == -1) {
                row = 1;
                step = 1;
            }

            if (row == numRows && step == 1) {
                row = numRows - 2;
                step = -1;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            StringBuilder str = new StringBuilder();
            if (!zigzag.get(i).isEmpty()) {
                ArrayList<Character> r = zigzag.get(i);
                for (int j = 0; j < zigzag.get(i).size(); j++) {
                    str.append(r.get(j));
                }

                result.append(str);
            }
        }

        return result.toString();
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.convert("AB", 1));
    }
}
