package dev.namtx.leetcode.pathsumiii;

import dev.namtx.datastructures.treenode.TreeNode;

class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return 0;
        return pathSum(root.left, targetSum) + pathSum(root.right, targetSum) + pathSumWithoutRoot(root, targetSum);
    }

    private static int pathSumWithoutRoot(TreeNode root, int targetSum) {
        if (root == null)
            return 0;

        int r = 0;
        if (root.val == targetSum)
            r++;

        r += pathSumWithoutRoot(root.left, targetSum - root.val);
        r += pathSumWithoutRoot(root.right, targetSum - root.val);

        return r;
    }
}

class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        Solution solution = new Solution();

        System.out.println(solution.pathSum(root, 1));
    }
}
