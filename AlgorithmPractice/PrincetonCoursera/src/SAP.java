import edu.princeton.cs.algs4.*;

public class SAP {

    private Graph G;
    private final int rootVertex = 0;

    // constructor takes a digraph (not necessarily a DAG)
    public SAP(Graph G) {
        this.G = G;
    }

    // length of shortest ancestral path between v and w; -1 if no such path
    public int length(int v, int w) {
        if (v < 0 || v > G.V() - 1 || w < 0 || w > G.V() - 1) {
            throw new IllegalArgumentException("The given vertex is not between 0 and " + (G.V()-1));
        }
        int length = 0;
        BreadthFirstPaths bfsV = new BreadthFirstPaths(G,v);
        BreadthFirstPaths bfsW = new BreadthFirstPaths(G,w);
        while (bfsV.pathTo(rootVertex).iterator().hasNext()) {
              length++;
        }
        while (bfsW.pathTo(rootVertex).iterator().hasNext()) {
            length ++;
        }

        return length;
    }

    // a common ancestor of v and w that participates in a shortest ancestral path; -1 if no such path
    public int ancestor(int v, int w) {
        if (v < 0 || v > G.V() - 1 || w < 0 || w > G.V() - 1) {
            throw new IllegalArgumentException("The given vertex is not between 0 and " + (G.V()-1));
        }
        int ancestor = 0;
        BreadthFirstPaths bfsV = new BreadthFirstPaths(G,v);
        BreadthFirstPaths bfsW = new BreadthFirstPaths(G,w);
        for ( int vs : bfsV.pathTo(rootVertex)) {
            for ( int vs2 : bfsW.pathTo(rootVertex)) {
                if (vs == vs2){
                    ancestor = vs;
                    break;
                }
            }
         }

         return ancestor > 0 ? ancestor : -1;
    }

    // length of shortest ancestral path between any vertex in v and any vertex in w; -1 if no such path
    public int length(Iterable<Integer> v, Iterable<Integer> w) {
        if (v == null || w == null) {
            throw new IllegalArgumentException("The iterable has 0 values. ");
        }

        if (v.iterator().next() == null || w.iterator().next() == null) {
            throw new IllegalArgumentException("The iterable contains null valued vertex.");
        }



    }

    // a common ancestor that participates in shortest ancestral path; -1 if no such path
    public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
        if (v == null || w == null) {
            throw new IllegalArgumentException("The iterable has 0 values. " );
        }
        if (v.iterator().next() == null || w.iterator().next() == null) {
            throw new IllegalArgumentException("The iterable contains null valued vertex.");
        }

    }


    // do unit testing of this class
    public static void main(String[] args) {
        In in = new In(args[0]);
        Digraph G = new Digraph(in);
        SAP sap = new SAP(G, rootVertex);
            int v = 3;
            int w = 11;
            int ancestor = sap.ancestor(v, w);
            int length   = sap.length(v, w);
            StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);

    }
}
