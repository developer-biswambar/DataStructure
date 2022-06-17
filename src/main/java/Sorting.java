public class Sorting {


  public static int[] selectionSort(int[] nums) {

    for (int i = 0; i < nums.length; i++) {

      int minIndex = i;
      boolean smallerNumberFound = false;

      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] < nums[minIndex]) {
          minIndex = j;
          smallerNumberFound = true;
        }
      }
      if (smallerNumberFound) {
        int temp = nums[minIndex];
        nums[minIndex] = nums[i];
        nums[i] = temp;
      }

    }
    return nums;
  }

  public static int[] insertionSort(int[] nums) {
    if (nums.length < 2) return nums;

    int sortedPartitionIndex = 1;

    while (sortedPartitionIndex < nums.length) {

      int value = nums[sortedPartitionIndex];
      int position = sortedPartitionIndex;

      while (position > 0 && nums[position - 1] > value) {
        nums[position] = nums[position - 1];
        position--;
      }
      nums[position] = value;
      sortedPartitionIndex++;
    }
    return nums;
  }

  public static int[] bubbleSort(int[] nums) {
    if (nums.length < 2) return nums;

    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {

        if (nums[i] > nums[j]) {
          int temp = nums[i];
          nums[i] = nums[j];
          nums[j] = temp;
        }
      }
    }
    return nums;
  }
}
