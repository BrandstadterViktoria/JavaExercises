import Week3_CollinearPoints.Point;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

public class KdTree {

    private int size;
    Node root;

    private class Node {
        double x;
        double y;
        Node left;
        Node right;
        int level;

        public Node(double x, double y, int level) {
            this.x = x;
            this.y = y;
            this.level = level;
        }

        public void insertNode(double xC, double yC) {
            if (xC == x || yC == y) {
                return;
            }
            if (xC < x) {
                if (left == null) {
                    left = new Node(xC,yC, level);
                } else {
                    left.insertNode(xC,yC);
                    level = root.level++;
                }
            } else {
                if (right == null) {
                    right = new Node(xC,yC,level);
                } else {
                    right.insertNode(xC,yC);
                    level = root.level++;
                }
            }
        }
    }

    // is the set empty?
    public  boolean isEmpty() {
        return size == 0;
    }

    // number of points in the set
    public  int size() {
        return size;
    }

    // add the point to the set (if it is not already in the set)
    public  void insert(Point2D p) {
        if (root == null) {
            root = new Node(p.x(), p.y(),1);
            size++;
        }
        else {
            root.insertNode(p.x(), p.y());
            size++;
        }
    }

  /*  // does the set contain point p?
    public boolean contains(Point2D p) {


    }
    // draw all points to standard draw
    public void draw() {
    }


    // all points that are inside the rectangle (or on the boundary)
    public Iterable<Point2D> range(RectHV rect) {


    }

    // a nearest neighbor in the set to point p; null if the set is empty
    public  Point2D nearest(Point2D p) {


    }*/


    // unit testing of the methods (optional)
    public static void main(String[] args) {
        Point2D w = new Point2D(0.7,0.2);
        Point2D e = new Point2D(0.5,0.4);
        Point2D r = new Point2D(0.2,0.3);
        Point2D t = new Point2D(0.4,0.7);
        Point2D z = new Point2D(0.9,0.6);
        KdTree tester = new KdTree();
        tester.insert(w);
        tester.insert(e);
        tester.insert(r);
        tester.insert(t);
        tester.insert(z);

}
}
