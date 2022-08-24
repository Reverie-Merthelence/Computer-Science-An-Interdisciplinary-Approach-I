/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]); // at most n people entered, with birthdays [0, n-1]
        int trials = Integer.parseInt(args[1]);
        boolean[] birthday; // an array storing all people's birthday
        int i; // count the number of people entered, at most n people
        int[] count = new int[n]; // count sum for each of the number of people entered in trials.
        int[] sum = new int[n];
        for (int j = 0; j < trials; j++) {
            birthday = new boolean[n];
            i = 0;
            while (i <= n - 1) {
                int birth = (int) (Math.random() * n); // generate random birth ranging [0,n-1]
                i++; // enter more people until there is repetition
                if (!birthday[birth])
                    birthday[birth] = true;
                else
                    break;
            }
            //System.out.println("there are " + i + " people entered");
            count[i
                    - 1]++; // count the number of trials when i people entered and satisfies the requirement, put in [i] slot
        }

        // put each element of count[] into sum
        sum[0] = count[0];
        for (int k = 1; k < count.length; k++)
            sum[k] = sum[k - 1] + count[k];

        // print index (starting from 1), count, and sum/trials
        int l = 0;
        do {
            System.out.println(l + 1 + "  " + count[l] + "  " + (double) sum[l] / trials);
            l++;
        } while ((double) sum[l - 1] / trials
                < 0.5); // l-1 to ensure that the first >0.5 outcome will be outputted

    }
}
