/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

public class PercolationStats {

    // private int n;
    private final int trials;
    private final double[] xT;
    private final double mean;
    private final double stddev;
    private final double confidenceLo;
    private final double confidenceHi;


    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        // this.n = n;
        if (trials < 1) throw new IllegalArgumentException(
                "trials " + trials + " is not 1 or greater ");
        this.trials = trials;
        int numRow;
        int numCol;

        this.xT = new double[trials];

        for (int i = 0; i < trials; i++) {
            Percolation p = new Percolation(n);
            // now we need to randomly open stuff


            // repeat until percolates
            while (!p.percolates()) {

                // generate a number from 1->N
                numRow = edu.princeton.cs.algs4.StdRandom.uniform(1, n + 1);
                numCol = edu.princeton.cs.algs4.StdRandom.uniform(1, n + 1);
                // keep opening if not already open
                if (!p.isOpen(numRow, numCol)) {
                    p.open(numRow, numCol);
                }
            }
            this.xT[i] = (double) p.numberOfOpenSites() / (n * n);
            // StdOut.println(p.numberOfOpenSites() + " out of " + n * n);
        }
        // compute mean and stddev once
        this.mean = edu.princeton.cs.algs4.StdStats.mean(this.xT);
        this.stddev = edu.princeton.cs.algs4.StdStats.stddev(this.xT);
        this.confidenceLo = this.mean - ((1.96 * this.stddev) / Math.sqrt(this.trials));
        this.confidenceHi = this.mean + ((1.96 * this.stddev) / Math.sqrt(this.trials));

    }

    // sample mean of percolation threshold
    public double mean() {
        return this.mean;
        // double sum = 0;
        // for (double values : this.xT) {
        //     sum += values;
        // }
        // return sum / this.n;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        // double sum = 0;
        // for (double values : this.xT) {
        //     double numerator = values - this.mean;
        //     sum += numerator * numerator;
        // }

        return this.stddev;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return confidenceLo;
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return confidenceHi;
    }

    // test client (see below)
    public static void main(String[] args) {
        int n = 10;
        int trials = 1;
        if (args.length == 2) {
            n = Integer.parseInt(args[0]);
            trials = Integer.parseInt(args[1]);
        }

        PercolationStats ps = new PercolationStats(n, trials);

        // prints the sample mean, sample standard deviation, and the 95% confidence interval for the percolation threshold

        StdOut.println("mean = " + ps.mean());
        StdOut.println("stddev = " + ps.stddev());
        StdOut.println(
                "95% confidence interval = [" + ps.confidenceLo() + ", " + ps.confidenceHi() + "]");
    }

}
