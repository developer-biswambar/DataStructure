import BST.BSTQuestions;
import BST.TreeNode;
import Design.LRUCache;
import Design.Logger;
import Design.MinStack;
import Design.StringIterator;
import DynamicProg.DP;
import StudyPlan75.Problems;

public class MainClass {
  public static void main(String[] args) {

   /* TreeNode root = new TreeNode("F");
    root.left = new TreeNode("D");
    root.right = new TreeNode("J");

    root.left.left = new TreeNode("B");
    root.left.right = new TreeNode("E");

    root.left.left.left = new TreeNode("A");
    root.left.left.right = new TreeNode("C");

    root.right.right = new TreeNode("K");
    root.right.left = new TreeNode("G");

    root.right.left.right = new TreeNode("I");
    root.right.left.right.left = new TreeNode("H");*/
    TreeNode node = new TreeNode(4);
    node.left = new TreeNode(2);
    node.right = new TreeNode(7);
    node.left.left = new TreeNode(1);
    node.left.right = new TreeNode(3);


    BSTQuestions bstQuestions = new BSTQuestions();
    bstQuestions.searchBST(node, 2);


  }
}
