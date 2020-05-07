package fundamentals;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StackTest {

  @Test
  @DisplayName("stack operations")
  void stackOperations() {
    String input = "to be or not to - be - - that - - - is";
    Stack<String> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();
    for (String item : input.split(" ")) {
      if (!item.equals("-")) {
        stack.push(item);
      } else if (!stack.isEmpty()) {
        sb.append(stack.pop()).append(" ");
      }
    }

    assertEquals("to be not that or be ", sb.toString());
    assertEquals(2, stack.size());
  }
}
