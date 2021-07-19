package dev.namtx.leetcode.excelsheetcolumntitle;

public class Solution {
    public String convertToTitle(int columnNumber) {
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder r = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--;
            int i = columnNumber % 26;
            r.insert(0, s.charAt(i));
            columnNumber /= 26;
        }

        return r.toString();
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convertToTitle(701));
    }
}
