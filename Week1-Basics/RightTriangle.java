/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class RightTriangle {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        System.out.println(
                (a > 0 && b > 0 && c > 0) && (a * a == (b * b + c * c) || b * b == (a * a + c * c)
                        || c * c == (a * a + b * b)));
    }

}
