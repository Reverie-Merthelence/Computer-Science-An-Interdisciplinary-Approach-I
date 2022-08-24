/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class Checkerboard {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setScale(0.0, n); // set both X and Y scale to [0, n)
        StdDraw.setPenColor(StdDraw.BLUE); // set the square blue
        for (int i = 0; i < n; i += 2) {
            for (int j = 0; j < n; j += 2) {
                if (i + 0.5 < n
                        && j + 0.5 < n) // make sure the square to be drawn is in the boundary
                    StdDraw.filledSquare(i + 0.5, j + 0.5,
                                         0.5); // the first blue square in the first row
                if (i + 1.5 < n && j + 1.5 < n)
                    StdDraw.filledSquare(i + 1.5, j + 1.5,
                                         0.5); // the first blue square in the second row
            }

        }
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY); // set the square gray
        for (int i = 0; i < n; i += 2) {
            for (int j = 0; j < n; j += 2) {

                if (i + 1.5 < n && j + 0.5 < n)
                    StdDraw.filledSquare(i + 1.5, j + 0.5,
                                         0.5); // the first gray square in the first row

                if (j + 1.5 < n && i + 0.5 < n)
                    StdDraw.filledSquare(i + 0.5, j + 1.5,
                                         0.5); // the first gray square in the second row

            }

        }
    }
}

