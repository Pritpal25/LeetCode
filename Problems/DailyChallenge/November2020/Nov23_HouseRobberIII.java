package DailyChallenge.November2020;

public class Nov23_HouseRobberIII
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
    
    public int rob(TreeNode root) {
        // Constructing an array of inclusive, exclusive sums bottom up.
        int[] incExc = smartRob(root);
        return Math.max(incExc[0], incExc[1]);
    }

    private int[] smartRob(TreeNode root) {
        if (root == null) {
            return new int[]{0,0};
        } else {
            int[] left = smartRob(root.left);
            int[] right = smartRob(root.right);

            int[] current = new int[2];
            // inclusive sum at any node is the noda val + excl sums of both its child nodes.
            current[0] = root.val + left[1] + right[1];
            // exclusive sum at any node is the sum of the max of inc/excl of each of its 2 child nodes.
            current[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

            return current;
        }
    }
}
