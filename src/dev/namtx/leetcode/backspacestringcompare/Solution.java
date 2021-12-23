package dev.namtx.leetcode.backspacestringcompare;

public class Solution {
    public boolean backspaceCompare(String s, String t) {
        int skipS = 0;
        int skipT = 0;
        int ps = s.length() - 1;
        int pt = t.length() - 1;

        while (ps >= 0 || pt >= 0) {
            while (ps >= 0) {
                if (s.charAt(ps) == '#') {
                    skipS++;
                    ps--;
                } else if (skipS > 0) {
                    skipS--;
                    ps--;
                } else break;
            }
            while (pt >= 0) {
                if (t.charAt(pt) == '#') {
                    skipT++;
                    pt--;
                } else if (skipT > 0) {
                    skipT--;
                    pt--;
                } else break;
            }
            if (pt >= 0 && ps >= 0 && s.charAt(ps) != t.charAt(pt)) {
                return false;
            }
            if ((ps >= 0) != (pt >= 0)) {
                return false;
            }

            ps--;
            pt--;
        }

        return true;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // System.out.println(solution.backspaceCompare("ab##", "c#d#"));
        // System.out.println(solution.backspaceCompare("a#c", "b"));
        System.out.println(solution.backspaceCompare("bbbextm", "bbb#extm"));
    }
}
