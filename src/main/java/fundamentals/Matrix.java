package fundamentals;

import static commons.Preconditions.check;

public final class Matrix {

  /**
   * vector dot product.
   */
  public static double dot(double[] x, double[] y) {
    check(
        x.length == y.length,
        "x and y must be equal-length"
    );
    double sum = 0.0;
    for (int i = 0; i < x.length; i++) {
      sum += x[i] * y[i];
    }
    return sum;
  }

  /**
   * matrix-matrix product.
   */
  public static double[][] mult(double[][] a, double[][] b) {
    check(
        a[0].length == b.length,
        "a columns and b rows must be equal-length"
    );
    int n = a[0].length;
    double[][] c = new double[a.length][b[0].length];
    for (int i = 0; i < c.length; i++) {
      for (int j = 0; j < c[i].length; j++) {
        for (int k = 0; k < n; k++) {
          c[i][j] += a[i][k] * b[k][j];
        }
      }
    }
    return c;
  }

  /**
   * transpose.
   */
  public static double[][] transpose(double[][] a) {
    double[][] t = new double[a[0].length][a.length];
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {
        t[j][i] = a[i][j];
      }
    }
    return t;
  }

  /**
   * matrix-vector product.
   */
  public static double[] mult(double[][] a, double[] x) {
    check(
        a[0].length == x.length,
        "a columns and x rows must be equal-length"
    );
    double[] y = new double[x.length];
    for (int i = 0; i < a.length; i++) {
      for (int k = 0; k < y.length; k++) {
        y[i] += a[i][k] * x[k];
      }
    }
    return y;
  }

  /**
   * vector-matrix product.
   */
  public static double[] mult(double[] y, double[][] a) {
    check(
        y.length == a.length,
        "y columns and a rows must be equal-length"
    );
    double[] x = new double[y.length];
    for (int i = 0; i < y.length; i++) {
      for (int k = 0; k < a[i].length; k++) {
        x[i] += y[k] * a[k][i];
      }
    }
    return x;
  }

}
