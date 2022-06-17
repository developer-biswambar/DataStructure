import java.util.*;

import static java.lang.Math.max;

public class PracticeBasic {

  public static void merge(int[] nums1, int m, int[] nums2, int n) {

    int[] result = new int[m + n];
    int i = 0, j = 0, k = 0;

    while (i < m || j < n) {

      if (i < m && j < n) {

        if (nums1[i] < nums2[j]) {
          result[k] = nums1[i];
          i++;
        } else {
          result[k] = nums2[j];
          j++;
        }

      } else if (i < m) {
        result[k] = nums1[i];
        i++;
      } else if (j < n) {
        result[k] = nums2[j];
        j++;
      }
      k++;


    }
    System.arraycopy(result, 0, nums1, 0, k);
  }

  public static long getHeaviestPackage(List<Integer> packageWeights) {
    // Write your code here


    boolean sizeReduced = true;
    while (sizeReduced) {
      int listPrevSize = packageWeights.size();
      for (int i = 0; i < packageWeights.size() - 1; i++) {
        if (packageWeights.get(i) < packageWeights.get(i + 1)) {
          packageWeights.set(i, packageWeights.get(i) + packageWeights.get(i + 1));
          packageWeights.remove(i + 1);
        }
      }
      if (packageWeights.size() == listPrevSize) {
        sizeReduced = false;
      }

    }
    System.out.println(packageWeights.stream().max(Comparator.naturalOrder()).get());
    return packageWeights.stream().reduce(Integer::max).get();
  }

  public static int findMaxDeviation(String subString) {

    Map<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < subString.length(); i++) {
      if (map.containsKey(subString.charAt(i))) {
        int currFreq = map.get(subString.charAt(i));
        map.put(subString.charAt(i), currFreq + 1);
      } else {
        map.put(subString.charAt(i), 1);
      }
    }
    return Collections.max(map.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getValue()
        - Collections.min(map.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getValue();
  }

  public int getMaxFreqDeviation(String s) {
    int maxDeviation = 0;
    int n = s.length();
    for (int i = 0; i < n; i++) {
      if (n - i < maxDeviation)
        break; //this is new stop point to improve
      String sub1 = s.substring(i, n);
      String sub2 = s.substring(0, n - 1);
      int a = findMaxDeviation(sub1); // This is O(n)
      int b = findMaxDeviation(sub2); // This is O(n)
      maxDeviation = max(a, b);
    }
    return maxDeviation;
  }

  /*public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int compl = target - nums[i];
      if (map.containsKey(compl))
        return new int[]{map.get(compl), i};
      else {
        map.put(nums[i], i);
      }
    }
    return new int[]{-1, -1};
  }*/

  public static int lengthOfLongestSubstring(String s) {

    HashSet<Character> set = new LinkedHashSet<>();
    int maxSubStringLength = Integer.MIN_VALUE;

    for (int i = 0; i < s.length(); i++) {

      if (!set.contains(s.charAt(i))) {
        set.add(s.charAt(i));
      } else {
        maxSubStringLength = Math.max(set.size(), maxSubStringLength);
        set.remove(set.iterator().next());
        i = i - 1;
      }

    }
    return Math.max(set.size(), maxSubStringLength);
  }

  public int numUniqueEmails(String[] emails) {

    HashSet<String> set = new HashSet<>();

    for (String email : emails) {

      String[] result = email.split("@");

      String emailPart = result[0];
      String domain = result[1];

      emailPart = emailPart.replace(".", "");
      if (emailPart.contains("+")) {
        emailPart = emailPart.split("\\+")[0];
      }

      set.add(emailPart + "@" + domain);

    }
    return set.size();
  }

  public static String licenseKeyFormatting(String s, int k) {

    String sAfterRemovingDashes = s.replace("-", "").toUpperCase();
    int length = sAfterRemovingDashes.length();
    if (sAfterRemovingDashes.isBlank()) return "";
    int firstGroupLength = length % k == 0 ? k : length % k;

    StringBuilder sb = new StringBuilder();
    sb.append(sAfterRemovingDashes.substring(0, firstGroupLength));

    int start = firstGroupLength;
    int end = firstGroupLength + k;

    while (end <= length) {
      sb.append("-");
      sb.append(sAfterRemovingDashes.substring(start, end));
      start = end;
      end = end + k;
    }
    return sb.toString();

  }

  public static int totalFruit(int[] fruits) {

    Arrays.sort(fruits);
    HashSet<Integer> set = new HashSet<>();
    int maximumFruitsCollected = 0;
    for (int i = fruits.length - 1; i >= 0; i--) {

      if (set.contains(fruits[i])) {
        maximumFruitsCollected++;
      } else {
        set.add(fruits[i]);
        if (set.size() > 2) {
          return maximumFruitsCollected;
        } else {
          maximumFruitsCollected++;
        }
      }
    }
    return maximumFruitsCollected;
  }

  public static int maxArea(int[] height) {

    int maximumArea = 0;

    int start = 0, end = height.length - 1;

    while (start < end) {
      int calculatedArea = Math.min(height[start], height[end]) * (end - start);
      maximumArea = Math.max(maximumArea, calculatedArea);
      if (height[start] < height[end]) {
        start++;
      } else {
        end--;
      }
    }
    return maximumArea;

  }

  public static List<List<Integer>> threeSum(int[] nums) {


    List<List<Integer>> result = new ArrayList<>();

    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        break;
      }
      if (i == 0 || nums[i] != nums[i - 1]) {
        int high = nums.length - 1, low = i + 1, complementRequired = -nums[i];

        while (low < high) {
          if (nums[high] + nums[low] == complementRequired) {
            result.add(Arrays.asList(nums[i], nums[low], nums[high]));
            while ((low < high) && nums[low] == nums[low + 1]) {
              low++;
            }
            while ((low < high) && nums[high] == nums[high - 1]) {
              high--;
            }
            high--;
            low++;
          } else if (nums[high] + nums[low] < complementRequired) {
            low++;
          } else {
            high--;
          }
        }
      }
    }


    return result;

  }

  public int[] twoSum(int[] nums, int target) {

    HashMap<Integer, Integer> map = new HashMap<>();//Number,Index

    for (int i = 0; i < nums.length; i++) {
      int complementRequired = target - nums[i];

      if (map.containsKey(complementRequired)) {
        return new int[]{map.get(complementRequired), i};
      } else {
        map.put(nums[i], i);
      }
    }
    return new int[]{-1, -1};

  }

  public static int threeSumClosest(int[] nums, int target) {
    if (nums.length <= 3) {
      return Arrays.stream(nums).sum();
    }
    Arrays.sort(nums);


    int result = nums[0] + nums[1] + nums[nums.length - 1];


    for (int i = 0; i < nums.length - 1; i++) {

      int low = i + 1;
      int high = nums.length - 1;

      while (low < high) {
        int sum = nums[i] + nums[low] + nums[high];
        if (sum == target) {
          return target;
        } else if (sum > target) {
          high--;
        } else {
          low++;
        }
        if (Math.abs(target - sum) < Math.abs(target - result)) {
          result = sum;
        }
      }
    }
    return result;
  }

  public static int threeSumSmaller(int[] nums, int target) {
    if (nums.length < 3) {
      return 0;
    }
    if (nums.length == 3) {

      if (Arrays.stream(nums).sum() >= target) return 0;
      else return 1;

    }
    Arrays.sort(nums);

    int result = 0;

    for (int i = 0; i < nums.length - 1; i++) {

      int low = i + 1;
      int high = nums.length - 1;

      while (low < high) {
        int sum = nums[i] + nums[low] + nums[high];
        if (sum > target) {
          high--;
        } else if (sum < target) {
          low++;
          result++;
        } else {
          high--;
        }
      }
    }
    return result;
  }

  public static String multiply(String num1, String num2) {

    if (num1.isBlank() && num2.isBlank()) return "0";
    if (num1.equals("0") || num2.equals("0")) return "0";

    List<String> list = new ArrayList<>();

    for (int i = 0; i < num1.length(); i++) {
      String result = multiplyWithSingleDigit(num1.charAt(i), num2);

      if (!result.equals("0")) {
        result = result + "0".repeat(num1.length() - 1 - i);
        list.add(result);
      }
    }
    String finalResult = "";
    for (String number : list) {

      finalResult = addTwoNumbers(finalResult, number);

    }
    return finalResult;
    /*return list.stream().reduce(PracticeBasic::addTwoNumbers).get();*/
  }

  public static String multiplyWithSingleDigit(char digit, String num2) {
    StringBuilder res = new StringBuilder();
    int singleDigitNumber = Character.getNumericValue(digit);
    if (singleDigitNumber == 0 || num2.isBlank()) return "0";
    int sum = 0;
    int carry = 0;

    for (int i = num2.length() - 1; i >= 0; i--) {

      int multiplicationResult = carry + Character.getNumericValue(num2.charAt(i)) * singleDigitNumber;
      sum = multiplicationResult % 10;
      carry = multiplicationResult / 10;
      res.insert(0, sum);
    }
    if (carry != 0) {
      res.insert(0, carry);
    }
    return res.toString();
  }

  public static String addTwoNumbers(String num1, String num2) {

    if (num1.isBlank() && num2.isBlank()) return "0";
    if (num1.isBlank() && !num2.isBlank()) return num2;
    if (num2.isBlank() && !num1.isBlank()) return num1;

    int carry = 0;
    int sum = 0;
    int firstNumDigit, secondNumDigit;
    StringBuilder res = new StringBuilder();

    for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i--, j--) {

      firstNumDigit = i >= 0 ? Character.getNumericValue(num1.charAt(i)) : 0;
      secondNumDigit = j >= 0 ? Character.getNumericValue(num2.charAt(j)) : 0;
      sum = (carry + firstNumDigit + secondNumDigit) % 10;
      carry = (carry + firstNumDigit + secondNumDigit) / 10;
      res.insert(0, sum);
    }
    if (carry != 0) {
      res.insert(0, carry);
    }
    return res.toString();
  }

  public void rotate(int[][] matrix) {


  }

  public void transpose(int[][] matrix) {

    for (int i = 0; i < matrix.length; i++) {
      for (int j = i; j < matrix[0].length; j++) {

        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }
  }

  public void reverseRow(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      int left = 0, right = matrix[i].length - 1;
      while (left < right) {
        int temp = matrix[i][left];
        matrix[i][left] = matrix[i][right];
        matrix[i][right] = temp;
        left++;
        right--;
      }
    }
  }

  public static int findMinWeight(List<Integer> weights, int d) {
    // Write your code here
    TreeSet<Integer> set = new TreeSet<>(weights);

    while (d > 0) {
      int currWeight = set.last();
      currWeight = currWeight / 2;
      set.remove(set.last());

      set.add(currWeight);
      d--;
    }
    int sum = 0;

    for (int num : set) {
      sum = sum + num;
    }
    System.out.print("Sum: " + sum);
    return sum;


  }

  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int m = nums1.length;
    int n = nums2.length;
    int[] sortedArray = new int[m + n];
    int i = 0, j = 0;
    int k = 0;

    while (i < m && j < n) {
      sortedArray[k++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
    }
    while (i < m) {
      sortedArray[k++] = nums1[i++];
    }
    while (j < n) {
      sortedArray[k++] = nums2[j++];
    }
    int p = (m + n) / 2;
    if ((m + n) % 2 == 0) {
      return (sortedArray[p] + sortedArray[p - 1]) / (double) 2;
    }
    return sortedArray[p];
  }


  public static int[] searchRange(int[] nums, int target) {

    int first = findFirst(nums, target);
    int last = findLast(nums, target);
    return new int[]{first, last};
  }

  private static int findFirst(int[] nums, int target) {
    int idx = -1;
    int start = 0;
    int end = nums.length - 1;
    while (start <= end) {
      int mid = (start + end) / 2;
      if (nums[mid] >= target) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
      if (nums[mid] == target) {
        idx = mid;
      }
    }
    return idx;
  }

  private static int findLast(int[] nums, int target) {

    int idx = -1;
    int start = 0;
    int end = nums.length - 1;
    while (start <= end) {
      int mid = (start + end) / 2;
      if (nums[mid] <= target) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
      if (nums[mid] == target) idx = mid;
    }
    return idx;
  }

  public int[][] merge(int[][] intervals) {

    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

    int[] newInterval = intervals[0];
    List<int[]> result = new ArrayList<>();
    result.add(newInterval);

    for (int[] interval : intervals) {

      if (interval[0] <= newInterval[1]) {

      }
    }
    return null;

  }

  public static boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;

    char[] s1 = s.toCharArray();
    char[] t1 = t.toCharArray();

    Arrays.sort(s1);
    Arrays.sort(t1);

    for (int i = 0; i < s.length(); i++) {
      if (s1[i] != t1[i]) {
        return false;
      }
    }
    return true;

  }

  public List<Integer> countSmaller(int[] nums) {
    List<Integer> res = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
      res.add(countSmallerhelper(nums, i));
    }
    return res;
  }

  private Integer countSmallerhelper(int[] nums, int startIndex) {
    int counter = 0;

    for (int i = startIndex + 1; i < nums.length; i++) {
      if (nums[i] < nums[startIndex]) {
        counter++;
      }
    }
    return counter;
  }
}