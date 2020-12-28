/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */
// control + d to end
// testing 123
// import edu.princeton.cs.algs4.StdIn;
// import edu.princeton.cs.algs4.StdOut;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Permutation {

    public static void main(String[] args) {
        final int k = Integer
                .parseInt(args[0]); // first argument to decide how many strings to display
        RandomizedQueue<String> r = new RandomizedQueue<>();
        double n = 1.0;
        while (!StdIn.isEmpty()) { // keep taking string input until empty string is input
            String s = StdIn.readString();
            if (k == 0) { // return nothing if k = 0
                return;
            }
            else if (r.size() < k) {
                r.enqueue(s);
            }
            // swap
            else if (StdRandom.uniform() < (k
                    // random no. between 0(inclusive) and 1(non-inclusive)
                    / n)) { // e.g. k=2 and 3 strings(such as a, b and c); a,b already in queue if swap can become a,c or b,c
                // since both above conditions are false, this condition has the probability k/n (2/3 in this example)
                // 3 combinations for selection(order does not matter) possible each should have 1/3 chance to occur
                // for a,b: Prob(Event(don't swap)) = 1 - P(swap) = 1 - 2/3 = 1/3 true
                // for a,c: Prob(swap) * prob(choose b from {a,b} in dequeue) = 2/3 * 1/2 = 1/3 true
                // for b,c: Prob(swap) * prob(choose a from {a,b} in dequeue) = 2/3 * 1/2 = 1/3 true
                // therefore uniform probability for each outcome
                r.dequeue();
                r.enqueue(s);
            }
            n++;
        }
        while (!r.isEmpty()) {
            // once selected equal chance for every possible order(n!) e.g. p(a,b) = p (b,a) = 1/2
            StdOut.println(r.dequeue());
        }
    }
}
