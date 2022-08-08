package SlidingWindow;

import java.util.*;
import java.util.stream.Collectors;

public class SlidingWindow {

  /**
   * <a href="https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/">...</a>
   * 1876. Substrings of Size Three with Distinct Characters
   * A string is good if there are no repeated characters.
   * <p>
   * Given a string s, return the number of good substrings of length three in s.
   * <p>
   * Note that if there are multiple occurrences of the same substring, every occurrence should be counted.
   * <p>
   * A substring is a contiguous sequence of characters in a string.
   */
  public int countGoodSubstrings(String s) {
    if (s.isBlank() || s.length() < 3) return 0;

    char a = s.charAt(0), b = s.charAt(1), c = s.charAt(2);
    int res = 0;

    for (int i = 3; i < s.length(); i++) {

      if (a != b && b != c && c != a) {
        res++;
      }
      a = b;
      b = c;
      c = s.charAt(i);
    }
    if (a != b && b != c && c != a) {
      res++;
    }
    return res;

  }

  /**
   * https://leetcode.com/problems/longest-nice-substring/
   * 1763. Longest Nice Substring
   * A string s is nice if, for every letter of the alphabet that s contains, it appears both in uppercase and lowercase.
   * For example, "abABB" is nice because 'A' and 'a' appear, and 'B' and 'b' appear. However,
   * "abA" is not because 'b' appears, but 'B' does not.
   * <p>
   * Given a string s, return the longest substring of s that is nice. If there are multiple, return the substring
   * of the earliest occurrence. If there are none, return an empty string.
   */

  public String longestNiceSubstring(String s) {


    Set<Character> charSet = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      charSet.add(s.charAt(i));
    }

    for (int i = 0; i < s.length(); i++) {

      if (charSet.contains(Character.toUpperCase(s.charAt(i))) &&
          charSet.contains(Character.toLowerCase(s.charAt(i)))) {
        continue;
      }

      String s1 = longestNiceSubstring(s.substring(0, i));
      String s2 = longestNiceSubstring(s.substring(i));

      return s1.length() > s2.length() ? s1 : s2;
    }
    return s;
  }

  /**
   * https://leetcode.com/problems/find-the-k-beauty-of-a-number/
   * 2269. Find the K-Beauty of a Number
   * The k-beauty of an integer num is defined as the number of substrings of num when it is read as a string that
   * meet the following conditions:
   * <p>
   * It has a length of k.
   * It is a divisor of num.
   * Given integers num and k, return the k-beauty of num.
   * <p>
   * Note:
   * <p>
   * Leading zeros are allowed.
   * 0 is not a divisor of any value.
   * A substring is a contiguous sequence of characters in a string.
   */

  public int divisorSubstrings(int num, int k) {

    if (Integer.toString(num).length() < k) return 0;
    int res = 0;

    String number = Integer.toString(num);

    int i = 0, j = k;

    while (j < number.length()) {

      int currNum = Integer.parseInt(number.substring(i, j));

      if (currNum != 0 && num % currNum == 0) {
        res++;
      }
      i++;
      j++;
    }
    if (num % Integer.parseInt(number.substring(i, j)) == 0) {
      res++;
    }
    return res;

  }

  public int myAtoi(String s) {

    if (s.isBlank()) return 0;

    int index = 0, res = 0;
    boolean isNegative = false;

    while (index < s.length() && s.charAt(index) == ' ') {
      index++;
    }

    if (Character.isAlphabetic(s.charAt(index))) {
      return 0;
    }

    if (s.charAt(index) == '-') {
      isNegative = true;
      index++;
    } else if (s.charAt(index) == '+') {
      index++;
    }
    while (index < s.length() && Character.isDigit(s.charAt(index))) {
      int digit = Character.getNumericValue(s.charAt(index));

      if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && digit > 7)) {
        return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
      }

      res = res * 10 + digit;
      index++;

    }
    return isNegative ? -res : res;

  }

  private Map<Character, Character> bracketMap = new HashMap<>();

  public boolean isValid(String s) {
    ;
    Stack<Character> stack = new Stack<>();

    for (Character c : s.toCharArray()) {
      if (c == '(') {
        stack.push(')');
      } else if (c == '{') {
        stack.push('}');
      } else if (c == '[') {
        stack.push(']');
      } else if (stack.isEmpty() || stack.pop() != c) {
        return false;
      }
    }
    return stack.isEmpty();
  }

  public int longestValidParentheses(String s) {
    int max = Integer.MIN_VALUE;
    int size=0;
    Stack<Character> stack = new Stack<>();

    for (char c : s.toCharArray()) {

      if (c == '(') {
        stack.push(')');
        size++;
      } else if (stack.isEmpty() || stack.pop() != c) {
        max = Math.max(max, size* 2);
        stack.clear();

      }

    }
    return max;
  }


}
