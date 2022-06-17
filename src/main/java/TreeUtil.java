import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class TreeUtil {

  /**
   * Level order traversal of nodes using queue.
   *
   * @param root of the Tree
   */
  public static void levelOrderTraversal(TreeNodeString root) {

    Queue<TreeNodeString> queue = new ArrayDeque<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNodeString currNode = queue.poll();

      System.out.print(currNode.val + " ");
      if (currNode.left != null) {
        queue.add(currNode.left);
      }
      if (currNode.right != null) {
        queue.add(currNode.right);
      }
    }

  }

  public static int DepthOfNode(TreeNodeString root) {
    if (root == null) return 0;
    return Math.max(DepthOfNode(root.left), DepthOfNode(root.right)) + 1;
  }

  public static void preOrder(TreeNodeString root) {
    if (root == null) return;

    System.out.print(root.val + " ");
    preOrder(root.left);
    preOrder(root.right);
  }

  public static void inOrder(TreeNodeString root) {
    if (root == null) return;

    inOrder(root.left);
    System.out.print(root.val + " ");
    inOrder(root.right);
  }

  public static void postOrder(TreeNodeString root) {
    if (root == null) return;

    postOrder(root.left);
    postOrder(root.right);
    System.out.print(root.val + " ");

  }

  public static void preOrderUsingStack(TreeNodeString root) {
    if (null == root) return;
    Stack<TreeNodeString> stack = new Stack<>();
    stack.add(root);
    while (!stack.isEmpty()) {
      TreeNodeString curr = stack.pop();
      System.out.print(curr.val + " ");

      if (null != curr.right) {
        stack.add(curr.right);
      }
      if (null != curr.left) {
        stack.add(curr.left);
      }

    }
  }

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

    if (list1 == null && list2 == null) return null;
    if (list1 == null) return list2;
    if (list2 == null) return list1;
    ListNode dummyNode = new ListNode();
    ListNode head = dummyNode;

    while (list1 != null && list2 != null) {
      ListNode node = new ListNode();
      if (list1.val < list2.val) {
        node.val = list1.val;
        list1=list1.next;
      } else {
        node.val = list2.val;
        list2=list2.next;
      }
      dummyNode.next=node;
      dummyNode=dummyNode.next;
    }
    if (list1!=null){
      dummyNode.next=list1;
    }
    if (list2!=null){
      dummyNode.next=list2;
    }
    return head.next;
  }
}
