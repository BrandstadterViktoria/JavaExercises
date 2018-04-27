package PartI_Week3_CollinearPoints;

import edu.princeton.cs.algs4.StdDraw;

import java.util.Comparator;

public class Point implements Comparable<Point> {

    private final int x;
    private final int y;

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
        else if (y0 < y1 || y0 == y1 && x0 < x1) {
            diff = -1;
        } else {
            diff = 1;
        }
        return diff;

    }

    public double slopeTo(Point that) {
        int x0 = this.x;
        int y0 = this.y;
        int x1 = that.x;
        int y1 = that.y;

        //horizontal line
        if (y0 == y1 && x0 != x1) {
            return +0.0;

        }

        //vertical line
        if (x0 == x1 && y0 != y1) {
            return Double.POSITIVE_INFINITY;

        }

        //if (x0, y0) and (x1, y1) are equal.
        if (this.compareTo(that) == 0) {
            return Double.NEGATIVE_INFINITY;

        }
        return ((double) (y1 - y0)) / (x1 - x0);
    }


    public Comparator<Point> slopeOrder() {
        Comparator<Point> comparator = new CompareSlope();

        return comparator;
    }

    private class CompareSlope implements Comparator<Point> {

        @Override
        public int compare(Point point1, Point point2) {

            int comparison = 0;
            if (slopeTo(point1) < slopeTo(point2)) {
                comparison = -1;
            }

            if (slopeTo(point1) == slopeTo(point2)) {
                comparison = 0;
            }

            if (slopeTo(point1) > slopeTo(point2)) {
                comparison = 1;
            }

            return comparison;

        }
    }
}
