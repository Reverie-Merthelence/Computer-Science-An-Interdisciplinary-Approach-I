/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */
public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] a
                = new int[args.length]; // a[] has a[0] undefined, while a[1]~a[args.length] used to store n integers
        int[] s = new int[args.length]; // same as a[]

        // put n integers into a[], starting from a[1]
        for (int i = 1; i < args.length; i++) {
            a[i] = Integer.parseInt(args[i]); //
        }

        // put the sum of a[] into s[], starting from s[1], (i.e., s[0]=0, s[1]=s[0]+a[1])
        for (int i = 1; i < args.length; i++) {
            s[i] = s[i - 1] + a[i];
        }

        // start printing m random dices
        for (int i = 0; i < m; i++) {
            double rand = Math.random(); // generate a random number ranging from [0,1)
            int r = (int) (rand * (s[args.length
                    - 1])); // generate a random number ranging from [0, s[n]-1]
            for (int j = 0; j < args.length; j++) {
                if (s[j] <= r && r < s[j + 1])
                    System.out.print(j + 1 + " ");
            }

        }


    }

}

