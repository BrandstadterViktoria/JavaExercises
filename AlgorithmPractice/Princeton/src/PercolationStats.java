import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

class PercolationStats {

    private double[] experiments;

    public PercolationStats(int n, int trials) {

        try {
            if (n <= 0 || trials <= 0) ;
            throw new IllegalArgumentException(" n and trial must be greater than null");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught an IllegalArgumentException");
        }
        experiments = new double[trials];
        // out = new StringBuilder(n+"\n");
        Percolation per;
        for (int x = 0; x < trials; x++) {
            per = new Percolation(n);
            int count = 0;

            do {
                int i = StdRandom.uniform(1, n + 1);
                int j = StdRandom.uniform(1, n + 1);

                if (!per.isOpen(i, j)) {
                    per.open(i, j); // Open site
                    count++;
                }
            } while (!per.percolates());

            experiments[x] = (double) count / (double) (n * n);
        }
    }
    // perform trials independent experiments on an n-by-n grid

    public double mean() {
        return StdStats.mean(experiments);

    }   // sample mean of percolation threshold

    public double stddev() {
        return StdStats.stddev(experiments);
    }// sample standard deviation of percolation threshold

    public double confidenceLo() {

    }// low  endpoint of 95% confidence interval

    public double confidenceHi() {


    }// high endpoint of 95% confidence interval

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);


    }// test client (described below)
}
}
