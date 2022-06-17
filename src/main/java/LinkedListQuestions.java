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


  /*public static long getTotalEfficiency(List<Integer> skill) {
    // Write your code here
    Collections.sort(skill);

    for (int )

  }*/
}
