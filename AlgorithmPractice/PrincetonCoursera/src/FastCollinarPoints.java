import java.util.Arrays;

public class FastCollinarPoints {

    int size;

    // finds all line segments containing 4 or more points
    public FastCollinearPoints (Point[] points) {
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
        for (int i = 0; i < copy.length ; i++) {
        Arrays.sort(copy,points[i].slopeOrder());
        if ()
    }

    // the number of line segments
    public int numberOfSegments() {

    }

    // the line segments
    public LineSegment[] segments(){

        }
}
}
