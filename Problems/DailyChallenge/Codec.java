package DailyChallenge;

import java.util.ArrayList;
import java.util.List;

public class Codec {

      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    
    private static List<Integer> order = new ArrayList<>();
    // Encodes a tree to a single string.

    public String serialize(TreeNode root) {
        preOrder(root);

        String listString = order.toString();

        return listString.substring(1, listString.length()-1);
    }

    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        else {
            order.add(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(", ");

        if (arr.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));

        for(int i = 1; i < arr.length; i++) {
            insert(root, Integer.parseInt(arr[i]));
        }

        return root;
    }

    private void insert(TreeNode root, int num) {
        if (num < root.val) {
            if (root.left == null) {
                TreeNode left = new TreeNode(num);
                root.left = left;
                return;
            }
            else {
                insert(root.left, num);
                return;
            }
        }
        else {
            if (root.right == null) {
                TreeNode right = new TreeNode(num);
                root.right = right;
                return;
            }
            else {
                insert(root.right, num);
                return;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode right = new TreeNode(5);
        right.left = new TreeNode(4);
        right.right = new TreeNode(7);
        root.right = right;

        Codec codec = new Codec();
        String ser = codec.serialize(root);

        System.out.println(ser);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;