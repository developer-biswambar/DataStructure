package StackQuestions;

import java.util.*;
import java.util.stream.Collectors;

public class StackQuestions {

  public int minOperations(String[] logs) {
    int res = 0;

    for (String log : logs) {

      if (Objects.equals(log, "../")) {
        res--;
        res = Math.max(res, 0);
      } else if (Objects.equals(log, "./")) {
        continue;
      } else {
        res++;
      }
    }
    return res;

  }

  public boolean isPalindrome(ListNode head) {

    Stack<Integer> stack = new Stack<>();

    ListNode temp = head;
    while (temp != null) {
      stack.push(temp.val);
      temp = temp.next;
    }

    while (head != null) {
      if (head.val != stack.pop()) {
        return false;
      }
      head = head.next;
    }
    return true;

  }

}
