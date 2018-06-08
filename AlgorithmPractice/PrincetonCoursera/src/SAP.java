import edu.princeton.cs.algs4.*;

public class SAP {

    private Digraph G;

    // constructor takes a digraph (not necessarily a DAG)
    public SAP(Digraph G) {
        this.G = G;
    }

    // length of shortest ancestral path between v and w; -1 if no such path
    public int length(int v, int w) {
        if (v < 0 || v > G.V() - 1 || w < 0 || w > G.V() - 1) {
            throw new IllegalArgumentException("The given vertex is not between 0 and " + (G.V() - 1));
        }
        int ancestor = ancestor(v, w);
        int length = 0;
        BreadthFirstDirectedPaths bfsV = new BreadthFirstDirectedPaths(G, v);
        BreadthFirstDirectedPaths bfsW = new BreadthFirstDirectedPaths(G, w);
        for (int t : bfsV.pathTo(ancestor)) {
            length++;
        }
        for (int t : bfsW.pathTo(ancestor)) {
            length++;
        }
        return length - 2;
        }

        // a common ancestor of v and w that participates in a shortest ancestral path; -1 if no such path

    public int ancestor(int v, int w) {
        if (v < 0 || v > G.V() - 1 || w < 0 || w > G.V() - 1) {
            throw new IllegalArgumentException("The given vertex is not between 0 and " + (G.V() - 1));
        }
        int ancestor;
        BreadthFirstDirectedPaths bfsV = new BreadthFirstDirectedPaths(G, v);
        BreadthFirstDirectedPaths bfsW = new BreadthFirstDirectedPaths(G, w);

        // rootVertex must be converted to mother vertex
        int rootVertex = 0;
        for (int vs : bfsV.pathTo(rootVertex)) {
            for (int vs2 : bfsW.pathTo(rootVertex)) {
                if (vs == vs2) {
                    ancestor = vs;
                    return ancestor;
                }
            }
        }
        return -1;
    }

    // length of shortest ancestral path between any vertex in v and any vertex in w; -1 if no such path
    public int length(Iterable<Integer> v, Iterable<Integer> w) {
        if (v == null || w == null) {
            throw new IllegalArgumentException("The iterable has 0 values. ");
        }
        if (v.iterator().next() == null || w.iterator().next() == null) {
            throw new IllegalArgumentException("The iterable contains null valued vertex.");
        }
        int shortest = Integer.MAX_VALUE;
        for (int i : v) {
            for (int t : w) {
                int actualLength = length(i,t);
                if (actualLength < shortest) {
                    shortest = actualLength;
                }
            }
        }
        return shortest;
    }

    // a common ancestor that participates in shortest ancestral path; -1 if no such path
    public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
        if (v == null || w == null) {
            throw new IllegalArgumentException("The iterable has 0 values. " );
        }
        if (v.iterator().next() == null || w.iterator().next() == null) {
            throw new IllegalArgumentException("The iterable contains null valued vertex.");
        }
        int initial;
        int end;
        int shortest = length(v,w);
        for (int i : v) {
            for (int t : w) {
                int actual = length(i, t);
                if ( actual == shortest) {
                    initial = i;
                    end = t;
                    return ancestor(initial,end);
                }
            }
        }
        return -1;
    }

    // do unit testing of this class
    public static void main(String[] args) {
        In in = new In(args[0]);
        Digraph G = new Digraph(in);
        SAP sap = new SAP(G);
            int v = 23;
            int w = 24;
            int length = sap.length(v, w);
            int ancestor = sap.ancestor(v, w);
            StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);
        }
    }

