import java.util.Arrays;

public class BruteCollinearPoints {

    private  int size;
    private final LineSegment[] lineSegments;

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
        Point [] copy = Arrays.copyOf(points,points.length);
        Arrays.sort(copy);

        this.lineSegments = new LineSegment[copy.length - 1];
        for (int i = 0; i < copy.length - 3; i++) {
            for (int j = i + 1; j < copy.length - 2; j++) {
                for (int k = j + 1; k < copy.length - 1; k++) {
                    for (int l = k + 1; l < copy.length; l++) {
                        if (copy[i].slopeTo(copy[j]) == copy[j].slopeTo(copy[k]) && copy[j].slopeTo(copy[k]) == copy[k].slopeTo(copy[l])) {
                            lineSegments[size++] = new LineSegment(copy[i], copy[l]);
                        }
                    }

                }

            }
        }
    }

    public int numberOfSegments() {
        return size;
    }

    public LineSegment[] segments() {

        return Arrays.copyOf(lineSegments, size);
    }
}
