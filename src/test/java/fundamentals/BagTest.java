package fundamentals;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BagTest {

  @Test
  @DisplayName("bag operations")
  void bagOperations() {
    String input = "to be or not to - be - - that - - - is";

    Bag<String> bag = new Bag<>();
    for (String item : input.split(" ")) {
      bag.add(item);
    }

    for (String item : bag) {
      System.out.println(item);
    }

    assertFalse(bag.isEmpty());
    assertEquals(14, bag.size());
  }

}
