/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class ShannonEntropy {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] count = new int[m]; // used to count the number of each 1~m appears\
        int numofinput = 0;
        double sum = 0.0;
        while (!StdIn.isEmpty()) {
            int x = StdIn.readInt();
            count[x - 1]++;
            numofinput++;
        }
        for (int i = 0; i < count.length; i++) {
            double temp = (double) count[i] / numofinput;
            if (temp != 0) // decide whether temp is 0, otherwise log(0) would cause math error
                sum += temp * Math.log(temp) / Math.log(2);
        }
        StdOut.printf("% .4f", -sum);
    }
}
