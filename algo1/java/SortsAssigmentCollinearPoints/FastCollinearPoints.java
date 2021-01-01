/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

// A faster, sorting-based solution. Remarkably, it is possible to solve the problem much faster than the brute-force solution described above.
// Given a point p, the following method determines whether p participates in a set of 4 or more collinear points.
//
// Think of p as the origin.
// For each other point q, determine the slope it makes with p.
// Sort the points according to the slopes they makes with p.
// Check if any 3 (or more) adjacent points in the sorted order have equal slopes with respect to p.
// If so, these points, together with p, are collinear.
// Applying this method for each of the n points in turn yields an efficient algorithm to the problem.
// The algorithm solves the problem because points that have equal slopes with respect to p are collinear,
// and sorting brings such points together. The algorithm is fast because the bottleneck operation is sorting.


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MergeX;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class FastCollinearPoints {

    // private Stack<LineSegment> s = new Stack<LineSegment>();
    private int numSeg = 0;
    private final LineSegment[] ls;

    // finds all line segments containing 4 or more points todo
    public FastCollinearPoints(Point[] points) {

        Stack<LineSegment> s = new Stack<LineSegment>();

        // Exception handling
        if (points == null) throw new IllegalArgumentException("null now allowed");
        for (Point p : points) {
            if (p == null) throw new IllegalArgumentException("null now allowed");
        }
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].slopeTo(points[j]) == Double.NEGATIVE_INFINITY)
                    throw new IllegalArgumentException("duplicates now allowed");
            }
        }

        Point[] pointsCopy = points.clone();
        // finding segments
        points = points.clone(); // work on a copy to ensure it is immutable


        for (int h = 0; h < points.length; h++) {

            // sort by slope w.r.t. h
            // sort a copy to ensure h covers all points
            MergeX.sort(points, pointsCopy[h].slopeOrder());
            // prev value , after sorting h would be the first value
            double prev = points[0].slopeTo(points[0]); // -inf
            // StdOut.println(prev);
            for (int i = 1; i < points.length - 1; i++) {
                // points[0] was points[h] before sorting
                if (points[0].slopeTo(points[i]) == prev) {
                    int j = i + 1;
                    while (points[0].slopeTo(points[j]) == prev) { // calculate j
                        j++;
                        if (j >= points.length) break; // prevents out of index access
                    }
                    if (j >= i + 2) { // means 2+ matches(3+-way) (4+ points)
                        // create copy
                        // j-i=2, when 2 matches -> 4 pts
                        Point[] copy = new Point[j - i + 2];
                        // h (0), prev (i-1) -> j-i
                        copy[0] = points[0]; // 1st point is h (0th)
                        int d = i;
                        for (int c = 1; c < copy.length; c++) {
                            // 2nd to last point: prev -> j-1
                            // copy[1] = points[i-1]; copy[2] = points[i] ..copy[n]=points[j-1]
                            copy[c] = points[d - 1];
                            d++;
                        } // copy complete

                        // todo timing: can save time by using selection sort to only find copy[0]
                        sortOnlyOne(copy);

                        // sort the copy (not by slope)
                        // MergeX.sort(copy); // todo changed for timing
                        // prevent duplicates: only the smallest point is allowed to create a line
                        // test: Is this point the smallest; this point is stored in pointsCopy[h];
                        if (pointsCopy[h].slopeTo(copy[0]) == Double.NEGATIVE_INFINITY) {
                            MergeX.sort(copy);
                            // create line segment (from the lowest to the highest of the sorted)
                            s.push(new LineSegment(copy[0], copy[copy.length - 1]));
                            this.numSeg++;
                        }

                        // jump i to skip all the values already seen by j
                        i = j - 1; // will become i=j after i++ from for loop
                    }
                }
                else {
                    prev = points[0].slopeTo(points[i]);
                }
            }

        }

        // store all values in the line segment array
        this.ls = new LineSegment[s.size()];
        int i = 0;
        while (!s.isEmpty()) {
            this.ls[i++] = s.pop();
        }

    }


    public int numberOfSegments() {
        return this.numSeg;
    }  // the number of line segments todo

    public LineSegment[] segments() {
        return this.ls.clone();
    }               // the line segments todo

    // todo timing fix
    private static void sortOnlyOne(Point[] a) {
        int n = a.length;
        // for (int i = 0; i < n; i++) {
        int i = 0;
        int min = i;
        for (int j = i + 1; j < n; j++) {
            if (less(a[j], a[min])) min = j;
        }
        exch(a, i, min);

        // }

    }

    private static boolean less(Point v, Point w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void main(String[] args) {

        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();

        // StdOut.println(collinear.numberOfSegments()); // to test number of segments

    }
}
