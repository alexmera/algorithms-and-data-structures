package fundamentals;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MatrixTest {

  @Test
  @DisplayName("vector dot product")
  void dot() {
    double[] x = {1.0, 3.0, -5.0};
    double[] y = {4.0, -2.0, -1.0};

    assertEquals(3.0, Matrix.dot(x, y));
  }

  @Test
  @DisplayName("matrix-matrix product")
  void mult() {
    double[][] a = {{1, 2, 3}, {4, 5, 6}};
    double[][] b = {{7, 8}, {9, 10}, {11, 12}};
    double[][] c = Matrix.mult(a, b);

    double[][] expected = {{58, 64}, {139, 154}};
    for (int i = 0; i < c.length; i++) {
      assertArrayEquals(expected[i], c[i]);
    }
  }

  @Test
  @DisplayName("matrix-matrix product - square")
  void mult_square() {
    double[][] a = {{1, -1, 1}, {2, 2, 3}, {-2, -3, -1}};
    double[][] b = {{1, 0, 4}, {0, 2, 5}, {1, 3, 0}};
    double[][] c = Matrix.mult(a, b);

    double[][] expected = {{2, 1, -1}, {5, 13, 18}, {-3, -9, -23}};
    for (int i = 0; i < c.length; i++) {
      assertArrayEquals(expected[i], c[i]);
    }
  }

  @Test
  @DisplayName("matrix-vector product")
  void multMatrixVector() {
    double[][] a = {{6, -7, 10, 1}, {0, 3, -1, 4}, {0, 5, -7, 5}, {4, 1, 0, -2}};
    double[] x = {2, -2, -1, 1};

    double[] expected = {17, -1, 2, 4};
    assertArrayEquals(expected, Matrix.mult(a, x));
  }

  @Test
  @DisplayName("vector-matrix product")
  void multVectorMatrix() {
    double[] y = {2, -2, -1, 1};
    double[][] a = {
        {6, -7, 10, 1},
        {0, 3, -1, 4},
        {0, 5, -7, 5},
        {4, 1, 0, -2}
    };

    double[] expected = {16, -24, 29, -13};
    assertArrayEquals(expected, Matrix.mult(y, a));
  }

  @Test
  @DisplayName("transpose")
  void transpose() {
    double[][] a = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    double[][] t = Matrix.transpose(a);

    double[][] expected = {
        {1, 4, 7},
        {2, 5, 8},
        {3, 6, 9}
    };
    for (int i = 0; i < t.length; i++) {
      assertArrayEquals(expected[i], t[i]);
    }
  }
}
