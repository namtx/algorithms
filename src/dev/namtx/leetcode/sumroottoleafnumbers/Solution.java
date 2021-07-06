package dev.namtx.leetcode.sumroottoleafnumbers;

import dev.namtx.datastructures.treenode.TreeNode;

public class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return helper(root, 0);
    }

    public int helper(TreeNode root, int current) {
        if (root.right == null && root.left == null) {
            return current * 10 + root.val;
        }

        int sum = 0;
        if (root.left != null) {
            sum += helper(root.left, current * 10 + root.val);
        }
        if (root.right != null) {
            sum += helper(root.right, current * 10 + root.val);
        }

        return sum;
    }
}

class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.left.left = new TreeNode(5);

        Solution solution = new Solution();
        System.out.println(solution.sumNumbers(root));
    }
}
