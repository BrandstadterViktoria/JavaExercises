import edu.princeton.cs.algs4.Picture;
import edu.princeton.cs.algs4.StdOut;


public class SeamCarver {
    private Picture pictureCopy;
    //private int[][] pixelsRGB;

    // create a seam carver object based on the given picture
    public SeamCarver(Picture picture) {
        if (picture == null) {
            throw new IllegalArgumentException("Arg is illegal");
        }
        this.pictureCopy = new Picture(picture);
     /*   pixelsRGB = new int[width][height];
        for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++)
                pixelsRGB[i][j] = picture.getRGB(i, j);
*/
    }

    // current picture
    public Picture picture() {
        return pictureCopy;
    }

    // width of current picture
    public int width() {
        return pictureCopy.width();

    }

    // height of current picture
    public int height() {
        return pictureCopy.height();

    }

    // energy of pixel at column x and row y
    public double energy(int x, int y) {
        if (x < 0 || x >= width())
            throw new IllegalArgumentException("column index must be between 0 and " + (width() - 1) + ": " + x);
        if (y < 0 || y >= height())
            throw new IllegalArgumentException("row index must be between 0 and " + (height() - 1) + ": " + y);

        return Math.sqrt(yieldingX2(x, y) + yieldingY2(x, y));
    }

   /* // sequence of indices for horizontal seam
    public int[] findHorizontalSeam() {

    }

    // sequence of indices for vertical seam
    public int[] findVerticalSeam() {

    }

    // remove horizontal seam from current picture
    public void removeHorizontalSeam(int[] seam) {
        if (height < 1) {
            throw new IllegalArgumentException("Impossible task picture height is is less than or equal to 1.");
        }
        if (seam.length != height) {
            throw new IllegalArgumentException("Given seam isn't in the prescribed range.");
        }
        for (int i = 0; i < seam.length; i++) {
            if (i < 0 && seam[i] - seam[i - 1] != 1) {
                throw new IllegalArgumentException("Given seam is doestn decrease by 1.");
            }
        }
    }
*/
    /*// remove vertical seam from current picture
    public void removeVerticalSeam(int[] seam) {
        if (width < 1) {
            throw new IllegalArgumentException("Impossible task picture width is is less than or equal to 1.");
        }
        if (seam.length != width) {
            throw new IllegalArgumentException("Given seam isn't in the prescribed range.");
        }
        for (int i = 0; i < seam.length; i++) {
            if (i < 0 && seam[i] - seam[i - 1] != 1) {
                throw new IllegalArgumentException("Given seam is doestn decrease by 1.");
            }
        }

    }*/

    private int yieldingX2(int x, int y) {
        if (x == 0) {
            int rgbRight = pictureCopy.getRGB(x + 1, y);
            return (rgbRight >> 16) & 0x000000FF * (rgbRight >> 16) & 0x000000FF
                    + (rgbRight >> 8) & 0x000000FF * (rgbRight >> 8) & 0x000000FF
                    + (rgbRight) & 0x000000FF * (rgbRight) & 0x000000FF;
        }

        if (x == width() - 1) {
            int rgbLeft = pictureCopy.getRGB(x - 1, y);
            return (rgbLeft >> 16) & 0x000000FF * (rgbLeft >> 16) & 0x000000FF
                    + (rgbLeft >> 8) & 0x000000FF * (rgbLeft >> 8) & 0x000000FF
                    + (rgbLeft) & 0x000000FF * (rgbLeft) & 0x000000FF;
        } else {
            int rgbRight = pictureCopy.getRGB(x + 1, y);
            int rgbLeft = pictureCopy.getRGB(x - 1, y);
            int red = (rgbRight >> 16) & 0x000000FF - (rgbLeft >> 16) & 0x000000FF;
            int green = (rgbRight >> 8) & 0x000000FF - (rgbLeft >> 8) & 0x000000FF;
            int blue = (rgbRight) & 0x000000FF - (rgbLeft) & 0x000000FF;
            return red * red + green * green + blue * blue;

        }
    }

    private int yieldingY2(int x, int y) {
        if (y == 0) {
            int rgbDown = pictureCopy.getRGB(x, y + 1);
            return (rgbDown >> 16) & 0x000000FF * (rgbDown >> 16) & 0x000000FF
                    + (rgbDown >> 8) & 0x000000FF * (rgbDown >> 8) & 0x000000FF
                    + (rgbDown) & 0x000000FF * (rgbDown) & 0x000000FF;

        }
        if (y == height() - 1) {
            int rgbUp = pictureCopy.getRGB(x, y - 1);
            return (rgbUp >> 16) & 0x000000FF * (rgbUp >> 16) & 0x000000FF
                    + (rgbUp >> 8) & 0x000000FF * (rgbUp >> 8) & 0x000000FF
                    + (rgbUp) & 0x000000FF * (rgbUp) & 0x000000FF;
        } else {
            int rgbUp = pictureCopy.getRGB(x, y - 1);
            int rgbDown = pictureCopy.getRGB(x, y + 1);
            int red = (rgbDown >> 16) & 0x000000FF - (rgbUp >> 16) & 0x000000FF;
            int green = (rgbDown >> 8) & 0x000000FF - (rgbUp >> 8) & 0x000000FF;
            int blue = (rgbDown) & 0x000000FF - (rgbUp) & 0x000000FF;
            return red * red + green * green + blue * blue;
        }
    }

    public static void main(String[] args) {
        Picture picture = new Picture(args[0]);
        StdOut.printf("image is %d pixels wide by %d pixels high.\n", picture.width(), picture.height());

        SeamCarver sc = new SeamCarver(picture);

        StdOut.printf("Printing energy calculated for each pixel.\n");

        for (int row = 0; row < sc.height(); row++) {
            for (int col = 0; col < sc.width(); col++)
                StdOut.printf("%9.0f ", sc.energy(col, row));
            StdOut.println();
        }
    }
}
