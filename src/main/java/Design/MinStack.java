package Design;

import java.util.HashSet;
import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * Implement the MinStack class:
 * <p>
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 */

public class MinStack {
  private Stack<Integer> stack;
  private Stack<Integer> stackCopy;

  public MinStack() {
    stack = new Stack<>();
    stackCopy = new Stack<>();

  }

  public void push(int val) {
    if (stack.isEmpty()) {
      stack.push(val);
      stackCopy.push(val);
      return;
    } else {

      stack.push(val);
      if (val <= stackCopy.peek()) {
        stackCopy.push(val);
      }
    }

  }

  public void pop() {
    if (stack.isEmpty()) return;

    int valueToBeRemoved = stack.pop();
    if (valueToBeRemoved <= stackCopy.peek()) {
      stackCopy.pop();
    }

  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    HashSet<Integer> set = new HashSet<>();
    return stackCopy.peek();
  }
}
