package dev.namtx.leetcode.allnodesdistancekinbinarytree;

import dev.namtx.datastructures.treenode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    Map<TreeNode, Integer> map = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();

        findTarget(root, target);
        search(root, target, k, map.get(root), result);

        return result;
    }

    public int findTarget(TreeNode root, TreeNode target) {
        if (root == null)
            return -1;

        if (root == target) {
            map.put(root, 0);
            return 0;
        }

        int left = findTarget(root.left, target);
        if (left >= 0) {
            map.put(root, left + 1);
            return left + 1;
        }

        int right = findTarget(root.right, target);
        if (right >= 0) {
            map.put(root, right + 1);
            return right + 1;
        }

        return -1;
    }

    public void search(TreeNode root, TreeNode target, int k, int distance, List<Integer> result) {
        if (root == null) return;

        if (map.containsKey(root))
            distance = map.get(root);

        if (distance == k)
            result.add(root.val);

        search(root.left, target, k, distance + 1, result);
        search(root.right, target, k, distance + 1, result);
    }
}

class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        Solution solution = new Solution();
        System.out.println(solution.distanceK(root, root.left.right, 2));
    }
}
