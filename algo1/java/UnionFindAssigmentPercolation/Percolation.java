/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    // creates n-by-n grid, with all sites initially blocked
    private boolean[][] grid; // open or closed
    private boolean[][] full;
    private final WeightedQuickUnionUF qu;
    private final int n;
    private int count = 0;
    private boolean percolates;
    // private int last;

    public Percolation(int n) {
        if (n < 1) throw new IllegalArgumentException(
                "index " + n + " is not 1 or greater ");
        this.n = n;
        this.grid = new boolean[n][n];
        this.full = new boolean[n][n];
        // this.percolates = false;
        this.qu = new WeightedQuickUnionUF((n) * (n));
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                grid[r][c] = false;
            }
        }


        //connecting all the first row elements
        for (int c = 0; c < n; c++) {
            qu.union(0, c);
        }

    }


    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        validate(row);
        validate(col);
        // if already opened
        if (this.isOpen(row, col)) {
            return;
        }
        //todo - first row? also full
        if (row == 1) this.full[row - 1][col - 1] = true;
        // if not open; open it
        this.grid[row - 1][col - 1] = true;

        // increase counter
        this.count++;

        //  perform union with all neighbours
        int index = (row - 1) * (this.n) + col - 1;

        // // up
        // neighbours(index, row - 1, col);
        // if (isFull(corner(row - 1), col)) {
        //     this.full[row - 1][col - 1] = true; //turn both self and neighbours blue(full)
        // }
        // // down
        // neighbours(index, row + 1, col);
        // if (isFull(corner(row + 1), col)) {
        //     this.full[row - 1][col - 1] = true;
        // }
        // // left
        // neighbours(index, row, col - 1);
        // if (isFull(row, corner(col - 1))) {
        //     this.full[row - 1][col - 1] = true;
        // }
        // // right
        // neighbours(index, row, col + 1);
        // if (isFull(row, corner(col + 1))) {
        //     this.full[row - 1][col - 1] = true;
        // }
        // if (isFull(row, col)) { //if i am full all my open neighbours become full
        //     this.full[cornerZ(row - 2)][col - 1] = true && this.grid[cornerZ(row - 2)][col - 1];
        //     this.full[cornerZ(row)][col - 1] = true && this.grid[cornerZ(row)][col - 1];
        //     this.full[row - 1][cornerZ(col - 2)] = true && this.grid[row - 1][cornerZ(col - 2)];
        //     this.full[row - 1][cornerZ(col)] = true && this.grid[row - 1][cornerZ(col)];
        // }

        neighbours(index, row - 1, col);
        neighbours(index, row + 1, col);
        neighbours(index, row, col - 1);
        neighbours(index, row, col + 1);


        // if (row == this.n && isFull(row, col)) this.percolates = true;

    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        validate(row);
        validate(col);
        return this.grid[row - 1][col - 1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        validate(row);
        validate(col);

        // int index = (row - 1) * (this.n) + col - 1;

        // if (this.full[row - 1][col - 1]) { //if i am full all my open neighbours become full
        //     this.full[cornerZ(row - 2)][col - 1] = true && this.grid[cornerZ(row - 2)][col - 1];
        //     this.full[cornerZ(row)][col - 1] = true && this.grid[cornerZ(row)][col - 1];
        //     this.full[row - 1][cornerZ(col - 2)] = true && this.grid[row - 1][cornerZ(col - 2)];
        //     this.full[row - 1][cornerZ(col)] = true && this.grid[row - 1][cornerZ(col)];
        // }

        // return this.full[row - 1][col - 1];

        if (!this.isOpen(row, col)) {
            return false; // if not open can't be full
        }

        if (this.full[row - 1][col - 1]) {
            // if (row == this.n) this.percolates = true;
            return true;
        }
        // if an open site is connected to the first row
        int index = (row - 1) * (this.n) + col - 1;
        // loop over the first row

        // for (int c = 0; c < this.n; c++) {
        //     if (qu.find(index) == qu.find(c)) {
        //         this.full[row - 1][col - 1] = true;
        //         if (row == this.n) this.percolates = true;
        //         return true; // if connected to the first row
        //     }
        // }
        if (qu.find(index) == qu.find(0)) {
            this.full[row - 1][col - 1] = true;
            // if (row == this.n) this.percolates = true;
            return true; // if connected to the first row
        }
        this.full[row - 1][col - 1] = false;
        return false;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {

        return this.count;
    }

    // does the system percolate?
    public boolean percolates() {
        // if any of the last row is full it does
        for (int i = 1; i <= this.n; i++) {
            if (isFull(this.n, i)) return true; // row no. N(last) columns i (1-N)
        }
        return false;
        // return this.percolates;
    }

    // between 1-N
    private void validate(int p) {
        if (p < 1 || p > this.n) {
            throw new IllegalArgumentException(
                    "index " + p + " is not between 1 and " + (this.n + 1));
        }
    }

    private void neighbours(int index, int r, int c) {
        // if (r == 0) r = 1;
        // if (r > this.n) r = this.n;
        // if (c == 0) c = 1;
        // if (c > this.n) c = this.n;
        r = corner(r);
        c = corner(c);

        int index1 = (r - 1) * (this.n) + c - 1; // since qu is 0 indexed and single argument
        if (isOpen(r, c)) qu.union(index, index1);
    }

    private int corner(int rc) {
        if (rc == 0) rc = 1;
        if (rc > this.n) rc = this.n;
        return rc;
    }

    private int cornerZ(int rc) { // for zero indexed
        if (rc == -1) rc = 0;
        if (rc >= this.n) rc = this.n - 1;
        return rc;
    }

    // test client (optional)
    public static void main(String[] args) {
        // [UncommentedEmptyMethodBody]
    }
}
