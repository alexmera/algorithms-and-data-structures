package intro;

public final class IntroAlgorithms {

  /**
   * Find the maximum of the array values.
   */
  public static int maxInArray(int[] values) {
    int max = values[0];
    for (int i = 1; i < values.length; i++) {
      if (values[i] > max) {
        max = values[i];
      }
    }
    return max;
  }

  /**
   * Reverse the elements within an array.
   */
  public static int[] reverseArray(int[] values) {
    int n = values.length;
    for (int i = 0; i < n / 2; i++) {
      int temp = values[i];
      values[i] = values[n - 1 - i];
      values[n - i - 1] = temp;
    }
    return values;
  }

  /**
   * Matrix-matrix multiplication (square matrices).
   */
  public static long[][] squareMatricesMultiplication(int[][] a, int[][] b) {
    int n = a.length;
    long[][] c = new long[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) {
          c[i][j] += a[i][k] * b[k][j];
        }
      }
    }
    return c;
  }

  /**
   * Primality test.
   */
  public static boolean isPrime(int inputNumber) {
    if (inputNumber < 2) {
      return false;
    }
    for (int i = 2; i * i <= inputNumber; i++) {
      if (inputNumber % i == 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * Square root (Newton’s method).
   */
  public static double sqrt(double c) {
    if (c < 0) {
      return Double.NaN;
    }
    double err = 1e-15;
    double t = c;
    while (Math.abs(t - c / t) > err * t) {
      t = (c / t + t) / 2.0;
    }
    return t;
  }
}
