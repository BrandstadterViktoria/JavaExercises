import edu.princeton.cs.algs4.StdDraw;

import java.util.Comparator;

public class Point implements Comparable<Point> {

    private final int x;
    private final int y;
    private double currentSlope;

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
    //The compareTo() method should compare points by their y-coordinates, breaking ties by their x-coordinates. Formally,
    // the invoking point (x0, y0) is less than the argument point (x1, y1) if and only if either y0 < y1 or if y0 = y1 and x0 < x1.

    /**
     * Compares two points by y-coordinate, breaking ties by x-coordinate.
     * Formally, the invoking point (x0, y0) is less than the argument point
     * (x1, y1) if and only if either y0 < y1 or if y0 = y1 and x0 < x1.
     *
     * @param that the other point
     * @return the value <tt>0</tt> if this point is equal to the argument
     * point (x0 = x1 and y0 = y1);
     * a negative integer if this point is less than the argument
     * point; and a positive integer if this point is greater than the
     * argument point
     */
    public int compareTo(Point that) {
        int x0 = this.x;
        int y0 = this.y;
        int x1 = that.x;
        int y1 = that.y;

        int diff;
        if (x0 == x1 && y0 == y1) {
            diff = 0;
        }
        //invoking point is less than the argument point
        if (y0 < y1 || y0 == y1 && x0 < x1) {
            diff = -1;
        } else {
            diff = 1;
        }
        return diff;

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
        if (y0 == y1 && x0 != x1) {
            currentSlope = 0.0;
            this.currentSlope = currentSlope;
        }

        //vertical line
        if (x0 == x1 && y0 != y1) {
            currentSlope = Double.POSITIVE_INFINITY;
            this.currentSlope = currentSlope;
        }

        //if (x0, y0) and (x1, y1) are equal.
        if (this.compareTo(that) == 0) {
            currentSlope = Double.NEGATIVE_INFINITY;
        } else {
            currentSlope = ((double) (y1 - y0)) / (x1 - x0);
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

    public Comparator<Point> slopeOrder() {
        Comparator<Point> comparator = new CompareSlope();

        return comparator;
    }

    private class CompareSlope implements Comparator<Point> {

        @Override
        public int compare(Point point, Point t1) {

            int comparison = 0;
            if (point.currentSlope < t1.currentSlope) {
                comparison = -1;
            }

            if (point.currentSlope == t1.currentSlope) {
                comparison = 0;
            }

            if (point.currentSlope > t1.currentSlope) {
                comparison = 1;
            }


            return comparison;

        }
    }
}
