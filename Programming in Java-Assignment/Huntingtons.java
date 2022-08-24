/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class Huntingtons {
    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        int count = 0;
        int maxcount = 0;
        for (int i = 0; i <= dna.length() - 3; i++) {
            if (dna.substring(i, i + 3).equals("CAG")) { // if we find the first CAG:
                count++; // take the first CAG into account
                while (i + 6 <= dna.length() && dna.substring(i + 3, i + 6).equals("CAG")) {
                    count++;
                    i += 3;
                }
                if (count > maxcount)
                    maxcount = count;
                count = 0; // the consecutive CAG ends, set count=0

            }
        }
        return maxcount;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        String spaceRemoved = s
                .replace(" ", ""); // even if no whitespace, s.replace will still return the string
        spaceRemoved = spaceRemoved.replace("\n", "");
        spaceRemoved = spaceRemoved.replace("\t", "");
        return spaceRemoved;
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        if (maxRepeats >= 0 && maxRepeats <= 9)
            return "not human";
        if (maxRepeats >= 10 && maxRepeats <= 35)
            return "normal";
        if (maxRepeats >= 36 && maxRepeats <= 39)
            return "high risk";
        if (maxRepeats >= 40 && maxRepeats <= 180)
            return "Huntington’s";
        else return "not human";
    }

    // Sample client (see below).
    public static void main(String[] args) {
        In datafile = new In(args[0]);
        String temp = datafile.readAll();
        String s = removeWhitespace(temp);
        StdOut.println("max repeats = " + maxRepeats(s));
        StdOut.println(diagnose(maxRepeats(s)));
    }
}
