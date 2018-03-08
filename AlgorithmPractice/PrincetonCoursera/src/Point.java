import edu.princeton.cs.algs4.StdDraw;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class Point implements Comparable<Point> {

    private final int x;
    private final int y;
    private double currentSlope;
    public static final Comparator<Point> compareSlope = new CompareSlope();



    // constructs the point (x, y)
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // draws this point
    public void draw() {
        StdDraw.point(x, y);

    }

    // draws the line segment from this point to that point
    public void drawTo(Point that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // string representation
    public String toString() {
        return "(" + x + ", " + y + ")";

    }

    // compare two points by y-coordinates, breaking ties by x-coordinates
    //breaking ties ---> dont understand
    public int compareTo(Point that) {
        int x0 = this.x;
        int y0 = this.y;
        int x1 = that.x;
        int y1 = that.y;

        if (x0 == x1 && y0 == y1) {
            return 0;
        } else if (y0 < y1 || y0 == y1 && x0 < x1) {
            return -1;
        } else {
            return 1;
        }

    }

    /**
     * Returns the slope between this point and the specified point.
     * Formally, if the two points are (x0, y0) and (x1, y1), then the slope
     * is (y1 - y0) / (x1 - x0). For completeness, the slope is defined to be
     * +0.0 if the line segment connecting the two points is horizontal;
     * Double.POSITIVE_INFINITY if the line segment is vertical;
     * and Double.NEGATIVE_INFINITY if (x0, y0) and (x1, y1) are equal.
     *
     * @param that the other point
     * @return the slope between this point and the specified point
     */
    public double slopeTo(Point that) {
        double currentSlope = 0;
        int x0 = this.x;
        int y0 = this.y;
        int x1 = that.x;
        int y1 = that.y;

        //horizontal line
        if (x0 == x1 && y0 != y1) {
            currentSlope = 0.0;
            this.currentSlope = currentSlope;
        }

        //vertical line
        if (y0 == y1 && x0 != x1) {
            currentSlope = Double.POSITIVE_INFINITY;
            this.currentSlope = currentSlope;
        }

        //if (x0, y0) and (x1, y1) are equal.
        if (compareTo(that) == 0) {
            currentSlope = Double.NEGATIVE_INFINITY;
        } else {
            currentSlope = (y1 - y0) / (x1 - x0);
            this.currentSlope = currentSlope;
        }


        return currentSlope;
    }

        /**
         * Compares two points by the slope they make with this point.
         * The slope is defined as in the slopeTo() method.
         *
         * @return the Comparator that defines this ordering on points
         */

        public Comparator <Point> slopeOrder() {
            Comparator<Point> comparator = new CompareSlope();

            return comparator;
        }

    private static class CompareSlope implements Comparator<Point> {


        @Override
        public int compare(Point point, Point t1) {
            return 0;
        }

        @Override
        public Comparator<Point> reversed() {
            return null;
        }

        @Override
        public Comparator<Point> thenComparing(Comparator<? super Point> comparator) {
            return null;
        }

        @Override
        public <U> Comparator<Point> thenComparing(Function<? super Point, ? extends U> function, Comparator<? super U> comparator) {
            return null;
        }

        @Override
        public <U extends Comparable<? super U>> Comparator<Point> thenComparing(Function<? super Point, ? extends U> function) {
            return null;
        }

        @Override
        public Comparator<Point> thenComparingInt(ToIntFunction<? super Point> toIntFunction) {
            return null;
        }

        @Override
        public Comparator<Point> thenComparingLong(ToLongFunction<? super Point> toLongFunction) {
            return null;
        }

        @Override
        public Comparator<Point> thenComparingDouble(ToDoubleFunction<? super Point> toDoubleFunction) {
            return null;
        }
    }
    }
}
