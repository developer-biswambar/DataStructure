package StudyPlan75;

import java.util.Arrays;
import java.util.HashSet;

public class Problems {

  /**
   * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
   * You are given an array prices where prices[i] is the price of a given stock on the ith day.
   * <p>
   * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
   * <p>
   * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
   */
  public int maxProfit(int[] prices) {
    int maxProfit = 0;
    int buyPrice = prices[0];

    for (int i = 1; i < prices.length; i++) {
      if (buyPrice < prices[i]) {
        maxProfit = Math.max(prices[i] - buyPrice, maxProfit);
      } else {
        buyPrice = prices[i];
      }
    }
    return maxProfit;
  }

  /**
   * Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
   * <p>
   * Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
   */
  public int longestPalindrome(String s) {

    HashSet<Character> set = new HashSet<>();

    for (Character character : s.toCharArray()) {
      if (set.contains(character)) {
        set.remove(character);
      } else {
        set.add(character);
      }
    }
    int oddCharsLeft = set.size();

    return s.length() - (oddCharsLeft == 0 ? 0 : oddCharsLeft - 1);


  }
}
