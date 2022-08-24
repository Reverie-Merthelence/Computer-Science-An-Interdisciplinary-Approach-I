/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class WorldMap {
    public static void main(String[] args) {
        int width = StdIn.readInt();
        int height = StdIn.readInt();
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);

        while (!StdIn.isEmpty()) {
            String name = StdIn.readString();
            int vertices = StdIn.readInt();
            double[] polyX = new double[vertices]; // store the X coordinates
            double[] polyY = new double[vertices]; // store the Y coordinates
            for (int i = 0; i < vertices; i++) {
                double x = StdIn.readDouble();
                polyX[i] = x;
                double y = StdIn.readDouble();
                polyY[i] = y;
            }
            StdDraw.polygon(polyX, polyY);
        }
    }

}
