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

  public static int[] mergeSort(int[] nums) {
    int n = nums.length;
    if (n < 2) return nums;

    int mid = n / 2;

    int[] left = new int[mid];
    int[] right = new int[n - mid];

    for (int i = 0; i < left.length; i++) {
      left[i] = nums[i];
    }
    for (int i = mid; i < n; i++) {
      right[i - mid] = nums[i];
    }

    mergeSort(left);
    mergeSort(right);

    merge(left, right, nums);
    return nums;

  }

  private static void merge(int[] left, int[] right, int[] nums) {

    int nl = left.length;
    int nr = right.length;
    int i = 0, j = 0, k = 0;

    while (i < nl && j < nr) {
      if (left[i] < right[j]) {
        nums[k++] = left[i++];
      } else {
        nums[k++] = right[j++];
      }
    }

    while (i < nl) {
      nums[k++] = left[i++];
    }
    while (j < nr) {
      nums[k++] = right[j++];
    }

  }

  public static int[] quickSort(int[] nums, int start, int end) {
    if (start >= end) return nums;

    int pIndex = partition(nums, start, end);

    quickSort(nums, start, pIndex - 1);
    quickSort(nums, pIndex + 1, end);
    return nums;
  }

  private static int partition(int[] nums, int start, int end) {
    int pivot = nums[end];
    int partitionIndex = start;

    for (int i = start; i < end; i++) {
      if (nums[i] <= pivot) {
        int temp = nums[partitionIndex];
        nums[partitionIndex] = nums[i];
        nums[i] = temp;
        partitionIndex++;
      }

    }
    int temp = nums[partitionIndex];
    nums[partitionIndex] = nums[end];
    nums[end] = temp;
    return partitionIndex;
  }
}
