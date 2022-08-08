package Design.BST;

import java.util.*;

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

  /**
   * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
   * Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in
   * the BST such that their sum is equal to the given target.
   */

//Get time complexity of the solution: O(n)
  public boolean findTarget(TreeNode root, int k) {

    Set<Integer> set = new HashSet<>();

    return inorderTraversal(root, k, set);
  }

  private boolean inorderTraversal(TreeNode root, int k, Set<Integer> set) {

    if (root == null) return false;

    if (set.contains(k - root.val)) return true;

    set.add(root.val);

    return inorderTraversal(root.left, k, set) || inorderTraversal(root.right, k, set);

  }

  /**
   * https://leetcode.com/problems/minimum-absolute-difference-in-bst/
   * 530. Minimum Absolute Difference in BST
   * Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any
   * two different nodes in the tree.
   */

  private Integer min = Integer.MAX_VALUE;
  private Integer prev = null;

  public int getMinimumDifference(TreeNode root) {

    if (root == null) return min;

    getMinimumDifference(root.left);

    if (prev != null) {
      min = Math.min(min, root.val - prev);
    }
    prev = root.val;

    getMinimumDifference(root.right);

    return min;

  }

  /**
   * https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
   * 1038. Binary Search Tree to Greater Sum Tree
   * Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such
   * that every key of the original BST is changed to the original key plus the sum of all keys greater
   * than the original key in BST.
   * <p>
   * As a reminder, a binary search tree is a tree that satisfies these constraints:
   * <p>
   * The left subtree of a node contains only nodes with keys less than the node's key.
   * The right subtree of a node contains only nodes with keys greater than the node's key.
   * Both the left and right subtrees must also be binary search trees.
   */

  private int increSum = 0;

  public TreeNode bstToGst(TreeNode root) {

    if (root.right != null) {
      bstToGst(root.right);
    }

    root.val = increSum + root.val;
    increSum = root.val;

    if (root.left != null) {
      bstToGst(root.left);
    }
    return root;
  }

  /**
   * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
   * 1008. Construct Binary Search Tree from Preorder Traversal
   * Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree),
   * construct the tree and return its root.
   * <p>
   * It is guaranteed that there is always possible to find a binary search tree with the given requirements for the given test cases.
   * <p>
   * A binary search tree is a binary tree where for every node, any descendant of Node.left has a value strictly less
   * than Node.val, and any descendant of Node.right has a value strictly greater than Node.val.
   * <p>
   * A preorder traversal of a binary tree displays the value of the node first, then traverses Node.left, then traverses Node.right.
   */

  private int nodeCounter = 0;

  public TreeNode bstFromPreorder(int[] preorder) {
    return bstFromPreorderHelper(preorder, Integer.MAX_VALUE);
  }

  private TreeNode bstFromPreorderHelper(int[] A, int bound) {
    if (nodeCounter == A.length || A[nodeCounter] > bound) return null;

    TreeNode root = new TreeNode(A[nodeCounter++]);

    root.left = bstFromPreorderHelper(A, root.val);
    root.right = bstFromPreorderHelper(A, bound);

    return root;

  }

  /**
   * https://leetcode.com/problems/binary-tree-right-side-view/
   * 199. Binary Tree Right Side View
   * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes
   * you can see ordered from top to bottom.
   */
  private List<Integer> rightSideView = new ArrayList<>();

  public List<Integer> rightSideView(TreeNode root) {
    if (root == null) return null;
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);

    while (!queue.isEmpty()) {

      int size = queue.size();

      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        if (i == size - 1) {
          rightSideView.add(node.val);

        }

        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }
    }
    return rightSideView;
  }

  /**
   * https://leetcode.com/problems/balance-a-binary-search-tree/
   * 1382. Balance a Binary Search Tree
   * Given the root of a binary search tree, return a balanced binary search tree with the same node values.
   * If there is more than one answer, return any of them.
   * <p>
   * A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.
   */
  private List<TreeNode> sortedArray = new ArrayList<>();

  public TreeNode balanceBST(TreeNode root) {

    if (root == null) return null;

    inOrder(root);

    return createBSTFromSortedArray(0, sortedArray.size() - 1);


  }

  private void inOrder(TreeNode root) {

    if (root == null) return;

    inOrder(root.left);

    sortedArray.add(root);

    inOrder(root.right);

  }

  private TreeNode createBSTFromSortedArray(int start, int end) {
    if (start > end) return null;

    int mid = (start + end) / 2;

    TreeNode node = sortedArray.get(mid);

    node.left = createBSTFromSortedArray(0, mid - 1);
    node.right = createBSTFromSortedArray(mid + 1, end);

    return node;


  }

}
