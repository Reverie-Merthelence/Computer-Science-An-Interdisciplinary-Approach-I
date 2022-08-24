/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class Ramanujan {
    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        int count = 0;
        double b;
        double precision = 1E-15;
        for (long a = 0; a < Math.ceil(Math.cbrt(n)); a++) { // a=[0, n^1/3], a SHOULD BE LONG
            b = Math.cbrt(n - a * a * a);
            if (Math.abs(b - Math.round(b))
                    < precision) // check if b is an int, precision e-10 (Solving the large integer imprecision problem)
                count++;
            if (count >= 4)
                break;
        }
        return (count >= 4);
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        StdOut.println(isRamanujan(n));

    }
}
