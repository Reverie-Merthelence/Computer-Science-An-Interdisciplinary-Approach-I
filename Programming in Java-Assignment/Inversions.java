/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class Inversions {
    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        long count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (i < j && a[i] > a[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
        int[] a = new int[n];

        if (k < n - 1) { // if k<n-1, then put the value n-1 at a[n-k-1]
            for (int i = 0; i < n - k - 1; i++)
                a[i] = i; // initialize the first part of a[i], from a[0]~a[n-k-2]
            a[n - (int) k - 1] = n - 1; // put the value n-1 at a[n-k-1]
            for (int j = n - (int) k; j < n; j++)
                a[j] = j - 1; // initialize the remaining part of a[i], starting from a[n-k]
        }
        else { // if k>=n-1:
            // first put value n-1 at a[0] (n-2 at a[1]), so that it's inverted with n−1, n-2 elements
            int i = 0;
            while (k >= n - 1 - i && i < n) {
                a[i] = n - 1 - i;
                k -= n - 1 - i; // then deduct k
                i++;
            }

            // second, put 0,1... afterwards, starting from a[i]
            int remaining = 0;
            for (int j = i; j < n - k - 1; j++) {
                a[j] = remaining;
                remaining++;

            }

            // third, filling the third part, with k inverse
            if (k != 0)
                a[n - (int) k - 1] = n - i - 1;

            // filing the remaining part
            if (k != 0) {
                for (int j = n - (int) k; j < n;
                     j++) {
                    a[j] = remaining;
                    remaining++;
                }
            }
            else a[n - 1] = remaining;
        }
        return a;

    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);
        int[] a = generate(n, k);
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();

    }
}
