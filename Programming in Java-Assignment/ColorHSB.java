/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class ColorHSB {
    private int hue;
    private int saturation;
    private int brightness;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        if (h < 0 || h > 359)
            throw new IllegalArgumentException("hue is out of the boundary");
        else
            hue = h;

        if (s < 0 || s > 100)
            throw new IllegalArgumentException("saturation is out of the boundary");
        else
            saturation = s;

        if (b < 0 || b > 100)
            throw new IllegalArgumentException("brightness is out of the boundary");
        else
            brightness = b;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return "(" + hue + ", " + saturation + ", " + brightness + ")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        return (saturation == 0 || brightness == 0);
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        if (that == null)
            throw new IllegalArgumentException("argument is null");
        return (Math.min((hue - that.hue) * (hue - that.hue),
                         (360 - Math.abs(hue - that.hue)) * (360 - Math.abs(hue - that.hue)))
                + (saturation - that.saturation) * (saturation - that.saturation)
                + (brightness - that.brightness) * (brightness - that.brightness));
    }

    // Sample client (see below).
    public static void main(String[] args) {
        // create source HSB from command-line arguments
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        ColorHSB source = new ColorHSB(h, s, b);

        // create minDistance, nearestColorName, and ColorHSB instance "min" to store the most close ColorHSB
        int minDistance = Integer.MAX_VALUE;
        String nearestColorName = "";
        int hMin = 0;
        int sMin = 0;
        int bMin = 0;
        ColorHSB min = new ColorHSB(hMin, sMin, bMin);
        // read each line from the text
        while (!StdIn.isEmpty()) {
            String colorName = StdIn.readString();
            int hCompare = StdIn.readInt();
            int sCompare = StdIn.readInt();
            int bCompare = StdIn.readInt();
            ColorHSB compare = new ColorHSB(hCompare, sCompare, bCompare);
            if (source.distanceSquaredTo(compare) < minDistance) {
                //StdOut.println("in if judgment now" + hCompare + " " + sCompare + " " + bCompare);
                minDistance = source.distanceSquaredTo(compare);
                nearestColorName = colorName;
                min = compare;
            }
        }
        StdOut.println(nearestColorName + " " + min.toString());
    }
}
