import java.util.Arrays;

public class FastCollinearPoints {

    private int size;
    private final LineSegment[] lineSegments;

    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {
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
        this.lineSegments = new LineSegment[points.length -1];
        Point[] copy = Arrays.copyOf(points, points.length -1);
        for (int i = 0; i < copy.length; i++) {
            Arrays.sort(copy, points[i].slopeOrder());
            for (int j = 1; j < copy.length -2; j++) {
                if (points[i].slopeTo(copy[j]) == points[i].slopeTo(copy[j + 1]) &&
                        points[i].slopeTo(copy[j + 1]) == points[i].slopeTo(copy[j + 2])) {
                    lineSegments[i] = new LineSegment(points[i], copy[j + 2]);
                    size++;

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

