package equations;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class QuadraticEquation {
    private final double a;
    private final double b;
    private final double c;
    private final double y;

    /**
     * @param a - коэффициент при x^2
     * @param b - коэффициент при x
     * @param c - константа
     * @param y - значение в левой части
     *
     *          <p>
     *          Стандартный вид y = ax^2 + bx + c
     */
    public QuadraticEquation(double a, double b, double c, double y) {
        this.a = a;
        this.b = b;
        this.y = y;
        this.c = c - y;
    }

    public Pair<Double, Double> solve() {
        double discriminate = Discriminate.get(a, b, c);
        double x1 = (-b + Math.sqrt(discriminate)) / (2 * a);
        double x2 = (-b - Math.sqrt(discriminate)) / (2 * a);
        return new ImmutablePair<>(x1, x2);
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getY() {
        return y;
    }

    public double getC() {
        return c;
    }

    static class Discriminate {
        public static double get(double a, double b, double c) {
            double discriminate = Math.pow(b, 2) - (4 * a * c);

            if (discriminate >= 0) {
                return discriminate;
            } else {
                throw new RuntimeException("Discriminate below zero");
            }
        }
    }
}
