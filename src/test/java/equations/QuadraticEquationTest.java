package equations;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuadraticEquationTest {
    @Test
    public void solveTest() {
        QuadraticEquation equation = new QuadraticEquation(1, 0, 0, 4); // x^2 = 4
        Pair<Double, Double> squares = equation.solve();
        Pair<Double, Double> expectedSquares = new ImmutablePair<>(2.0, -2.0);
        Assertions.assertEquals(expectedSquares, squares);

        equation = new QuadraticEquation(1, 4, 0, -3); // x^2 +4x +3 = 0
        squares = equation.solve();
        expectedSquares = new ImmutablePair<>(-1.0, -3.0);
        Assertions.assertEquals(expectedSquares, squares);

        equation = new QuadraticEquation(4, 1, 4, 0); // 4x^2 +x +4 = 0, discriminate < 0
        Assertions.assertThrows(RuntimeException.class, equation::solve);
    }
}
