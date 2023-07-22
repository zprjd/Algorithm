package BinaryTree;

/**
 * 669. Trim a Binary Search Tree
 * Given the root of a binary search tree and the lowest and highest boundaries as low and
 * high, trim the tree so that all its elements lies in [low, high]. Trimming the tree
 * should not change the relative structure of the elements that will remain in the
 * tree (i.e., any node's descendant should remain a descendant). It can be proven
 * that there is a unique answer.
 *
 * Return the root of the trimmed binary search tree. Note that the root may change
 * depending on the given bounds.
 *  
 *
 * Example 1:
 *
 *
 * Input: root = [1,0,2], low = 1, high = 2
 * Output: [1,null,2]
 * Example 2:
 *
 *
 * Input: root = [3,0,4,null,2,null,null,1], low = 1, high = 3
 * Output: [3,2,null,1]
 *  
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * 0 <= Node.val <= 104
 * The value of each node in the tree is unique.
 * root is guaranteed to be a valid binary search tree.
 * 0 <= low <= high <= 104
 */
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

 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

//class Solution {
//    public static TreeNode trimBST(TreeNode root, int low, int high) {
//        if (root == null)   return null;
//        if (root.val < low) {//把不符合范围要求的节点干掉，怎么干掉呢，跳过返回他，遍历返回他的孩子就干掉了
//            return trimBST(root.right, low, high);//搜索树的特性
//        }
//        if(root.val > high) {
//            return trimBST(root.left, low, high);
//        }
//        root.left = trimBST(root.left, low, high);
//        root.right = trimBST(root.right, low, high);
//        return root; //root底下可能有不符合的，怎么做这一个判断？
//        //判断都是由函数去做的，也就是说再次调用这个函数，将返回值赋值给节点的子节点就好了
//    }
//
//    public static void main(String[] args) {
//        TreeNode left = new TreeNode(0);
//        TreeNode right = new TreeNode(2);
//        TreeNode root = new TreeNode(1, left, right);
//        trimBST(root,1, 2);
//        printVal(root);
//        printVal(root.left);
//        printVal(root.right);
//    }
//
//    private static void printVal(TreeNode node) {
//        if (node == null) {
//            System.out.println("null");
//        } else {
//            System.out.println(node.val);
//        }
//    }
//}
