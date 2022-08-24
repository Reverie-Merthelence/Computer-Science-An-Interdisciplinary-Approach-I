/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class AudioCollage {
    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] newa = new double[a.length];
        for (int i = 0; i < a.length; i++)
            newa[i] = a[i]
                    * alpha; // each sample multiplied by a constant α. This increases the volume when α>1 and decreases it when 0<α<1.
        return newa;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] reversed = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            reversed[i] = a[a.length - i - 1];

        }
        return reversed;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] c = new double[a.length + b.length];
        // copy a[] to c[]
        for (int i = 0; i < a.length; i++)
            c[i] = a[i];
        // copy b[] to c[]
        for (int j = 0; j < b.length; j++)
            c[j + a.length] = b[j];
        return c;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        double[] c;
        if (a.length >= b.length) {
            c = new double[a.length];
            for (int i = 0; i < b.length; i++)
                c[i] = a[i] + b[i];
            for (int j = 0; j < (a.length - b.length); j++) // copy the longer a array to c
                c[j + b.length] = a[j + b.length];
            return c;
        }
        else {
            c = new double[b.length];
            for (int i = 0; i < a.length; i++)
                c[i] = a[i] + b[i];
            for (int j = 0; j < (b.length - a.length); j++) // copy the longer b array to c
                c[j + a.length] = b[j + a.length];
            return c;
        }
    }


    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        int n = (int) (a.length / alpha);
        double[] c = new double[n];
        for (int i = 0; i < n; i++) {
            c[i] = a[(int) (i * alpha)];
        }
        return c;

    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {
        // StdOut.println("Read five wav files and convert them into double[] samples.");
        double[] sample1 = StdAudio.read("beatbox.wav");
        double[] sample2 = StdAudio.read("chimes.wav");
        double[] sample3 = StdAudio.read("exposure.wav");
        double[] sample4 = StdAudio.read("buzzer.wav");
        double[] sample5 = StdAudio.read("cow.wav");

        // StdOut.println("Play sample 1: ");
        StdAudio.play(sample1);


        // StdOut.println("Increse/decrease sample 1 by " + 0.1 + " times: ");
        StdAudio.play(amplify(sample1, 0.1));

        // StdOut.println("Reverse the sample 2:");
        StdAudio.play(reverse(sample2));

        // StdOut.println("Merge sample 3 and sample 4: ");
        StdAudio.play(merge(sample3, sample4));

        // StdOut.println("Mix sample 3 and sample 4: ");
        StdAudio.play(mix(sample3, sample4));

        // StdOut.println("Change speed of sample 5 by " + 1.5 + " times:");
        StdAudio.play(changeSpeed(sample5, 1.5));


    }
}
