/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class Clock {
    private int hours;
    private int minutes;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        if (h < 0 || h > 23)
            throw new IllegalArgumentException("illegal hours");
        else
            hours = h;
        if (m < 0 || m > 59)
            throw new IllegalArgumentException("illegal minutes");
        else
            minutes = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        // check the overall length of the string first
        if (s.length() != 5)
            throw new IllegalArgumentException("format error");
        else {
            int hTemp = Integer.parseInt(s.substring(0, 2));
            int mTemp = Integer.parseInt(s.substring(3, 5));
            // check whether the third digit is ":", and others
            if (s.charAt(2) != ':' || hTemp < 0 || hTemp > 23 || mTemp < 0
                    || mTemp > 59)
                throw new IllegalArgumentException("format error ");
            else {
                hours = hTemp;
                minutes = mTemp;
            }
        }
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        if (hours < 10 && minutes < 10) // both hours and minutes have only one digit
            return "0" + hours + ":0" + minutes;
        else if (hours < 10) // implicitly means minutes has two digit
            return "0" + hours + ":" + minutes;
        else if (minutes < 10) // implicitly means hours has two digit
            return +hours + ":0" + minutes;
        else
            return hours + ":" + minutes;
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        return hours < that.hours || (hours == that.hours) && (minutes < that.minutes);
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        if (minutes == 59) {
            if (hours == 23) {
                minutes = 0;
                hours = 0;
            }
            else {
                hours++;
                if (hours == 24)
                    hours = 0;
                minutes = 0;
            }
        }
        else minutes++;
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0)
            throw new IllegalArgumentException("delta is negative");
        int hAdded = delta / 60;
        int mAdded = delta % 60;
        // compute min first
        if (minutes + mAdded >= 60) {
            minutes = (minutes + mAdded) % 60;
            hours++;
            if (hours == 24) // check whether hours, after added 1, equals 24
                hours = 0;
        }
        else
            minutes = minutes + mAdded;

        // compute hours
        if (hours + hAdded >= 24)
            hours = (hours + hAdded) % 24;
        else hours = hours + hAdded;
    }

    // Test client (see below).
    public static void main(String[] args) {
        // check input format for the first constructor
        Clock clk1 = new Clock(1, 2);
        StdOut.println(clk1.toString());

        Clock clk2 = new Clock(1, 20);
        StdOut.println(clk2.toString());

        Clock clk3 = new Clock(15, 2);
        StdOut.println(clk3.toString());

        Clock clk4 = new Clock(12, 34);
        StdOut.println(clk4.toString());


        // check earlier method
        StdOut.println(
                "check clk4 is earlier than clk3, should be false " + clk4.isEarlierThan(clk3));

        StdOut.println(
                "check clk1 is earlier than clk2, should be true" + clk1.isEarlierThan(clk2));

        // add one min to clk 3
        clk3.tic();
        StdOut.println(clk3.toString());

        // add one min to clk 4
        clk4.tic();
        StdOut.println(clk4.toString());

        // add an arbitrary time to clk 4
        clk4.toc(-5);
        StdOut.println(clk4.toString());

        // check input format for the second constructor
        Clock clk5 = new Clock("05:02");
        StdOut.println(clk5.toString());

        Clock clk6 = new Clock("05:20");
        StdOut.println(clk6.toString());

    }
}
