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

        // for (Point p : points) {
        //     StdOut.print(p.toString());
        // }
        // StdOut.println();
        //
        // for (Point p : pointsCopy) {
        //     StdOut.print(p.toString());
        // }
        // StdOut.println();
        //
        // MergeX.sort(points, points[0].slopeOrder());
        // for (Point p : points) {
        //     StdOut.print(p.toString());
        // }
        // StdOut.println();
        // for (Point p : pointsCopy) {
        //     StdOut.print(p.toString());
        // }

        // for (Point p : points) {
        //     StdOut.print(points[0].slopeTo(p) + " ");
        // }
        // MergeX.sort(points, points[0].slopeOrder());
        // StdOut.println();
        // for (Point p : points) {
        //     StdOut.print(points[0].slopeTo(p) + " ");
        // }


        for (int h = 0; h < points.length; h++) {

            // sort by slope w.r.t. h
            // MergeX.sort(points, points[h].slopeOrder());
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
                        if (j >= points.length - 1) break;// prevents out of index access
                        // else break;
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

                        // sort the copy (not by slope)
                        MergeX.sort(copy);
                        // create line segment (from the lowest to the highest of the sorted)
                        s.push(new LineSegment(copy[0], copy[copy.length - 1]));
                        // jump i to skip all the values already seen by j
                        i = j - 1; // will become i=j after i++ from for loop
                    }
                }
                else {
                    prev = points[0].slopeTo(points[i]);
                }
            }

        }


        // finding segments old
        /*
        points = points.clone(); // work on a copy to ensure it is immutable

        for (int i = 0; i < points.length; i++) {
            // for each p
            // sort by slope w.r.t. p
            MergeX.sort(points, points[i].slopeOrder());

            for (int j = i + 1; j < points.length - 1; j++) {
                // for each q
                int match = 0;
                // if adjacent not equal
                if (points[i].slopeTo(points[j]) != points[i].slopeTo(points[j + 1])) {
                    continue;
                }
                for (int k = j + 1; k < points.length; k++) {
                    if (points[i].slopeTo(points[j]) == points[i].slopeTo(points[k]))
                        match++;
                }
                if (match >= 2) {

                    StdOut.println(match);
                    Point[] order = new Point[match + 2];

                    order[0] = points[i];
                    for (int x = 1; x < order.length; x++) {
                        order[x] = points[j];
                    }
                    // order[0] = points[i];
                    // order[1] = points[j];
                    // order[2] = points[k];
                    // order[3] = points[l];

                    MergeX.sort(order);
                    s.push(new LineSegment(order[0], order[match + 1]));

                    // s.push(new LineSegment(points[i], points[j + match]));
                    this.numSeg++;
                }

            }
        }

        */


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

    }
}
