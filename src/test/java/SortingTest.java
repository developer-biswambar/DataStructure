import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortingTest {

  @Test
  void selectionSort() {
    assertAll(() -> {
      assertArrayEquals(new int[]{}, Sorting.selectionSort(new int[]{}));
      assertArrayEquals(new int[]{1}, Sorting.selectionSort(new int[]{1}));
      assertArrayEquals(new int[]{1, 2}, Sorting.selectionSort(new int[]{2, 1}));
      assertArrayEquals(new int[]{1, 2, 3, 4, 5}, Sorting.selectionSort(new int[]{1, 2, 3, 4, 5}));
      assertArrayEquals(new int[]{1, 2, 3, 4, 5}, Sorting.selectionSort(new int[]{1, 5, 2, 4, 3}));

    });
  }

  @Test
  void insertionSort() {

    assertAll(() -> {
      assertArrayEquals(new int[]{}, Sorting.insertionSort(new int[]{}));
      assertArrayEquals(new int[]{1}, Sorting.insertionSort(new int[]{1}));
      assertArrayEquals(new int[]{1, 2}, Sorting.insertionSort(new int[]{2, 1}));
      assertArrayEquals(new int[]{1, 2, 3, 4, 5}, Sorting.insertionSort(new int[]{1, 2, 3, 4, 5}));
      assertArrayEquals(new int[]{1, 2, 3, 4, 5}, Sorting.insertionSort(new int[]{1, 5, 2, 4, 3}));
      assertArrayEquals(new int[]{9, 99, 999, 9999, 99999}, Sorting.insertionSort(new int[]{99999, 9999, 999, 99, 9}));

    });

  }

  @Test
  void bubbleSort() {
    assertArrayEquals(new int[]{}, Sorting.bubbleSort(new int[]{}));
    assertArrayEquals(new int[]{1}, Sorting.bubbleSort(new int[]{1}));
    assertArrayEquals(new int[]{1, 2}, Sorting.bubbleSort(new int[]{2, 1}));
    assertArrayEquals(new int[]{1, 2, 3, 4, 5}, Sorting.bubbleSort(new int[]{1, 2, 3, 4, 5}));
    assertArrayEquals(new int[]{1, 2, 3, 4, 5}, Sorting.bubbleSort(new int[]{1, 5, 2, 4, 3}));
    assertArrayEquals(new int[]{9, 99, 999, 9999, 99999}, Sorting.bubbleSort(new int[]{99999, 9999, 999, 99, 9}));
  }
}