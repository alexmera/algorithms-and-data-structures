package fundamentals;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FundamentalsTest {

  @Test
  @DisplayName("two dice probability distribution")
  void twoDiceProbabilityDistribution() {
    double[] dist = Fundamentals.twoDiceProbabilityDistribution();

    double[] expected = {
        0.0, 0.0, 0.027777777777777776, 0.05555555555555555, 0.08333333333333333,
        0.1111111111111111, 0.1388888888888889, 0.16666666666666666, 0.1388888888888889,
        0.1111111111111111, 0.08333333333333333, 0.05555555555555555, 0.027777777777777776
    };
    for (int i = 0; i < dist.length; i++) {
      System.out.println(String.format("dice-sum=%s - probability=%.3f", i, dist[i]));
      assertEquals(expected[i], dist[i], 0.0001D);
    }
  }

  @Test
  @DisplayName("dice simulation and compare with distribution")
  void diceSimulation() {
    double[] dist = Fundamentals.twoDiceProbabilityDistribution();
    String[] distStr = new String[dist.length];
    for (int i = 0; i < dist.length; i++) {
      distStr[i] = String.format("%.3f", dist[i]);
    }

    int n = 100000;
    int nMax = 110000;
    boolean allMatch = false;
    do {
      n++;
      double[] frequencies = new double[13];
      double[] probabilities = new double[13];
      for (int i = 0; i < n; i++) {
        int sum = Fundamentals.diceSimulation() + Fundamentals.diceSimulation();
        frequencies[sum] += 1;
      }
      for (int i = 0; i < frequencies.length; i++) {
        probabilities[i] = frequencies[i] / n;
      }

      int matchCount = 0;
      for (int i = 0; i < probabilities.length; i++) {
        String probStr = String.format("%.3f", probabilities[i]);
        if (distStr[i].equals(probStr)) {
          matchCount++;
        }
      }
      allMatch = matchCount == probabilities.length;
    } while (!allMatch && n < nMax);
    System.out.println(String.format("allMatch=%s n=%s", allMatch, n));
  }
}
