/******************************************************************************
 *  Compilation:  javac Point.java
 *  Execution:    java Point
 *  Dependencies: none
 *
 *  An immutable data type for points in the plane.
 *  For use on Coursera, Algorithms Part I programming assignment.
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.MergeX;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.Comparator;

public class Point implements Comparable<Point> { // todo
    // public class Point {

    private final int x;     // x-coordinate of this point
    private final int y;     // y-coordinate of this point


    /**
     * Initializes a new point.
     *
     * @param x the <em>x</em>-coordinate of the point
     * @param y the <em>y</em>-coordinate of the point
     */
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    /**
     * Draws this point to standard draw.
     */
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    /**
     * Draws the line segment between this point and the specified point
     * to standard draw.
     *
     * @param that the other point
     */
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    /**
     * Returns the slope between this point and the specified point.
     * Formally, if the two points are (x0, y0) and (x1, y1), then the slope
     * is (y1 - y0) / (x1 - x0). For completeness, the slope is defined to be
     * +0.0 if the line segment connecting the two points is horizontal;
     * Double.POSITIVE_INFINITY if the line segment is vertical;
     * and Double.NEGATIVE_INFINITY if (x0, y0) and (x1, y1) are equal.
     *
     * @param that the other point
     * @return the slope between this point and the specified point
     */
    public double slopeTo(Point that) {
        /* YOUR CODE HERE */
        double deltaY = this.y - that.y;
        double deltaX = this.x - that.x;
        if (deltaY == 0 && deltaX == 0) return Double.NEGATIVE_INFINITY; // same point
        if (deltaY == 0) return +0.0; // horizontal
        if (deltaX == 0) return Double.POSITIVE_INFINITY; // vertical
        return deltaY / deltaX; // slope

    }

    /**
     * Compares two points by y-coordinate, breaking ties by x-coordinate.
     * Formally, the invoking point (x0, y0) is less than the argument point
     * (x1, y1) if and only if either y0 < y1 or if y0 = y1 and x0 < x1.
     *
     * @param that the other point
     * @return the value <tt>0</tt> if this point is equal to the argument
     * point (x0 = x1 and y0 = y1);
     * a negative integer if this point is less than the argument
     * point; and a positive integer if this point is greater than the
     * argument point
     */
    public int compareTo(Point that) {
        /* YOUR CODE HERE */
        if (this.y < that.y) return -1; // y less
        if (this.y > that.y) return 1; // y more
        return Integer.compare(this.x, that.x); // y equal, -ve,0,+ve if x less,x equal,x more
        // if (this.x < that.x) return -1;
        // if (this.x > that.x) return 1;
        // return 0;
    }

    /**
     * Compares two points by the slope they make with this point.
     * The slope is defined as in the slopeTo() method.
     *
     * @return the Comparator that defines this ordering on points
     */
    public Comparator<Point> slopeOrder() {
        /* YOUR CODE HERE */
        // todo
        final Comparator<Point> BY_SLOPE = new BySlope(this);
        return BY_SLOPE;
    } // todo

    private class BySlope implements Comparator<Point> {
        private Point p;

        BySlope(Point thisPoint) {
            this.p = thisPoint;
        }

        public int compare(Point a, Point b) {

            return Double.compare(this.p.slopeTo(a), this.p.slopeTo(b));
            // if (this.p.slopeTo(a) < this.p.slopeTo(b)) return -1;
            // if (this.p.slopeTo(a) > this.p.slopeTo(b)) return 1;
            // return 0;
        }
    }

    /**
     * Returns a string representation of this point.
     * This method is provide for debugging;
     * your program should not rely on the format of the string representation.
     *
     * @return a string representation of this point
     */
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    /**
     * Unit tests the Point data type.
     */
    public static void main(String[] args) {
        /* YOUR CODE HERE */

        // int[] arr = { 1, 2 };
        // while (arr[5] == 2 && false) { // would throw exception
        //     StdOut.println();
        // }
        // while (false && arr[5] == 2) { // would not throw exception
        //     StdOut.println();
        // }

        // test slopeTo
        Point origin = new Point(0, 0);
        Point x = new Point(5, 0);
        Point y = new Point(0, 5);
        Point a = new Point(5, 5);
        Point b = new Point(10, 5);
        Point c = new Point(5, 10);
        Point d = new Point(5, -5);
        Point originCopy = new Point(0, 0);

        // to compare duplicates this can be used
        StdOut.println(origin.slopeTo(originCopy) == Double.NEGATIVE_INFINITY);

        StdOut.println(origin.slopeTo(x)); // should return 0.0
        StdOut.println(origin.slopeTo(y)); // +Infinity
        StdOut.println(origin.slopeTo(a)); // 1.0
        StdOut.println(origin.slopeTo(b)); // 0.5
        StdOut.println(origin.slopeTo(c)); // 2.0
        StdOut.println(origin.slopeTo(origin)); // -Infinity
        StdOut.println(origin.slopeTo(d)); // -1.0
        StdOut.println(d.slopeTo(origin)); // -1.0
        StdOut.println(a.slopeTo(a)); // -Infinity
        // test passed

        // test compareTo
        StdOut.println();
        StdOut.println(c.compareTo(origin)); // should return 1
        StdOut.println(c.compareTo(y)); // should return 1
        StdOut.println(c.compareTo(x)); // should return 1
        StdOut.println(x.compareTo(c)); // should return -1
        StdOut.println(b.compareTo(b)); // should return 0
        StdOut.println(b.compareTo(a)); // should return 1
        StdOut.println(b.compareTo(y)); // should return 1
        StdOut.println(origin.compareTo(origin)); // should return 0
        StdOut.println(c.compareTo(c)); // should return 0
        StdOut.println(y.compareTo(a)); // should return -1
        StdOut.println(a.compareTo(b)); // should return -1
        StdOut.println(y.compareTo(b)); // should return -1
        // test passed

        Point[] A = { x, y, a, b, c, d, origin };
        // StdOut.println(x.toString());
        for (Point point : A) {
            StdOut.println(point.toString());
        }
        StdOut.println();
        StdOut.println();
        MergeX.sort(A, origin.slopeOrder());
        for (Point point : A) {
            StdOut.println(point.toString());
        } // by increasing slope: origin,d,x,b,a,c,y with values: -inf,-1,0,0.5,1,2,+inf
    }
}
