package dev.namtx.leetcode.addbinarystring;

public class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int curr = '0';
        StringBuilder result = new StringBuilder();

        if (i < j) {
            String temp = a;
            a = b;
            b = temp;
        }

        while (i >= 0 && j >= 0) {
            char ai = a.charAt(i);
            char bj = b.charAt(j);
            if (ai == bj) {
                result.insert(0, (char) curr);
                if (ai == '0') {
                    curr = '0';
                } else {
                    curr = '1';
                }
            } else {
                if (curr == '0') {
                    result.insert(0, '1');
                } else {
                    result.insert(0, '0');
                }
            }
            i--;
            j--;
        }

        if (i >= 0) {
            if (curr == '0') {
                result.insert(0, a.substring(0, i+1));
            } else {
                while (i >= 0) {
                    char ai = a.charAt(i);
                    if (ai == '1') {
                        if (curr == '0') {
                            result.insert(0, '1');
                        } else {
                            result.insert(0, '0');
                        }
                    } else {
                        result.insert(0, (char) curr);
                        curr = '0';
                    }
                    i--;
                }
            }
        }

        if (curr == '1') {
            result.insert(0, (char) curr);
        }

        return result.toString();
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("1010", "1"));
    }
}
