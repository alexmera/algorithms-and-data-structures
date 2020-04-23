package fundamentals;

import edu.princeton.cs.algs4.StdRandom;

public final class Fundamentals {

  /**
   * Computes the exact probability distribution for the sum of two dice.
   */
  public static double[] twoDiceProbabilityDistribution() {
    int sides = 6;
    double[] dist = new double[2 * sides + 1];
    for (int i = 1; i <= sides; i++) {
      for (int j = 1; j <= sides; j++) {
        dist[i + j] += 1.0;
      }
    }
    for (int k = 2; k <= 2 * sides; k++) {
      dist[k] /= 36.0;
    }
    return dist;
  }

  /**
   * Dice throws simulation (with seed).
   */
  public static int diceSimulation(long seed) {
    StdRandom.setSeed(seed);
    return StdRandom.uniform(1, 7);
  }

  /**
   * Dice throws simulation.
   */
  public static int diceSimulation() {
    return StdRandom.uniform(1, 7);
  }
}
