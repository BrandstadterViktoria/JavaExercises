package Part_I.PartI_Week5_KdTree;

import edu.princeton.cs.algs4.*;

public class PointSET {
    private SET<Point2D> pointSet = new SET<>();

    // construct an empty set of points
    public PointSET() {

    }

    // is the set empty?
    public boolean isEmpty() {
        return pointSet.size()== 0;

    }

    // number of points in the set
    public int size() {
        return pointSet.size();

    }

    // add the point to the set (if it is not already in the set)
    public void insert(Point2D p) {
        if (p == null) throw new IllegalArgumentException("Point doesn't exist");
        pointSet.add(p);
    }

    // does the set contain point p?
    public boolean contains(Point2D p) {
        if (p == null) throw new IllegalArgumentException("Point doesn't exist");
        return pointSet.contains(p);

    }
    // draw all points to standard draw
    public void draw() {
        if (pointSet.isEmpty()) throw new IllegalArgumentException("Set is empty");
        for (Point2D point : pointSet) {
            point.draw();
        }
    }

    // all points that are inside the rectangle (or on the boundary)
    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) throw new IllegalArgumentException("Rect doesn't exist");
        SET<Point2D> containedPointSet = new SET<>();
        for (Point2D point: pointSet) {
            if (rect.contains(point)) {
                containedPointSet.add(point);
            }
        }

        return containedPointSet;
    }

    // a nearest neighbor in the set to point p; null if the set is empty
    public Point2D nearest(Point2D p) {
        double temp = 1000;
        Point2D nearest = null;
        if (p == null) throw new IllegalArgumentException("Point doesn't exist");
        for (Point2D point : pointSet) {
            if (point != p) {
                double distanceTo = p.distanceTo(point); {
                    if (distanceTo < temp) {
                        temp = distanceTo;
                        nearest = point;
                    }
                }
            }
        }

        return nearest;
    }

    // unit testing of the methods (optional)
    public static void main(String[] args) {
        // initialize the two data structures with point from file
        String filename = args[0];
        In in = new In(filename);
        PointSET brute = new PointSET();
        while (!in.isEmpty()) {
            double x = in.readDouble();
            double y = in.readDouble();
            Point2D p = new Point2D(x, y);
            brute.insert(p);
        }

        // process nearest neighbor queries
        StdDraw.enableDoubleBuffering();
        while (true) {

            // the location (x, y) of the mouse
            double x = 0.2;
            double y = 0.3;
            Point2D query = new Point2D(x, y);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.setPenRadius(0.01);
            query.draw();
            StdDraw.show();

            // draw all of the points
            StdDraw.clear();
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.setPenRadius(0.01);
            brute.draw();
            StdDraw.show();

            // draw in red the nearest neighbor (using brute-force algorithm)
            StdDraw.setPenRadius(0.03);
            StdDraw.setPenColor(StdDraw.RED);
            brute.nearest(query).draw();
            StdDraw.setPenRadius(0.02);
            StdDraw.show();
        }
    }

}


