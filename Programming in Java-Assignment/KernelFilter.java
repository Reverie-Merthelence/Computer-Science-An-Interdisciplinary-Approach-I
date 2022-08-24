/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import java.awt.Color;

public class KernelFilter {
    // make sure that the processed RGB is within [0,255]
    private static double checkColorRange(double color) {
        if (color > 255)
            return 255;
        if (color < 0)
            return 0;
        else return color;
    }

    // Returns a new picture that applies the identity filter to the given picture.
    public static Picture identity(Picture picture) {
        // create target picture
        int width = picture.width();
        int height = picture.height();
        Picture target = new Picture(width, height);

        // create color filter - Identity
        int filterLength = 3;
        int[][] filter = new int[filterLength][filterLength];
        filter[1][1] = 1;

        // compute RGB value of each pixel in the target picture
        for (int col = 0; col < width; col++) { // scan each pixel in the picture
            for (int row = 0; row < height; row++) {
                double processedR = 0.0;
                double processedG = 0.0;
                double processedB = 0.0;
                for (int i = 0; i < filterLength; i++) {
                    for (int j = 0; j < filterLength; j++) { // for each element in the filter
                        Color pxUsed
                                = picture // (width+n)%width ensures wrapping; while col - filterLength / 2 + j ensures mapping
                                          .get((width + col - filterLength / 2 + j) % width,
                                               (height + row - filterLength / 2 + i) % height);
                        processedR += pxUsed.getRed() * filter[i][j];
                        processedG += pxUsed.getGreen() * filter[i][j];
                        processedB += pxUsed.getBlue() * filter[i][j];
                    }
                }

                // check RGB is within the range [0,255]
                processedR = checkColorRange(processedR);
                processedG = checkColorRange(processedG);
                processedB = checkColorRange(processedB);

                // generate a new color and put it into the corresponding col and row of the target picture
                // round each processed RGB value up, and cast them into integer
                Color processed = new Color((int) Math.round(processedR),
                                            (int) Math.round(processedG),
                                            (int) Math.round(processedB));
                target.set(col, row, processed);
            }
        }
        return target;
    }


    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        // create target picture
        int width = picture.width();
        int height = picture.height();
        Picture target = new Picture(width, height);

        // create color filter - Gaussian
        int filterLength = 3;
        double[][] filter = {
                { 1 / 16.0, 2 / 16.0, 1 / 16.0 }, { 2 / 16.0, 4 / 16.0, 2 / 16.0 },
                { 1 / 16.0, 2 / 16.0, 1 / 16.0 }
        };


        // compute RGB value of each pixel in the target picture
        for (int col = 0; col < width; col++) { // scan each pixel in the picture
            for (int row = 0; row < height; row++) {
                double processedR = 0;
                double processedG = 0;
                double processedB = 0;
                for (int i = 0; i < filterLength; i++) {
                    for (int j = 0; j < filterLength; j++) { // for each element in the filter
                        Color pxUsed
                                = picture // (width+n)%100 ensures wrapping; col - filterLength / 2 + j ensures mapping
                                          .get((width + col - filterLength / 2 + j) % width,
                                               (height + row - filterLength / 2 + i) % height);
                        processedR += pxUsed.getRed() * filter[i][j];
                        processedG += pxUsed.getGreen() * filter[i][j];
                        processedB += pxUsed.getBlue() * filter[i][j];
                    }
                }

                // check RGB is within the range [0,255]
                processedR = checkColorRange(processedR);
                processedG = checkColorRange(processedG);
                processedB = checkColorRange(processedB);

                // generate a new color and put it into the corresponding col and row of the target picture
                // round each processed RGB value up, and cast them into integer
                Color processed = new Color((int) Math.round(processedR),
                                            (int) Math.round(processedG),
                                            (int) Math.round(processedB));
                target.set(col, row, processed);
            }
        }
        return target;
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        // create target picture
        int width = picture.width();
        int height = picture.height();
        Picture target = new Picture(width, height);

        // create color filter - Gaussian
        int filterLength = 3;
        double[][] filter = { { 0, -1, 0 }, { -1, 5, -1 }, { 0, -1, 0 } };


        // compute RGB value of each pixel in the target picture
        for (int col = 0; col < width; col++) { // scan each pixel in the picture
            for (int row = 0; row < height; row++) {
                double processedR = 0;
                double processedG = 0;
                double processedB = 0;
                for (int i = 0; i < filterLength; i++) {
                    for (int j = 0; j < filterLength; j++) { // for each element in the filter
                        Color pxUsed
                                = picture // (width+n)%100 ensures wrapping; col - filterLength / 2 + j ensures mapping
                                          .get((width + col - filterLength / 2 + j) % width,
                                               (height + row - filterLength / 2 + i) % height);
                        processedR += pxUsed.getRed() * filter[i][j];
                        processedG += pxUsed.getGreen() * filter[i][j];
                        processedB += pxUsed.getBlue() * filter[i][j];
                    }
                }

                // check RGB is within the range [0,255]
                processedR = checkColorRange(processedR);
                processedG = checkColorRange(processedG);
                processedB = checkColorRange(processedB);

                // generate a new color and put it into the corresponding col and row of the target picture
                // round each processed RGB value up, and cast them into integer
                Color processed = new Color((int) Math.round(processedR),
                                            (int) Math.round(processedG),
                                            (int) Math.round(processedB));
                target.set(col, row, processed);
            }
        }
        return target;
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        // create target picture
        int width = picture.width();
        int height = picture.height();
        Picture target = new Picture(width, height);

        // create color filter - laplacian
        int filterLength = 3;
        double[][] filter = { { -1, -1, -1 }, { -1, 8, -1 }, { -1, -1, -1 } };


        // compute RGB value of each pixel in the target picture
        for (int col = 0; col < width; col++) { // scan each pixel in the picture
            for (int row = 0; row < height; row++) {
                double processedR = 0;
                double processedG = 0;
                double processedB = 0;
                for (int i = 0; i < filterLength; i++) {
                    for (int j = 0; j < filterLength; j++) { // for each element in the filter
                        Color pxUsed
                                = picture // (width+n)%100 ensures wrapping; col - filterLength / 2 + j ensures mapping
                                          .get((width + col - filterLength / 2 + j) % width,
                                               (height + row - filterLength / 2 + i) % height);
                        processedR += pxUsed.getRed() * filter[i][j];
                        processedG += pxUsed.getGreen() * filter[i][j];
                        processedB += pxUsed.getBlue() * filter[i][j];
                    }
                }

                // check RGB is within the range [0,255]
                processedR = checkColorRange(processedR);
                processedG = checkColorRange(processedG);
                processedB = checkColorRange(processedB);

                // generate a new color and put it into the corresponding col and row of the target picture
                // round each processed RGB value up, and cast them into integer
                Color processed = new Color((int) Math.round(processedR),
                                            (int) Math.round(processedG),
                                            (int) Math.round(processedB));
                target.set(col, row, processed);
            }
        }
        return target;
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        // create target picture
        int width = picture.width();
        int height = picture.height();
        Picture target = new Picture(width, height);

        // create color filter - emboss
        int filterLength = 3;
        double[][] filter = { { -2, -1, 0 }, { -1, 1, 1 }, { 0, 1, 2 } };


        // compute RGB value of each pixel in the target picture
        for (int col = 0; col < width; col++) { // scan each pixel in the picture
            for (int row = 0; row < height; row++) {
                double processedR = 0;
                double processedG = 0;
                double processedB = 0;
                for (int i = 0; i < filterLength; i++) {
                    for (int j = 0; j < filterLength; j++) { // for each element in the filter
                        Color pxUsed
                                = picture // (width+n)%100 ensures wrapping; col - filterLength / 2 + j ensures mapping
                                          .get((width + col - filterLength / 2 + j) % width,
                                               (height + row - filterLength / 2 + i) % height);
                        processedR += pxUsed.getRed() * filter[i][j];
                        processedG += pxUsed.getGreen() * filter[i][j];
                        processedB += pxUsed.getBlue() * filter[i][j];
                    }
                }

                // check RGB is within the range [0,255]
                processedR = checkColorRange(processedR);
                processedG = checkColorRange(processedG);
                processedB = checkColorRange(processedB);

                // generate a new color and put it into the corresponding col and row of the target picture
                // round each processed RGB value up, and cast them into integer
                Color processed = new Color((int) Math.round(processedR),
                                            (int) Math.round(processedG),
                                            (int) Math.round(processedB));
                target.set(col, row, processed);
            }
        }
        return target;
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        // create target picture
        int width = picture.width();
        int height = picture.height();
        Picture target = new Picture(width, height);

        // create color filter - Motion Blur
        int filterLength = 9;
        double[][] filter = new double[filterLength][filterLength];
        for (int i = 0; i < filterLength; i++)
            filter[i][i] = 1 / 9.0;


        // compute RGB value of each pixel in the target picture

        for (int col = 0; col < width; col++) { // scan each pixel in the picture
            for (int row = 0; row < height; row++) {
                double processedR = 0;
                double processedG = 0;
                double processedB = 0;
                for (int i = 0; i < filterLength; i++) {
                    for (int j = 0; j < filterLength; j++) { // for each element in the filter
                        Color pxUsed
                                = picture // (width+n)%100 ensures wrapping; col - filterLength / 2 + j ensures mapping
                                          .get((width + col - filterLength / 2 + j) % width,
                                               (height + row - filterLength / 2 + i) % height);
                        processedR += pxUsed.getRed() * filter[i][j];
                        processedG += pxUsed.getGreen() * filter[i][j];
                        processedB += pxUsed.getBlue() * filter[i][j];
                    }
                }

                // check RGB is within the range [0,255]
                processedR = checkColorRange(processedR);
                processedG = checkColorRange(processedG);
                processedB = checkColorRange(processedB);

                // generate a new color and put it into the corresponding col and row of the target picture
                // round each processed RGB value up, and cast them into integer
                Color processed = new Color((int) Math.round(processedR),
                                            (int) Math.round(processedG),
                                            (int) Math.round(processedB));
                target.set(col, row, processed);
            }
        }
        return target;
    }


    // Test client (ungraded).
    public static void main(String[] args) {
        Picture source = new Picture("baboon.png");
        identity(source);
        gaussian(source);
        sharpen(source);
        laplacian(source);
        emboss(source);
        motionBlur(source);

    }
}
