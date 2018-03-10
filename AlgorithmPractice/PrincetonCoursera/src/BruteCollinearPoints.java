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
                for (int j = 0; j < points.length; j++) {
                    if (points[i].compareTo(points[j]) == 0) {
                        throw new IllegalArgumentException("Illegal points");
                    }
                }
                points = new Point[4];
                this.points = points;
            }
        }

        public int numberOfSegments () {
            return size;
        }

        public LineSegment[] segments () {
        LineSegment [] lineSegments = new LineSegment[3];
            for (int i = 0; i < points.length; i++) {
                for (int j = i + 1; j < points.length + 1; j++) {
                    lineSegments[0] = new LineSegment(points[i],points[j > 3 ? 0 : j]);
                    for (int k = i + 2; k < points.length + 2; k++) {
                        lineSegments[1] = new LineSegment(points[j], points[k > 3 ? ( k - 4) : k]);
                        for (int l = i + 3; l < points.length + 3; l++) {
                            lineSegments[2] = new LineSegment(points[k],points[l > 3 ? (l - 4) : l]);
                        }
                    }

                }

            }


        }

    }
