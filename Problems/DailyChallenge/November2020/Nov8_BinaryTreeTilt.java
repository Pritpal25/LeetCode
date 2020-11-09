package DailyChallenge.November2020;

/*
Given the root of a binary tree, return the sum of every tree node's tilt.

The tilt of a tree node is the absolute difference between the sum of all left subtree node values and all right subtree node values.
If a node does not have a left child, then the sum of the left subtree node values is treated as 0.
The rule is similar if there the node does not have a right child.
 */

public class Nov8_BinaryTreeTilt
{
    public class TreeNode {
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
 
    int tilt = 0;

    public int findTilt(TreeNode root) {
        findSum(root);
        return tilt;
    }

    private int findSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = findSum(root.left);
        int rightSum = findSum(root.right);

        tilt += Math.abs(leftSum-rightSum);

        return leftSum + rightSum + root.val;
    }
}
