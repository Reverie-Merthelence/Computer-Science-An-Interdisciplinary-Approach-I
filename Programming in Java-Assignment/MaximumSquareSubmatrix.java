/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class MaximumSquareSubmatrix {
    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a) {
        int n = a.length; // number of rows in n (also number of column)
        int[][] count = new int[n][n];
        for (int i = 0; i < n; i++) { // copy the first row and the first column to count[][]
            count[i][0] = a[i][0];
            count[0][i] = a[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (a[i][j] == 1)
                    count[i][j] = Math.min(count[i][j - 1],
                                           Math.min(count[i - 1][j], count[i - 1][j - 1])) + 1;
                else
                    count[i][j] = 0;
            }
        }
        // Find the maximum entry in count[][]
        int maxOfcount = count[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (maxOfcount < count[i][j])
                    maxOfcount = count[i][j];
            }
        }
        return maxOfcount;

    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                a[i][j] = StdIn.readInt();
        }
        StdOut.println(size(a));
    }
}
