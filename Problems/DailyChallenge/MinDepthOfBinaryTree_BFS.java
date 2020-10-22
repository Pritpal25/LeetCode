/* Copyright 2020 Amazon.com, Inc. or its affiliates. All Rights Reserved. */

package DailyChallenge;

/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.
 */

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

class MinDepthOfBinaryTree_BFS
{
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(root,1));

        Pair<TreeNode, Integer> curr = null;
        while(!queue.isEmpty()) {
            curr = queue.remove();

            TreeNode node = curr.getKey();
            if (node.left == null && node.right == null) {
                break;
            }

            if (node.left != null && node.right != null) {
                queue.add(new Pair(node.left, curr.getValue()+1));
                queue.add(new Pair(node.right, curr.getValue()+1));
            }
            else if (node.left != null) {
                queue.add(new Pair(node.left, curr.getValue()+1));
            }
            else if (node.right != null) {
                queue.add(new Pair(node.right, curr.getValue()+1));
            }
        }
        return curr.getValue();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3)));

        System.out.println(minDepth(root));
    }
}