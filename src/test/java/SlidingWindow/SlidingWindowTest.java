package SlidingWindow;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SlidingWindowTest {

  SlidingWindow slidingWindow;

  @BeforeEach
  public void setUp() {
    slidingWindow = new SlidingWindow();

  }

  @Test
  void isValid() {
    assertTrue(slidingWindow.isValid("(())"));


  }
}