package dev.namtx.leetcode.binarytreepath;

import dev.namtx.datastructures.treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> r = new ArrayList<>();
        helper(root, r, "");

        return r;
    }

    public void helper(TreeNode root, List<String> r, String current) {
        if (root == null) {
            return;
        }

        if (current.length() == 0) {
            current = current.concat("" + root.val);
        } else {
            current = current.concat("->" + root.val);
        }

        if (root.left != null) {
            helper(root.left, r, current);
        }
        if (root.right != null) {
            helper(root.right, r, current);
        }

        if (root.left == null && root.right == null) {
            r.add(current);
        }
    }
}

class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left .right = new TreeNode(5);

        Solution solution = new Solution();

        System.out.println(solution.binaryTreePaths(root));
    }
}
