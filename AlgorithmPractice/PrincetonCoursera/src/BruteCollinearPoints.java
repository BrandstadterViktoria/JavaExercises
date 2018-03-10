import java.util.ArrayList;
import java.util.List;

public class BruteCollinearPoints {

    Point[] points;
    int size = 0;

    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
        if (points == null) {
            throw new IllegalArgumentException("Illegal points");
        }
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) {
                throw new IllegalArgumentException("Illegal point");
            }
        }
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].compareTo(points[j]) == 0) {
                    throw new IllegalArgumentException("Illegal points");
                }
            }
        }
        this.points = new Point[points.length];
    }

    public int numberOfSegments() {
        return size;
    }

    public LineSegment[] segments() {
        LineSegment[] lineSegments = new LineSegment[points.length - 1];
        for (int i = 0; i < points.length - 3; i++) {
            for (int j = i + 1; j < points.length - 2; j++) {
                for (int k = j + 1; k < points.length - 1; k++) {
                    for (int l = k + 1; l < points.length; l++) {
                        if (points[i].slopeTo(points[j]) == points[j].slopeTo(points[k]) && points[j].slopeTo(points[k]) == points[k].slopeTo(points[l])) {
                            lineSegments[size++] = new LineSegment(points[i], points[l]);
                        }
                    }

                }

            }
        }

        return lineSegments;
    }
}
