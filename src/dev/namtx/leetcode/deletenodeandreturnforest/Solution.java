package dev.namtx.leetcode.deletenodeandreturnforest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Solution {
    public List<TreeNode> recursive(TreeNode root, Map<Integer, Boolean> marked, List<TreeNode> ret) {
        if (root == null) {
            return new ArrayList<>();
        }

        if (marked.getOrDefault(root.val, false)) {
            if (root.left != null) {
                ret = recursive(root.left, marked, ret);
            }
            if (root.right != null) {
                ret = recursive(root.right, marked, ret);
            }

            return ret;
        } else {
            return new ArrayList<>();
        }
    }
}

