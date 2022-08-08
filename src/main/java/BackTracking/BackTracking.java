package BackTracking;

import java.util.*;

public class BackTracking {
  /**
   * https://leetcode.com/problems/subsets/
   * 78. Subsets
   * Given an integer array nums of unique elements, return all possible subsets (the power set).
   * <p>
   * The solution set must not contain duplicate subsets. Return the solution in any order.
   */

  private List<List<Integer>> result;
  private HashSet<List<Integer>> hashSet = new HashSet<>();

  public List<List<Integer>> subsets(int[] nums) {
    result = new ArrayList();
    if (nums == null || nums.length == 0) return result;

    subsets(nums, new ArrayList<Integer>(), 0);
    return result;
  }

  private void subsets(int[] nums, ArrayList<Integer> temp, int index) {
    // base condition
    if (index >= nums.length) {
      result.add(new ArrayList<>(temp));
      hashSet.add(new ArrayList<>(temp));
      return;
    }


    // main logic
    // case 1 : we pick the element
    temp.add(nums[index]);
    subsets(nums, temp, index + 1); // move ahead
    temp.remove(temp.size() - 1);

    // case 2 : we don't pick the element ( notice, we did not add the current element in our temporary list
    subsets(nums, temp, index + 1); // move ahead
  }


  public String decodeString(String s) {
    String res = "";
    Stack<Integer> numberStack = new Stack<>();
    Stack<String> resStack = new Stack<>();
    int i = 0;
    while (i < s.length()) {


      if (Character.isDigit(s.charAt(i))) {
        int number = 0;

        while (Character.isDigit(s.charAt(i))) {
          number = number * 10 + (s.charAt(i) - '0');
          i++;
        }
        numberStack.push(number);
      } else if (s.charAt(i) == '[') {
        resStack.push(res);
        i++;
      } else if (s.charAt(i) == ']') {
        StringBuilder temp = new StringBuilder(resStack.pop());

        int repeatTimes = numberStack.pop();

        for (int j = 0; j < repeatTimes; j++) {
          temp.append(res);
        }
        res = temp.toString();
        i++;
      } else {
        res = res + s.charAt(i);
        i++;
      }
    }

    return res;
  }

  public static List<Integer> findMostProfitableMonth(List<Integer> stockPrice) {
    //6 8 9 7 6 8 7 9 9 8
    if (stockPrice.size() < 1 || stockPrice == null) {
      return new ArrayList<>(Arrays.asList(-1));
    }

    List<Integer> mostProfitableMonth = new ArrayList<>();


    int min = Integer.MAX_VALUE;

    for (int i = 0; i < stockPrice.size(); i++) {

      if (stockPrice.get(i) < min) {
        min = stockPrice.get(i);
      }
      int mP = -1;
      for (int j = stockPrice.size() - 1; j > i; j--) {
        if (stockPrice.get(j) > min) {
          mP = j;
        } else {
          break;
        }
      }
      mostProfitableMonth.add(mP);

    }
    return mostProfitableMonth;

  }


  public void printAllBinary(int digits) {
    if (digits == 0) {
      return;
    }
    printAllBinaryHelper(digits, "");
  }

  private void printAllBinaryHelper(int digits, String output) {

    if (digits <= 0) {
      System.out.println(output);
      return;
    }
    printAllBinaryHelper(digits - 1, "1" + output);
    printAllBinaryHelper(digits - 1, output + "0");

  }

  public void diceSum(int numberOfRolls, int desiredSum) {
    diceSumHelper(numberOfRolls, desiredSum, new ArrayList<>());
  }

  public static int calls = 0;

  private void diceSumHelper(int numberOfRolls, int desiredSum, ArrayList<Integer> chosenDices) {
    calls++;
    if (numberOfRolls == 0) {
      if (desiredSum == 0) {
        System.out.println(chosenDices);
      }

    } else if (desiredSum >= numberOfRolls && desiredSum <= desiredSum * 6) {
      for (int i = 1; i <= 6; i++) {
        chosenDices.add(i);
        diceSumHelper(numberOfRolls - 1, desiredSum - i, chosenDices);

        chosenDices.remove(chosenDices.size() - 1);

      }
    }


  }


  public void permutationOfWords(List<Character> characterList) {
    //permutationOfWordsHelper(characterList, new ArrayList<>());

    subListOfWordsHelper(characterList, new ArrayList<>());

  }

  private void permutationOfWordsHelper(List<Character> characterList, List<Character> choosen) {
    calls++;
    if (characterList.isEmpty()) {
      System.out.println(choosen.toString());

      return;
    }

    for (int i = 0; i < characterList.size(); i++) {

      char c = characterList.get(i);
      choosen.add(c);
      characterList.remove(i);
      permutationOfWordsHelper(characterList, choosen);

      choosen.remove(choosen.size() - 1);
      characterList.add(i, c);
    }

  }

  public void subListOfWordsHelper(List<Character> characterList, List<Character> chosen) {
    calls++;
    if (characterList.isEmpty()) {
      System.out.println(chosen);
      return;
    }
// Recursive case for each possible choice
    char c = characterList.remove(0);

    // choose/explore without c

    subListOfWordsHelper(characterList, chosen);

    chosen.add(c);

    // choose/explore with c
    subListOfWordsHelper(characterList, chosen);


    // un-choose
    characterList.add(0, c);
    chosen.remove(chosen.size() - 1);

  }

  /**
   * Write a function which returns every possible sub-list of a given ArrayList of Strings
   */

  public void subListOfDict(List<String> list) {

    subListOfDictHelper(list, new ArrayList<>());
  }

  private void subListOfDictHelper(List<String> list, List<String> chosen) {
    calls++;
    if (list.isEmpty()) {
      System.out.println(chosen);
      return;
    }
    // chose a name
    String s = list.remove(0);
    //chose/explore without s
    subListOfDictHelper(list, chosen);

    // choose/explore with s
    chosen.add(s);
    subListOfDictHelper(list, chosen);

    // un-choose
    chosen.remove(chosen.size() - 1);
    list.add(0, s);
  }


  private List<String> res = new ArrayList<>();

  public List<String> letterCasePermutation(String s) {

    letterCasePermutationHelper(s.toCharArray(), 0);
    System.out.println(res);
    return res;

  }

  private void letterCasePermutationHelper(char[] chars, int index) {
    calls++;

    if (index == chars.length) {
      res.add(new String(chars));
      return;
    }

    if (Character.isLetter(chars[index])) {

      chars[index] = Character.toUpperCase(chars[index]);
      letterCasePermutationHelper(chars, index + 1);
      chars[index] = Character.toLowerCase(chars[index]);
    }

    letterCasePermutationHelper(chars, index + 1);
  }


}