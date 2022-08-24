/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class ActivationFunction {
    // Returns the Heaviside function of x.
    public static double heaviside(double x) {
        if (!Double.isNaN(x)) {
            if (x < 0.0)
                return 0.0;
            if (x == 0.0)
                return 0.5;
            else
                return 1.0;
        }
        else
            return Double.NaN;
    }

    // Returns the sigmoid function of x.
    public static double sigmoid(double x) {
        if (!Double.isNaN(x)) {
            return 1 / (1 + Math.pow(Math.E, -x));
        }
        else return Double.NaN;
    }

    // Returns the hyperbolic tangent of x.
    public static double tanh(double x) {
        if (!Double.isNaN(x)) {
            double posusex = Math.pow(Math.E, x);
            double minusex = Math.pow(Math.E, -x);
            if (x >= 20)
                return 1.0;
            else if (x <= -20)
                return -1.0;
            else
                return (posusex - minusex) / (posusex + minusex);
        }
        else return Double.NaN;
    }

    // Returns the softsign function of x.
    public static double softsign(double x) {
        if (!Double.isNaN(x)) {
            if (x == Double.POSITIVE_INFINITY)
                return 1;
            else if (x == Double.NEGATIVE_INFINITY)
                return -1;
            else
                return x / (1 + Math.abs(x));
        }
        else return Double.NaN;
    }

    // Returns the square nonlinearity function of x.
    public static double sqnl(double x) {
        if (!Double.isNaN(x)) {
            if (x <= -2)
                return -1;
            if (x > -2 && x < 0)
                return x + x * x / 4;
            if (x >= 0 && x < 2)
                return x - x * x / 4;
            else
                return 1;
        }
        else return Double.NaN;
    }

    // Takes a double command-line argument x and prints each activation
    // function, evaluated, in the format (and order) given below.
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        StdOut.println("heaviside(" + args[0] + ") = " + ActivationFunction.heaviside(x));
        StdOut.println("sigmoid(" + args[0] + ") = " + ActivationFunction.sigmoid(x));
        StdOut.println("tanh(" + args[0] + ") = " + ActivationFunction.tanh(x));
        StdOut.println("softsign(" + args[0] + ") = " + ActivationFunction.softsign(x));
        StdOut.println("sqnl(" + args[0] + ") = " + ActivationFunction.sqnl(x));


    }
}

