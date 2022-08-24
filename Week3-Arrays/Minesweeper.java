/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        String[][] mine = new String[m][n]; // create m*n mine field

        // plant mine
        for (int i = 0; i < k; i++) {
            if (k > m * n)
                throw new RuntimeException("number of mine can't be larger than m*n minefield!");
            int randrow = (int) (Math.random() * m); // generate randrow [0, m-1]
            int randcol = (int) (Math.random() * n); // generate randcol [0, n-1]
            if (mine[randrow][randcol]
                    == "*") // if a[m][n] has a mine already, execute the for loop again
                i--;
            else
                mine[randrow][randcol] = "*";
        }

        // detect mine around
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                if (!(mine[i][j] == "*")) { // if mine[i][j] has mine, then don't mess with it
                    if (i - 1 >= 0 && j - 1 >= 0 && mine[i - 1][j - 1] == "*") { // top left node
                        count++;
                    }
                    if (i - 1 >= 0 && mine[i - 1][j] == "*") { // top node
                        count++;
                    }
                    if (i - 1 >= 0 && j + 1 < n && mine[i - 1][j + 1] == "*") { // top right node
                        count++;
                    }
                    if (j + 1 < n && mine[i][j + 1] == "*") { // right node
                        count++;
                    }
                    if (i + 1 < m && j + 1 < n
                            && mine[i + 1][j + 1] == "*") { // bottom right node
                        count++;
                    }
                    if (i + 1 < m && mine[i + 1][j] == "*") {  // bottom node
                        count++;
                    }

                    if (i + 1 < m && j - 1 >= 0
                            && mine[i + 1][j - 1] == "*") { // bottom left corner
                        count++;
                    }
                    if (j - 1 >= 0 && mine[i][j - 1] == "*") { // left corner
                        count++;
                    }
                    mine[i][j] = Integer.toString(count);
                }

            }
        }


        // display mine field
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mine[i][j] + "  ");
            }
            System.out.println();
        }

    }

}

