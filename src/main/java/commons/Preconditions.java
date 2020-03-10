package commons;

import java.util.Objects;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class Preconditions {

  /**
   * Check an expression.
   *
   * @param expression Expression to check
   * @param errorMessage Optional error message
   * @throws IllegalArgumentException when the expression is false
   */
  public static void check(
      boolean expression,
      @Nullable String errorMessage
  ) throws IllegalArgumentException {
    if (!expression) {
      throw new IllegalArgumentException(
          Objects.requireNonNullElse(errorMessage, "expression is false")
      );
    }
  }
}
