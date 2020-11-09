package DailyChallenge.November2020;

/*
Given the root of a binary tree, find the maximum value V for which there exist different nodes A and B where V = |A.val - B.val| and A is an ancestor of B.

A node A is an ancestor of B if either: any child of A is equal to B, or any child of A is an ancestor of B.
 */

public class Nov9_MaxDiffBetweenNodesAndAncestor
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
 
    int maxDiff = Integer.MIN_VALUE;

    public int maxAncestorDiff(TreeNode root) {
        minMax(root);

        return maxDiff;
    }

    private int[] minMax(TreeNode t) {
        int[] left;
        int[] right;
        if (t.left == null && t.right == null) {
            return new int[]{t.val, t.val};
        } else if (t.left == null) {
            right = minMax(t.right);
            left = right;
        } else if (t.right == null) {
            left = minMax(t.left);
            right = left;
        } else {
            left = minMax(t.left);
            right = minMax(t.right);
        }

        int min = Math.min(left[0], right[0]);
        maxDiff = Math.max(Math.abs(t.val - min), maxDiff);
        min = Math.min(min, t.val);

        int max = Math.max(left[1], right[1]);
        maxDiff = Math.max(Math.abs(t.val - max), maxDiff);
        max = Math.max(max, t.val);

        return new int[]{min, max};
    }
}
