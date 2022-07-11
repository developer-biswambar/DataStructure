package BST;

import java.util.ArrayList;
import java.util.List;

public class BSTQuestions {

  /**
   * https://leetcode.com/problems/validate-binary-search-tree/
   * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
   */

  public boolean isValidBST(TreeNode root) {

    return isValidBstHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);

  }

  private boolean isValidBstHelper(TreeNode root, long minValue, long maxValue) {

    if (root == null) return true;

    if (root.val >= maxValue || root.val <= minValue) return false;

    return isValidBstHelper(root.left, minValue, root.val) && isValidBstHelper(root.right, root.val, maxValue);
  }

  /**
   * Lowest Common Ancestor of a Binary Search Tree
   * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
   * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
   * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q
   * as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
   */

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) return null;

    if (root.val > p.val && root.val > q.val) {
      return lowestCommonAncestor(root.left, p, q);
    } else if (root.val < p.val && root.val < q.val) {
      return lowestCommonAncestor(root.right, p, q);
    } else
      return root;
  }

  private final List<Integer> inorderNodeList = new ArrayList<>();

  public TreeNode increasingBST(TreeNode root) {

    inorder(root);
    TreeNode temp = new TreeNode(-1);
    TreeNode head = temp;

    for (Integer integer : inorderNodeList) {
      temp.right = new TreeNode(integer);
      temp = temp.right;

    }
    return head.right;

  }

  private void inorder(TreeNode root) {
    if (root == null) return;

    inorder(root.left);
    inorderNodeList.add(root.val);
    inorder(root.right);
  }

  public TreeNode searchBST(TreeNode root, int val) {

    if (root == null || root.val == val) return root;

    return root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);

  }


}
