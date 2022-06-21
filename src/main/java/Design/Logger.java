package Design;

import java.util.HashMap;

/**
 * Design a logger system that receives a stream of messages along with their timestamps.
 * Each unique message should only be printed at most every 10 seconds (i.e. a message printed at timestamp t
 * will prevent other identical messages from being printed until timestamp t + 10).
 * <p>
 * All messages will come in chronological order. Several messages may arrive at the same timestamp.
 * <p>
 * Implement the Logger class:
 * Logger() Initializes the logger object.
 * bool shouldPrintMessage(int timestamp, string message) Returns true if the message should be printed in the
 * given timestamp, otherwise returns false.
 */

public class Logger {

  private HashMap<String, Integer> map;

  public Logger() {
    map = new HashMap<>();
  }

  /**
   * @param timestamp
   * @param message
   * @return true if the message should be printed in the given timestamp, otherwise returns false.
   */

  public boolean shouldPrintMessage(int timestamp, String message) {
    if (message == null) return false;

    if (!map.containsKey(message)) {
      map.put(message, timestamp);
      return true;
    }

    if (map.get(message) + 10 <= timestamp) {
      map.put(message, timestamp);
      return true;
    } else {
      return false;
    }
  }

}
