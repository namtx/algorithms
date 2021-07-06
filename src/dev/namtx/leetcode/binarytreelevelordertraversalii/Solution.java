package dev.namtx.leetcode.binarytreelevelordertraversalii;

import dev.namtx.datastructures.treenode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();

        //dfs(ret, 0, root);
        bfs(ret, root);

        Collections.reverse(ret);

        return ret;
    }

    public void dfs(List<List<Integer>> ret, int level, TreeNode root) {
        if (root == null)
            return;

        if (ret.size() == level) {
            List<Integer> newList = new ArrayList<>();
            newList.add(root.val);
            ret.add(level, newList);
        } else {
            List<Integer> existingList = ret.get(level);
            existingList.add(root.val);
            ret.set(level, existingList);
        }

        dfs(ret, level + 1, root.left);
        dfs(ret, level + 1, root.right);
    }

    public void bfs(List<List<Integer>> ret, TreeNode root) {
        if (root == null) return;

        Stack<List<TreeNode>> nodes = new Stack<>();
        List<TreeNode> initial = new ArrayList<>();
        initial.add(root);
        nodes.push(initial);

        while (!nodes.isEmpty()) {
            List<TreeNode> traversing = nodes.pop();
            List<TreeNode> next = new ArrayList<>();
            List<Integer> arr = new ArrayList<>();

            for (TreeNode node : traversing) {
                arr.add(node.val);
                if (node.left != null) {
                    next.add(node.left);
                }
                if (node.right != null) {
                    next.add(node.right);
                }
            }
            ret.add(arr);
            if (next.isEmpty()) break;
            nodes.push(next);
        }
    }
}

class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution solution = new Solution();
        System.out.println(solution.levelOrderBottom(root));
    }
}
