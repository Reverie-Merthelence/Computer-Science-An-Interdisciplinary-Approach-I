/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class RandomWalker {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int m = 0;
        int n = 0;
        int step = 0;
        System.out.println("(" + m + "," + n + ")");
        while ((Math.abs(m) + Math.abs(n)) != r) {
            double rand = Math.random(); // generate random double [0,1)
            int dir = (int) (rand * 4); // generate random integer 0~3
            if (dir == 0) m--;
            if (dir == 1) n--;
            if (dir == 2) m++;
            if (dir == 3) n++;
            System.out.println("(" + m + "," + n + ")");
            step++;
        }
        System.out.println("steps = " + step);

    }
}
