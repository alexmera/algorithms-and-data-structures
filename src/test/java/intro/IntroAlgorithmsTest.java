package intro;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IntroAlgorithmsTest {

  @Test
  @DisplayName("Find the maximum of the array values")
  void maxInArray() {
    int[] values = {4, 8, 2, 9, 0, 7, 1, 6};

    assertEquals(9, IntroAlgorithms.maxInArray(values));
  }

  @Test
  @DisplayName("Reverse the elements within an array")
  void reverseArray() {
    int[] values = {1, 2, 3, 4, 5, 6};
    int[] reversed = {6, 5, 4, 3, 2, 1};

    assertArrayEquals(reversed, IntroAlgorithms.reverseArray(values));
  }

  @Test
  @DisplayName("Matrix-matrix multiplication (square matrices)")
  void squareMatricesMultiplication() {
    int[][] a = {{1, -1, 1}, {2, 2, 3}, {-2, -3, -1}};
    int[][] b = {{1, 0, 4}, {0, 2, 5}, {1, 3, 0}};
    long[][] c = IntroAlgorithms.squareMatricesMultiplication(a, b);

    long[][] expected = {{2, 1, -1}, {5, 13, 18}, {-3, -9, -23}};
    for (int i = 0; i < c.length; i++) {
      assertArrayEquals(expected[i], c[i]);
    }
  }

  @Test
  @DisplayName("Primality test")
  void isPrime() {
    int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37,
        41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
    int[] noPrimes = {4, 6, 8, 9, 10, 12, 14, 15, 16};

    for (int i = 0; i < primes.length; i++) {
      assertTrue(IntroAlgorithms.isPrime(primes[i]), String.format("%s is not a prime", primes[i]));
    }

    for (int i = 0; i < noPrimes.length; i++) {
      assertFalse(
          IntroAlgorithms.isPrime(noPrimes[i]),
          String.format("%s is a prime", noPrimes[i]));
    }
  }

  @Test
  @DisplayName("Square root (Newton’s method)")
  void sqrt() {
    double[][] tests = {{0, 0}, {4, 2}, {9, 3}, {16, 4}, {25, 5}, {36, 6}, {49, 7}};

    for (int i = 0; i < tests.length; i++) {
      assertEquals(
          tests[i][1],
          IntroAlgorithms.sqrt(tests[i][0]),
          0.001D,
          String.format("The square root of %s is %s", tests[i][0], tests[i][1])
      );
    }
  }
}
