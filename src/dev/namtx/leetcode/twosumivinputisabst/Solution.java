package dev.namtx.leetcode.twosumivinputisabst;

import java.util.HashSet;
import java.util.Set;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        return hasTarget(root, k, new HashSet<>());
    }

    private static boolean hasTarget(TreeNode root, int k, Set<Integer> s) {
        if (root == null) return false;

        if (s.contains(root.val))
            return true;
        else
            s.add(k - root.val);

        boolean hasTargetOnLeft = hasTarget(root.left, k, s);
        boolean hasTargetOnRight = hasTarget(root.right, k, s);

        return hasTargetOnLeft || hasTargetOnRight;
    }

}

class Main {
    public static void main(String[] args) {
    }
}
