/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        boolean[] thuemorse = new boolean[n];

        for (int i = 1; i < n; i++) {
            int temp = 0;
            for (int j = 0; j < i; j++) {
                if (j + i < n)
                    thuemorse[j + i]
                            = !thuemorse[j]; // a4 has a0~a3 before it. Make a4=a0; a5=a1...
                else break;
                temp = j
                        + i; // after the inner loop is finished, make i point to the last element +1
            }
            i = temp;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (thuemorse[i] == thuemorse[j])
                    System.out.print("+  ");
                else
                    System.out.print("-  ");
            }
            System.out.println();

        }
    }
}
