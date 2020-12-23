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
    private WeightedQuickUnionUF qu; // todo - memory
    private final int n;
    private int count = 0;
    // private boolean percolates;
    // todo - backwash
    private final WeightedQuickUnionUF qu2;

    // todo - memory - delete qu after use?
    private boolean percolates = false;

    public Percolation(int n) {
        if (n < 1) throw new IllegalArgumentException(
                "index " + n + " is not 1 or greater ");
        this.n = n;
        this.grid = new boolean[n][n];
        this.full = new boolean[n][n];
        // this.percolates = false;
        this.qu = new WeightedQuickUnionUF((n) * (n));
        // todo - backwash - new UF object
        this.qu2 = new WeightedQuickUnionUF((n) * n);

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                grid[r][c] = false;
            }
        }

        if (n > 1) {
            //connecting all the first row elements
            for (int c = 0; c < n; c++) {
                qu.union(0, c);
                qu2.union(0, c); // todo - backwash - connect first row but not the last row
            }

            //connecting all the last row elements
            int index = n * (n - 1);
            for (int c = 0; c < n; c++) {
                qu.union(index, index + c);
            }
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
        // first row? also full
        if (row == 1) this.full[row - 1][col - 1] = true;
        // if not open; open it
        this.grid[row - 1][col - 1] = true;

        // increase counter
        this.count++;

        //  perform union with all neighbours
        int index = (row - 1) * (this.n) + col - 1;


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
        // if (qu.find(index) == qu.find(0)) {
        //     this.full[row - 1][col - 1] = true;
        //     // if (row == this.n) this.percolates = true;
        //     return true; // if connected to the first row
        // }
        // todo - backwash - qu2 instead of qu
        if (qu2.find(index) == qu2.find(0)) {
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
        // todo - memory - if already percolates return true since access to qu is lsot
        if (this.percolates) return true;
        int index = (this.n - 1) * (this.n);
        // todo - fix for n=1
        if (this.n == 1 && this.grid[0][0] == false) return false;
        // todo - memory
        this.percolates = qu.find(index) == qu.find(0); // if 1,1 connected to last,1
        if (this.percolates) qu = null;
        return this.percolates;
        // if (qu.find(index) == qu.find(0))
        //     return true; // whole first and last rows are virtually connected so their first elements will immediately connect when any connection is made
        // // for (int i = 1; i <= this.n; i++) {
        // //     if (isFull(this.n, i)) return true; // row no. N(last) columns i (1-N)
        // // }
        // return false;
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
        // todo - memory - this test is only useful till percolation is determined; also it will give null ptr exception
        if (!this.percolates) {
            if (isOpen(r, c)) qu.union(index, index1);
        }
        // todo - backwash - qu2 aswell ; not removing the qu because those connections are used by percolation()
        if (isOpen(r, c)) qu2.union(index, index1);
    }

    // this will ensure that non-existing neighbours of corners are not referenced (they have values 0 and n+1 in 1 indexed arrays)
    private int corner(int rc) {
        if (rc == 0) rc = 1;
        if (rc > this.n) rc = this.n;
        return rc;
    }


    // test client (optional)
    public static void main(String[] args) {
        // [UncommentedEmptyMethodBody]
    }
}
