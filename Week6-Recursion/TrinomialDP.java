/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class TrinomialDP {
    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        if (k < -n || k > n) {
            return 0;
        }
        else if (k == n) {
            return 1;
        }
        else {
            k = Math.abs(k);
            long[][] memo = new long[n + k + 1][n + k + 1];
            memo[0][0] = 1;

            for (int i = 1; i < n + k + 1; i++) {
                for (int j = 0; j < n + k + 1; j++) {
                    if (j == 0)
                        memo[i][j] = 2 * memo[i - 1][j + 1] + memo[i - 1][j];
                    else if (j + 1 < n + k + 1) {
                        memo[i][j] = memo[i - 1][j - 1] + memo[i - 1][j] + memo[i - 1][j + 1];
                    }

                }
            }
            return memo[n][k];
        }
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        System.out.println(trinomial(n, k));


    }

}

