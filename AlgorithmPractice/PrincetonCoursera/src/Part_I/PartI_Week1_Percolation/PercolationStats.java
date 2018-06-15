package Part_I.PartI_Week1_Percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.Stopwatch;

public class PercolationStats {

    private double[] experiments;

    public PercolationStats(int n, int trials) {

        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException(" n and trial must be greater than null");
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
        return mean() - (1.96 * stddev() / Math.sqrt(experiments.length));

    }// low  endpoint of 95% confidence interval

    public double confidenceHi() {
        return mean() + (1.96 * stddev() / Math.sqrt(experiments.length));


    }// high endpoint of 95% confidence interval

    public static void main(String[] args) {
        int arg1 = Integer.parseInt(args[0]);
        int arg2 = Integer.parseInt(args[1]);

        Stopwatch sw = new Stopwatch();

        PercolationStats ps = new PercolationStats(arg1, arg2);

        String confidence = ps.confidenceLo() + ", " + ps.confidenceHi();
        edu.princeton.cs.algs4.StdOut.println("mean                    = " + ps.mean());
        edu.princeton.cs.algs4.StdOut.println("stddev                  = " + ps.stddev());
        edu.princeton.cs.algs4.StdOut.println("95% confidence interval = " + confidence);


    }// test client (described below)
}

