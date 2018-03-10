import java.util.Arrays;

public class FastColliniarPoints {

    int size;
    LineSegment[] lineSegments;

    // finds all line segments containing 4 or more points
    public FastColliniarPoints(Point[] points) {
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
        Point[] copy = Arrays.copyOf(points, points.length);
        for (int i = 0; i < points.length; i++) {
            Arrays.sort(copy, points[i].slopeOrder());
            for (int j = 1; j < copy.length; j++) {
                if (copy[i].slopeTo(copy[j]) == copy[i].slopeTo(copy[j + 1]) &&
                        copy[i].slopeTo(copy[j + 1]) == copy[i].slopeTo(copy[j + 2])) {
                    lineSegments[size++] = new LineSegment(points[i], copy[j + 2]);

                }
            }
        }
    }

        // the number of line segments
        public int numberOfSegments () {
            return size;

        }

        // the line segments
        public LineSegment[] segments () {
            return Arrays.copyOf(lineSegments, size);

        }
    }

