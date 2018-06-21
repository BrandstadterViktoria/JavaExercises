import edu.princeton.cs.algs4.Picture;
import edu.princeton.cs.algs4.StdOut;
public class SeamCarver {

    private Picture pictureCopy;

    // create a seam carver object based on the given picture
    public SeamCarver(Picture picture) {
        if (picture == null) {
            throw new IllegalArgumentException("Arg is illegal");
        }
        this.pictureCopy = new Picture(picture);

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
        if (x == 0 || y == 0 || x == width() - 1 || y == height() - 1) {
            return 1000;
        } else {
            return Math.sqrt((double) yieldingX2(x, y) + yieldingY2(x, y));
        }
    }

  /*// sequence of indices for horizontal seam
    public int[] findHorizontalSeam() {

    }
*/
    // sequence of indices for vertical seam
    public int[] findVerticalSeam() {
        int [] [] energy = new int[height()][width()];
        for (int row = 0; row < height(); row++) {
            for (int col = 0; col < width(); col++) {
                energy[row][col] = (int) energy(col, row);
            }
        }
        int [] indices = new int[height()];
        int ind = 1;
        int currentCol = 3;
        indices[0] = currentCol;
        int currentRow = 0;
        while (currentRow < height()-1) {
            if (currentRow == height() -2) {
                indices[ind] = currentCol;
            } else {
                int dist = Math.min((Math.min(energy[currentRow + 1][currentCol - 1], energy[currentRow + 1][currentCol])),
                        energy[currentRow + 1][currentCol + 1]);
                currentCol = dist == energy[currentRow + 1][currentCol - 1] ? currentCol - 1 :
                        (dist == energy[currentRow + 1][currentCol] ? currentCol : currentCol + 1);
            }
         currentRow++;
         indices[ind] = currentCol;
         ind++;
        }

        for (int i = 0; i < indices.length; i++) {
            System.out.println(indices[i]);
        }

        return indices;
    }

    /*// remove horizontal seam from current picture
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

    // remove vertical seam from current picture
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
        int rgbRight = pictureCopy.getRGB(x + 1, y);
        int rgbLeft = pictureCopy.getRGB(x - 1, y);
        int red = (rgbRight >> 16) & 0xFF;
        int green = (rgbRight >> 8) & 0xFF;
        int blue = (rgbRight) & 0xFF;
        int redL = (rgbLeft >> 16) & 0xFF;
        int greenL = (rgbLeft >> 8) & 0xFF;
        int blueL = (rgbLeft) & 0xFF;
        return (red - redL) * (red - redL) + (green - greenL) * (green - greenL)
                + (blue - blueL) * (blue - blueL);
    }


    private int yieldingY2(int x, int y) {
        int rgbDown = pictureCopy.getRGB(x, y + 1);
        int rgbUp = pictureCopy.getRGB(x, y - 1);
        int red = (rgbDown >> 16) & 0xFF;
        int green = (rgbDown >> 8) & 0xFF;
        int blue = (rgbDown) & 0xFF;
        int redU = (rgbUp >> 16) & 0xFF;
        int greenU = (rgbUp >> 8) & 0xFF;
        int blueU = (rgbUp) & 0xFF;
        return (red - redU) * (red - redU) + (green - greenU) * (green - greenU)
                + (blue - blueU) * (blue - blueU);
    }


    public static void main(String[] args) {
        Picture picture = new Picture(args[0]);
        StdOut.printf("image is %d pixels wide by %d pixels high.\n", picture.width(), picture.height());

        SeamCarver sc = new SeamCarver(picture);

        StdOut.printf("Printing energy calculated for each pixel.\n");

       /* for (int row = 0; row < sc.height(); row++) {
            for (int col = 0; col < sc.width(); col++)
                StdOut.printf("%9.0f ", sc.energy(col, row));
            StdOut.println();
        }*/
       sc.findVerticalSeam();
    }
}
