package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ArraysPractice {

  public int[] countPoints(int[][] points, int[][] queries) {
    int[] ans = new int[queries.length];
    int i = 0;
    for (int[] query : queries) {
      int counter = 0;

      for (int[] point : points) {
        if (query[2] >= distance(query[0], query[1], point[0], point[1])) {
          counter++;
        }
      }
      ans[i++] = counter;
    }
    return ans;

  }

  /**
   * @param x1 x co-ordinate of point 1
   * @param y1 y co-ordinate of point 1
   * @param x2 x co-ordinate of point 2
   * @param y2 y co-ordinate of point 2
   * @return the distance between (x1,y1) and (x2,y2)
   */

  private double distance(int x1, int y1, int x2, int y2) {

    return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));

  }


  public int[] pivotArray(int[] nums, int pivot) {
    /**
     * Input: nums = [9,12,5,10,14,3,10], pivot = 10
     * Output: [9,5,3,10,10,12,14]
     * left= 9,5,3
     * equals= 10,10
     * right=12,14
     */
    List<Integer> left = new ArrayList<>();
    List<Integer> right = new ArrayList<>();
    List<Integer> same = new ArrayList<>();

    for (int num : nums) {
      if (num == pivot) {
        same.add(num);
      } else if (num > pivot) {
        right.add(num);
      } else {
        left.add(num);
      }
    }
    for (int i = 0; i < nums.length; i++) {
      if (i < left.size()) {
        nums[i] = left.get(i);
      } else if (i < same.size() + left.size()) {
        nums[i] = same.get(i - left.size());
      } else {
        nums[i] = right.get(i - left.size() - same.size());
      }

    }

    return nums;

  }

  private int minimumSum = Integer.MAX_VALUE;

  public int minimumDifference(int[] nums) {
    /**
     * Input: nums = [3,9,7,3]
     * Output: 2
     */
    int totalSum = 0;
    for (int num : nums) {
      totalSum += num;
    }
    minimumDifferenceHelper(nums, 0, 0, totalSum, 0);

    return minimumSum;

  }

  private void minimumDifferenceHelper(int[] nums, int index, int leftSum, int totalSum, int setCounter) {
    if (setCounter == nums.length / 2) {
      minimumSum = Math.min(leftSum, (totalSum - leftSum));
      return;
    }
    if (index == nums.length / 2) {
      return;
    }


    //add num to left list
    int sumToBeAdded = nums[index];
    leftSum = leftSum + sumToBeAdded;

    minimumDifferenceHelper(nums, index+1, leftSum, totalSum, setCounter+1);
    leftSum = leftSum - sumToBeAdded;
    minimumDifferenceHelper(nums, index+1, leftSum, totalSum, setCounter+1);


  }
}
