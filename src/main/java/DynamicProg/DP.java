package DynamicProg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DP {

  /**
   * Fibonacci using DP
   *
   * @param n
   * @return
   */

  public static HashMap<Integer, Integer> memory = new HashMap<>();

  public static int fibonacci(int n) {

    if (n == 0 || n == 1) return 1;

    if (!memory.containsKey(n)) {
      memory.put(n, (fibonacci(n - 1) + fibonacci(n - 2)));
    }
    return memory.get(n);

  }

  /**
   * Given an integer numRows, return the first numRows of Pascal's triangle.
   * <p>
   * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
   */


  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> allRows = new ArrayList<List<Integer>>();
    ArrayList<Integer> row = new ArrayList<Integer>();
    for (int i = 0; i < numRows; i++) {
      row.add(0, 1);
      for (int j = 1; j < row.size() - 1; j++)
        row.set(j, row.get(j) + row.get(j + 1));
      allRows.add(new ArrayList<Integer>(row));
    }
    return allRows;

  }


}
