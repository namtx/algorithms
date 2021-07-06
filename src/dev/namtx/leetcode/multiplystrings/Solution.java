package dev.namtx.leetcode.multiplystrings;

public class Solution {
    public String multiply(String num1, String num2) {
        String ret = "0";

        for (int i = 0; i < num2.length(); i++) {
            String tmp = multiplyWithSingleNumber(num1, Integer.parseInt(String.valueOf(num2.charAt(i))));
            if (!tmp.equals("0")) {
                for (int j = 0; j < num2.length() - i - 1; j++) {
                    tmp = tmp.concat("0");
                }
            }
            System.out.println(tmp);

            ret = addTwoString(ret, tmp);
            System.out.println(ret);
        }

        return ret;
    }

    public static String multiplyWithSingleNumber(String num1, int n) {
        String ret = "0";
        for (int i = 0; i < n; i++) {
            ret = addTwoString(ret, num1);
        }

        return ret;
    }

    public static String addTwoString(String num1, String num2) {
        //   7 3 8
        // 6 1 5 0
        // 6 8 8 8

        StringBuilder ret = new StringBuilder();

        if (num1.length() < num2.length()) { // swap
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }

        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;
        int curr = 0;

        while (l1 >= 0 && l2 >= 0) {
            int temp = Integer.parseInt(String.valueOf(num1.charAt(l1))) + Integer.parseInt(String.valueOf(num2.charAt(l2))) + curr;
            if (temp >= 10) {
                ret.insert(0, (temp - 10));
                curr = 1;
            } else {
                ret.insert(0, temp);
                curr = 0;
            }

            l1--;
            l2--;
        }

        if (l1 >= 0) {
            while (l1 >= 0) {
                int temp = Integer.parseInt(String.valueOf(num1.charAt(l1))) + curr;
                if (temp >= 10) {
                    ret.insert(0, (temp - 10));
                    curr = 1;
                } else {
                    ret.insert(0, temp);
                    curr = 0;
                }
                l1--;
            }
        }

        if (curr > 0) {
            ret.insert(0, curr);
        }

        return ret.toString();
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(solution.multiply("2925", "4787"));
        System.out.println(Solution.addTwoString("13981500", "20475"));
    }
}
