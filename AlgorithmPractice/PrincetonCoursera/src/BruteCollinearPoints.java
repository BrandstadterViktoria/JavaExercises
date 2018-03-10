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
            for (int i = 0; i < points.length ; i++) {
                for (int j = 1; j < points.length -1; j++) {
                    lineSegments[2] = new LineSegment(points[i],points[j]);
                    for (int k = 0; k < points.length - 2 ; k++) {
                        lineSegments[1] = new LineSegment(points[j], points[k]);
                        for (int l = 0; l < points.length - 3 ; l++) {
                            lineSegments[0] = new LineSegment(points[k],points[l]);
                        }
                    }

                }

            }


        }

    }
