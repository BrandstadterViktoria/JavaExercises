
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    public boolean isBlocked [] [];

    public Percolation(int n) {

        this.isBlocked  = new boolean[n][n];
        int rows = (int) (Math.ceil(1.0 / n));
        int columns = (int) (Math.ceil(1.0 / n));

        QuPoint2Deue<>[][] grid = (Queue<Point2D>[][]) new Queue[rows + 2][columns + 2];
        for (int i = 0; i <= rows + 1; i++) {
            for (int j = 0; j <= columns + 1; j++) {
                grid[i][j] = new Queue<>();
                isBlocked[i][j] = false;
            }
        }
    }
    // open site (row, col) if it is not open already
    public void open(int row, int col){

    }
    // is site (row, col) open?
    public boolean isOpen(int row, int col){
        return isBlocked [row][col];

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