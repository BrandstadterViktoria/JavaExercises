package Part_II.PartII_Week1_Wordnet;

import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;
import edu.princeton.cs.algs4.Digraph;

public class SAP {

    private final  Digraph G;
    private int shortest;

    // constructor takes a digraph (not necessarily a DAG)
    public SAP(Digraph G) {
        this.G = G;
    }

    // length of shortest ancestral path between v and w; -1 if no such path
    public int length(int v, int w) {
        if (v < 0 || v > G.V() - 1 || w < 0 || w > G.V() - 1) {
            throw new IllegalArgumentException("The given vertex is not between 0 and " + (G.V() - 1));
        }
        return  ancestor(v,w) == -1 ? -1 : shortest;

        }

        // a common ancestor of v and w that participates in a shortest ancestral path; -1 if no such path

    public int ancestor(int v, int w) {
        if (v < 0 || v > G.V() - 1 || w < 0 || w > G.V() - 1) {
            throw new IllegalArgumentException("The given vertex is not between 0 and " + (G.V() - 1));
        }
        int ancestor = -1;
        shortest = Integer.MAX_VALUE;
        BreadthFirstDirectedPaths bfsV = new BreadthFirstDirectedPaths(G, v);
        BreadthFirstDirectedPaths bfsW = new BreadthFirstDirectedPaths(G, w);

        for (int i = 0; i < G.V(); i++) {
            if (bfsV.hasPathTo(i) && bfsW.hasPathTo(i)) {
                int distance = bfsV.distTo(i) + bfsW.distTo(i);
                if (distance < shortest) {
                    shortest = distance;
                    ancestor = i;
                }
            }
        }
        return ancestor;
    }

    // length of shortest ancestral path between any vertex in v and any vertex in w; -1 if no such path
    public int length(Iterable<Integer> v, Iterable<Integer> w) {
        if (v == null || w == null) {
            throw new IllegalArgumentException("The iterable has 0 values. ");
        }
        if (v.iterator().next() == null || w.iterator().next() == null) {
            throw new IllegalArgumentException("The iterable contains null valued vertex.");
        }

        return ancestor(v,w) == -1 ? -1 : shortest;
    }

    // a common ancestor that participates in shortest ancestral path; -1 if no such path
    public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
        if (v == null || w == null) {
            throw new IllegalArgumentException("The iterable has 0 values. " );
        }
        if (v.iterator().next() == null || w.iterator().next() == null) {
            throw new IllegalArgumentException("The iterable contains null valued vertex.");
        }
        int ancestor = - 1;
        shortest = Integer.MAX_VALUE;
        BreadthFirstDirectedPaths bfsV = new BreadthFirstDirectedPaths(G, v);
        BreadthFirstDirectedPaths bfsW = new BreadthFirstDirectedPaths(G, w);

        for (int i = 0; i < G.V(); i++) {
            if (bfsV.hasPathTo(i) && bfsW.hasPathTo(i)) {
                int distance = bfsV.distTo(i) + bfsW.distTo(i);
                if (distance < shortest) {
                    shortest = distance;
                    ancestor = i;
                }
            }
        }
        return ancestor;
    }


    // do unit testing of this class
    public static void main(String[] args) {
        /*UncommentedEmptyMethodBody*/

        }
    }

