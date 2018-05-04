import edu.princeton.cs.algs4.*;

import java.util.Iterator;

public class SAP {

    private Digraph G;
    private boolean[] marked;
    private Queue<Integer> queueV = new Queue<>();
    private Queue<Integer> queueW = new Queue<>();

    // constructor takes a digraph (not necessarily a DAG)
    public SAP(Digraph G) {
        this.G = G;
        marked = new boolean[G.V()];
    }

    // length of shortest ancestral path between v and w; -1 if no such path
    public int length(int v, int w) {
        if (v < 0 || v > G.V() - 1 || w < 0 || w > G.V() - 1) {
            throw new IllegalArgumentException("The given vertex is not between 0 and " + (G.V()-1));
        }
        int ancestor = ancestor(v, w);
        int numberOfEdgesV = 0;
        int numberOfEdgesW = 0;
        marked[v] = true;
        marked[w] = true;
        queueV.enqueue(v);
        queueW.enqueue(w);
        Iterator<Integer> iV;
        Iterator<Integer> iW;
        while (queueV.size() != 0 && queueW.size() != 0) {
            v = queueV.dequeue();
            w = queueW.dequeue();
            int n;
            int n2;
            iV = G.adj(v).iterator();
            iW = G.adj(w).iterator();
            while (iV.hasNext() && iW.hasNext()) {
                n = iV.next();
                numberOfEdgesV++;
                n2 = iW.next();
                   numberOfEdgesW++;
                if (n == ancestor && n2 == ancestor) {
                    return numberOfEdgesV + numberOfEdgesW;

                }
                if (!marked[n]) {
                    marked[n] = true;
                    queueV.enqueue(n);
                }
            }
        }
        return -1;
    }

    // a common ancestor of v and w that participates in a shortest ancestral path; -1 if no such path
    public int ancestor(int v, int w) {
        if (v < 0 || v > G.V() - 1 || w < 0 || w > G.V() - 1) {
            throw new IllegalArgumentException("The given vertex is not between 0 and " + (G.V()-1));
        }
        int temp = -1;
        for (int adjOfV : G.adj(v)) {
            for (int adjOfW : G.adj(w)) {
                if (adjOfV == adjOfW && temp < adjOfV) {
                    temp = adjOfV;
                }
            }
        }
        return temp;
    }
/*
    // length of shortest ancestral path between any vertex in v and any vertex in w; -1 if no such path
    public int length(Iterable<Integer> v, Iterable<Integer> w) {

    }

    // a common ancestor that participates in shortest ancestral path; -1 if no such path
    public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {


    }*/


    // do unit testing of this class
    public static void main(String[] args) {
        In in = new In(args[0]);
        Digraph G = new Digraph(in);
        SAP sap = new SAP(G);
            int v = 3;
            int w = 11;
            int ancestor = sap.ancestor(v, w);
            int length   = sap.length(v, w);
            StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);

    }
}
