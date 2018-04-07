import edu.princeton.cs.algs4.Point2D;

public class KdTree {

    private int size;
    Node root;
    private int level;

    private class Node {
        Point2D p;
        Node left;
        Node right;


        public Node(Point2D p) {
            this.p = p;
        }

        public void insertNode(Point2D toInsert) {
            if (toInsert == p) {
                return;
            }
            if (level % 2 == 0) {
                if (toInsert.y() < p.y()) {
                    if (left == null) {
                        left = new Node(toInsert);
                    } else {
                        level++;
                        left.insertNode(toInsert);

                    }
                } else {
                    if (right == null) {
                        right = new Node(toInsert);
                    } else {
                        level++;
                        right.insertNode(toInsert);
                    }
                }
            } else {
                if (toInsert.x() < p.x()) {
                    if (left == null) {
                        left = new Node(toInsert);
                    } else {
                        level++;
                        left.insertNode(toInsert);

                    }
                } else {
                    if (right == null) {
                        right = new Node(toInsert);
                    } else {
                        level++;
                        right.insertNode(toInsert);
                    }
                }
            }
        }

        private Node traverse(Node node, Point2D contained) {
            Node result = null;
            if(node != null){
                result = traverse(node.left, contained);
                if( result != null)
                    return result;

                if(node.p.compareTo(contained) == 0){
                    System.out.println(contained + " was found at " + node);
                    return node;
                }
                result = traverse(node.right, contained);
            }
            return result;
            }
        }


    // is the set empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // number of points in the set
    public int size() {
        return size;
    }

    // add the point to the set (if it is not already in the set)
    public void insert(Point2D p) {
        if (root == null) {
            root = new Node(p);
            level = 1;
            size++;
        } else {
            root.insertNode(p);
            level = 1;
            size++;
        }
    }

    // does the set contain point p?
    public boolean contains(Point2D p) {
        boolean doesContain = false;
        if (root != null) {
            if (root.p.compareTo(p) == 0) {
                doesContain = true;
            } else if (root.traverse(root, p)== null) {
                doesContain = false;
            } else if (root.traverse(root,p) != null) {
                doesContain = true;
            }
        }
        return doesContain;
    }


           /* // draw all points to standard draw
            public void draw () {
            }


            // all points that are inside the rectangle (or on the boundary)
            public Iterable<Point2D> range (RectHV rect){


            }

            // a nearest neighbor in the set to point p; null if the set is empty
            public Point2D nearest (Point2D p){


            }*/

    // unit testing of the methods (optional)
    public static void main(String[] args) {
        Point2D w = new Point2D(0.7, 0.2);
        Point2D e = new Point2D(0.5, 0.4);
        Point2D r = new Point2D(0.2, 0.3);
        Point2D t = new Point2D(0.4, 0.7);
        Point2D z = new Point2D(0.9, 0.6);
        Point2D u = new Point2D(0.4, 0.7);
        KdTree tester = new KdTree();
        tester.insert(w);
        tester.insert(e);
        tester.insert(r);
        tester.insert(t);
        tester.insert(z);
        System.out.println(tester.contains(u));

    }
}
