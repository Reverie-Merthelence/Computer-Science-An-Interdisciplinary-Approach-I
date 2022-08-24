/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import java.util.Arrays;

public class BarChartRacer {
    private static void readText(In datafile, int numDisp) {
        // set canvas
        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();
        // read header from the file and create bar chart
        String title = datafile.readLine();
        String xAxis = datafile.readLine();
        String source = datafile.readLine();
        BarChart chart = new BarChart(title, xAxis, source);

        // read the remaining text file
        while (datafile.hasNextLine()) {
            if (datafile.readLine().equals("")) {

                // create new bar for each group
                int numInGroup = Integer.parseInt(datafile.readLine());
                Bar[] bars = new Bar[numInGroup];

                for (int i = 0; i < numInGroup; i++) {
                    String temp = datafile.readLine(); // read one line at one time
                    int firstComma = temp.indexOf(',');
                    int secondComma = temp.indexOf(',', (firstComma + 1));
                    int thirdComma = temp.indexOf(',', (secondComma + 1));
                    int fourthComma = temp.indexOf(',', (thirdComma + 1));
                    String year = temp.substring(0, firstComma);
                    String name = temp.substring(firstComma + 1, secondComma);
                    int value = Integer.parseInt(temp.substring(thirdComma + 1, fourthComma));
                    String category = temp.substring(fourthComma + 1);

                    // add year to the bar chart
                    chart.setCaption(year);
                    // add name, value, and category to the bar
                    bars[i] = new Bar(name, value, category);
                }
                // sort bars in ascending order by value
                Arrays.sort(bars);

                // put them in chart in reverse order, but display the number of bars according to numDisp
                for (int i = numInGroup - 1; i >= numInGroup - numDisp; i--)
                    chart.add(bars[i].getName(), bars[i].getValue(), bars[i].getCategory());

                // draw the bar chart
                StdDraw.clear();
                chart.draw();
                chart.reset();
                StdDraw.show();
                StdDraw.pause(10);


            }
        }
    }


    public static void main(String[] args) {
        // read file name and number of displayed bar from the command line
        In datafile = new In(args[0]);
        int numDisp = Integer.parseInt(args[1]);
        readText(datafile, numDisp);

    }
}
