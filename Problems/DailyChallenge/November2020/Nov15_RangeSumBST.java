package DailyChallenge.November2020;

public class Nov15_RangeSumBST
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
    
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        if(root == null) {
            return sum;
        }

        int val = root.val;
        if (val >= low && val <= high) {
            sum += val;
            sum += rangeSumBST(root.left, low, high);
            sum += rangeSumBST(root.right, low, high);
        } else if (val < low) {
            sum += rangeSumBST(root.right, low, high);
        } else {
            sum += rangeSumBST(root.left, low, high);
        }

        return sum;
    }
}
