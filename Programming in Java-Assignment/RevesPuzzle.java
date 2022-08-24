/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class RevesPuzzle {
    private static void revesPuzzle(int n, String from, String mid1, String mid2, String to) {
        if (n == 1)
            StdOut.println("Move disc " + n + " from " + from + " to " + to);

        else {
            int k = (int) Math.round(n + 1 - Math.sqrt(2 * n + 1));
            revesPuzzle(k, from, mid2, to, mid1); // move top k disks from A to B
            hanoi(n, k, from, mid2, to); // move the remaining n-k disks from A to D, w/o using B
            revesPuzzle(k, mid1, from, mid2, to); // move top k disks from B to D
        }

    }

    // hanoi moves the remaining n-k stacks from "from" to "to" using "temp"
    private static void hanoi(int n, int k, String from, String temp, String to) {
        if (n == k)
            return;
        if (n - k == 1)
            System.out.println("Move disc " + n + " from " + from + " to " + to);
        else {
            hanoi(n - 1, k, from, to, temp);
            System.out.println("Move disc " + n + " from " + from + " to " + to);
            hanoi(n - 1, k, temp, from, to);
        }

    }


    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]); // discs are in increasing order of size from 1 to n
        revesPuzzle(n, "A", "B", "C", "D");
    }
}
