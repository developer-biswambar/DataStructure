import StackQuestions.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LinkedListQuestions {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    if (l1 == null && l2 == null) return null;
    if (l1 == null) return l2;
    if (l2 == null) return l1;

    int carry = 0;
    int sum = 0;
    ListNode currNode = new ListNode(-1);
    ListNode head = currNode;
    while (l1 != null || l2 != null) {

      int firstNumDigit = l1 != null ? l1.val : 0;
      int secondNumDigit = l2 != null ? l2.val : 0;

      sum = (firstNumDigit + secondNumDigit + carry) % 10;
      carry = (firstNumDigit + secondNumDigit + carry) / 10;
      ListNode node = new ListNode(sum);
      currNode.next = node;
      currNode = currNode.next;


      if (l1 != null) {
        l1 = l1.next;
      }
      if (l2 != null) {
        l2 = l2.next;
      }

    }
    if (carry != 0) {
      ListNode node = new ListNode(sum);
      currNode.next = node;
    }
    return head.next;
  }

  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || head.next == null) return head;

    ListNode node = head;
    int counter = 0;
    ListNode start = node;
    while (node != null) {

      counter++;

      if (counter == k) {
        reverse(start, node);
        counter = 0;
        start = node.next;
      }
      node = node.next;

    }
    return head;

  }

  private void reverse(ListNode start, ListNode end) {

    ListNode node = start;

    List<Integer> list = new ArrayList<>();

    while (node != end) {
      list.add(node.val);
      node = node.next;
    }
    list.add(node.val);
    node = start;

    for (int i = list.size() - 1; i >= 0; i--) {
      node.val = list.get(i);
      node = node.next;
    }

  }
}
