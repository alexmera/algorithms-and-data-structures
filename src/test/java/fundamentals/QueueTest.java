package fundamentals;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QueueTest {

  @Test
  @DisplayName("queue operations")
  void queueOperations() {
    String input = "to be or not to - be - - that - - - is";
    Queue<String> queue = new Queue<>();
    StringBuilder sb = new StringBuilder();
    for (String item : input.split(" ")) {
      if(!item.equals("-")) {
        queue.enqueue(item);
      }else if(!queue.isEmpty()) {
        sb.append(queue.dequeue()).append(" ");
      }
    }

    assertEquals("to be or not to be ", sb.toString());
    assertEquals(2, queue.size());
  }

}
