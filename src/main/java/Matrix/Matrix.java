package Matrix;


import java.util.*;

public class Matrix {

  public int maximumWealth(int[][] accounts) {

    int max = Integer.MIN_VALUE;

    for (int[] customer : accounts) {
      int wealth = 0;
      for (int bankAccount : customer) {
        wealth += bankAccount;
      }
      max = Math.max(wealth, max);
    }
    return max;

  }

  public int[][] flipAndInvertImage(int[][] image) {

    for (int[] row : image) {

      for (int i = 0; i < row.length / 2; i++) {
        int temp = row[i];
        row[i] = row[row.length - 1 - i];
        row[row.length - 1 - i] = temp;
      }
      for (int i = 0; i < row.length; i++) {
        row[i] = row[i] == 0 ? 1 : 0;
      }
    }
    return image;

  }

  public int diagonalSum(int[][] mat) {

    int sum = 0;

    for (int i = 0; i < mat.length; i++) {
      sum += mat[i][i];
    }
    for (int i = 0; i < mat.length; i++) {
      if ((mat.length - 1 - i) != i) {
        sum = sum + mat[mat.length - 1 - i][i];
      }
    }

    return sum;
  }

  public boolean searchMatrix(int[][] matrix, int target) {

    int row = 0;
    int col = matrix[0].length - 1;


    while (row <= matrix.length - 1 && col >= 0) {

      if (target == matrix[row][col]) {
        return true;
      } else if (target > matrix[row][col]) {
        row++;
      } else {
        col--;
      }
    }
    return false;
  }

  public int[] kWeakestRows(int[][] mat, int k) {
    class Pair {
      int index;
      int value;

      public Pair(int index, int value) {
        this.index = index;
        this.value = value;
      }

    }

    List<Pair> list = new ArrayList<>();

    for (int i = 0; i < mat.length; i++) {

      int numOfSol = 0;
      for (int col : mat[i]) {
        if (col == 1) {
          numOfSol++;
        }
      }
      list.add(new Pair(i, numOfSol));
    }

    Collections.sort(list, new Comparator<Pair>() {
      @Override
      public int compare(Pair o1, Pair o2) {

        if (o1.value == o2.value) {
          return o1.index - o2.index;
        } else return (o1.value - o2.value);

      }
    });
    int[] kWeakest = new int[k];
    int c = 0;

    for (Pair pair : list) {
      kWeakest[c++] = pair.index;
      if (c >= kWeakest.length) break;
    }
    return kWeakest;


  }

  public int numSplits(String s) {
    int n = s.length();
    int[] prefix = new int[n];
    int[] suffix = new int[n];
    Set<Character> pSet = new HashSet<>();
    Set<Character> qSet = new HashSet<>();

    for (int i = 0; i < n; i++) {
      pSet.add(s.charAt(i));
      qSet.add(s.charAt(n - 1 - i));
      prefix[i] = pSet.size();
      suffix[n - 1 - i] = qSet.size();
    }

    int cnt = 0;
    for (int i = 1; i < n; i++) {
      if (prefix[i - 1] == suffix[i]) {
        cnt++;
      }
    }
    return cnt;

  }
}
