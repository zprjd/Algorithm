package BinaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 * preOrder是自己，左右
 * inOrder是左 自己 右
 * postOrder 是 左右 自己
 */
public class BinaryTreePreorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = null;
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(3);
        List<Integer> list = new ArrayList<>();
        //list = preorderTraversalRecursion(root, list);
        list = preOrderTraversalIterative(root, list);
        for (Integer integer:
                list
             ) {
            System.out.println(integer);
        }
    }

    public static List<Integer> preorderTraversalRecursion(TreeNode root, List<Integer> list) {
        preOrder(root, list);
        return list;
    }

    /**
     * inOrder和postOrder只是换了位置，不赘述了
     * @param root
     * @param list
     */
    public static void preOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);  //肯定不能一直递归自己，应该先加自己，再遍历左右的。
        preOrder(root.left, list);
        preOrder(root.right, list);
//        if (root == null) {
//            return ;
//        } else {
//            list.add(root.val);
//        }
//        traversal(root, list);
//        traversal(root.left, list);
//        traversal(root.right, list);
    }

    //先入栈右边，先取得才能是左边
    public static List<Integer> preOrderTraversalIterative(TreeNode root, List<Integer> ans) {
        if (root == null) { //健壮性要考虑啊
            return ans;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return ans;
    }

    public static class TreeNode {
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
}