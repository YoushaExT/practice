/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

// Brute force. Write a program BruteCollinearPoints.java that examines 4 points at a time and
// checks whether they all lie on the same line segment, returning all such line segments.
// To check whether the 4 points p, q, r, and s are collinear, check whether the three slopes
// between p and q, between p and r, and between p and s are all equal.

// The method segments() should include each line segment containing 4 points exactly once.
// If 4 points appear on a line segment in the order p→q→r→s, then you should include either
// the line segment p→s or s→p (but not both) and you should not include subsegments such as
// p→r or q→r. For simplicity, we will not supply any input to BruteCollinearPoints that
// has 5 or more collinear points.

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MergeX;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class BruteCollinearPoints {

    private Stack<LineSegment> s = new Stack<LineSegment>();
    private int numSeg = 0;
    private final LineSegment[] ls;


    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {

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

        points = points.clone(); // work on a copy to ensure it is immutable

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double slopePQ = points[i].slopeTo(points[j]);
                for (int k = j + 1; k < points.length; k++) {
                    double slopePR = points[i].slopeTo(points[k]);

                    if (slopePQ != slopePR) continue; // todo
                    for (int l = k + 1; l < points.length; l++) {

                        double slopePS = points[i].slopeTo(points[l]);
                        if (slopePQ == slopePS) {
                            // all 3 slopes equals means same line
                            // only draw if from smallest to largest

                            Point[] order = new Point[4];

                            order[0] = points[i];
                            order[1] = points[j];
                            order[2] = points[k];
                            order[3] = points[l];

                            MergeX.sort(order);

                            s.push(new LineSegment(order[0], order[3]));
                            this.numSeg++;

                            // if (points[l].compareTo(points[k]) >= 0
                            //         && points[k].compareTo(points[j]) >= 0
                            //         && points[j].compareTo(points[i]) >= 0) {
                            //     s.push(new LineSegment(points[i], points[l]));
                            //     this.numSeg++;
                            // }
                        }
                    }
                }
            }
        }

        // store all values in the line segment array
        this.ls = new LineSegment[this.s.size()];
        int i = 0;
        while (!this.s.isEmpty()) {
            this.ls[i++] = this.s.pop();
        }

    }

    // the number of line segments
    public int numberOfSegments() {
        return this.numSeg;
    }

    // the line segments
    public LineSegment[] segments() {
        // LineSegment[] ls = new LineSegment[s.size()];
        //
        // int i = 0;
        // while (!s.isEmpty()) {
        //     ls[i++] = s.pop();
        // }

        return this.ls.clone();
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
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();

    }
}
