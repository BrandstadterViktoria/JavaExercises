import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import static edu.princeton.cs.algs4.StdRandom.uniform;

public class Percolation {

    public boolean theGrid [] [];
    public int size;
    public WeightedQuickUnionUF weightedQuickUnionUF;

    public Percolation(int n) {
        weightedQuickUnionUF = new WeightedQuickUnionUF(n *n);
        this.size = n;
        this.theGrid  = new boolean[n][n];
        for (int i = 0; i <= n + 1; i++) {
            for (int j = 0; j <= n + 1; j++) {
                theGrid [i][j] = false;
            }
        }

    }
    public int nodeInt(int row, int col){
       return row * size - size + col;
    }

    // open site (row, col) if it is not open already
    public void open(int row, int col){
         row = uniform(size);
         col = uniform(size);
        if(isOpen(row, col)){
            if(isOpen(row -1,col){
                weightedQuickUnionUF.union( [row][col],[row -1][col]);

            }



        }

    }

    // is site (row, col) open?
    public boolean isOpen(int row, int col){
        return theGrid [row][col];

    }
    // is site (row, col) full?
    public boolean isFull(int row, int col) {

    }
    // number of open sites
    public int numberOfOpenSites()  {

    }

    // does the system percolate?
    public boolean percolates() {

    }


}
