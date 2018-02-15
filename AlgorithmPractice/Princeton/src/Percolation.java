public class Percolation {

    public boolean initialStateBlocked [] [];

    public Percolation(int n) {
        this.initialStateBlocked= new boolean[n][n];
        for (int i = 0; i <= n + 1; i++) {
            for (int j = 0; j <= n + 1; j++) {
                initialStateBlocked[i][j] = false;
            }
        }
    }
    // open site (row, col) if it is not open already
    public void open(int row, int col){
        if(!isOpen(row, col)){


        }

    }
    // is site (row, col) open?
    public boolean isOpen(int row, int col){
        return initialStateBlocked[row][col];

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
