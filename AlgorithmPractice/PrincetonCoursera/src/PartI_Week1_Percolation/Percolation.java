package PartI_Week1_Percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import static edu.princeton.cs.algs4.StdRandom.uniform;

public class Percolation {

    private boolean theGrid[][];
    private int size;
    private WeightedQuickUnionUF weightedQuickUnionUF;
    private int counterForOpenSites;

    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be greater than 0");
        }
        weightedQuickUnionUF = new WeightedQuickUnionUF(n * n + 2);
        this.size = n;
        this.theGrid = new boolean[n][n];

    }

    private int nodeInt(int row, int col) {
        return row * size - size + col;
    }

    // open site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row < 1 || row > size || col < 1 || col > size) {
            throw new IllegalArgumentException("Given row or column is out of range ");
        }
        if (!isOpen(row, col)) {
            theGrid[row -1][col - 1] = true;
            if(row == 1){
             weightedQuickUnionUF.union(0, nodeInt(row, col));
              }
              if(row== size){
               weightedQuickUnionUF.union(size *size +1 , nodeInt(row, col));
}

            this.counterForOpenSites++;
            if (row >= 2 && isOpen(row -1, col)){
                weightedQuickUnionUF.union(nodeInt(row, col), nodeInt(row - 1, col));
            }
            if (row <= size - 1 && isOpen( row + 1, col)) {
                weightedQuickUnionUF.union(nodeInt(row, col), nodeInt( row + 1, col));
            }
            if (col >= 2 && isOpen(row, col - 1)) {
                weightedQuickUnionUF.union(nodeInt(row, col), nodeInt(row, col - 1));
            }
            if (col <= size - 1 && isOpen(row, col + 1)) {
                weightedQuickUnionUF.union(nodeInt(row, col), nodeInt(row, col + 1));
            }
        }
    }

    // is site (row, col) open?
    public boolean isOpen(int row, int col) {
        return theGrid[row - 1][col - 1];

    }

    // is site (row, col) full?
    public boolean isFull(int row, int col) {
        return weightedQuickUnionUF.connected(0,nodeInt(row, col));

    }

    // number of open sites
    public int numberOfOpenSites() {
        return counterForOpenSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return weightedQuickUnionUF.connected(0,size * size + 1);

    }


}
