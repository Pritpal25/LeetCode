package DailyChallenge;

/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.
 */

class MinDepthOfBinaryTree
{
    class TreeNode {
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

    public int minDepth(TreeNode root) {
        return minDepth(root, 0);
    }

    private int minDepth(TreeNode root, int currDepth) {
        if (root == null) {
            return currDepth;
        }

        if (root.left == null) {
            return minDepth(root.right, currDepth+1);
        }

        if (root.right == null) {
            return minDepth(root.left, currDepth+1);
        }

        return Math.min(minDepth(root.left, currDepth+1), minDepth(root.right, currDepth+1));
    }
}