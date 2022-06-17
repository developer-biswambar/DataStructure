import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PracticeBasicTest {


  @Test
  void multiplyWithSingleDigit() {

    assertAll(() -> {
      assertEquals("4955", PracticeBasic.multiplyWithSingleDigit('5', "991"));
      assertEquals("0", PracticeBasic.multiplyWithSingleDigit('0', "991"));
      assertEquals("0", PracticeBasic.multiplyWithSingleDigit('5', "  "));
      assertEquals("9005238", PracticeBasic.multiplyWithSingleDigit('9', "1000582"));

    });
  }

  @Test
  void addTwoDigits() {

    assertAll(() -> {
      assertEquals("300", PracticeBasic.addTwoNumbers("100", "200"));
      assertEquals("552541", PracticeBasic.addTwoNumbers("525582", "26959"));
      assertEquals("300", PracticeBasic.addTwoNumbers("300", "0"));
      assertEquals("10", PracticeBasic.addTwoNumbers("1", "9"));
    });
  }
}