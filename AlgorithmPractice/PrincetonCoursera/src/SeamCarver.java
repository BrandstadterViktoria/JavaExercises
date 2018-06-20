import edu.princeton.cs.algs4.Picture;

public class SeamCarver {

    private Picture pictureCopy;
    private int width = width();
    private int height = height();
    private int[][] pixels;

    // create a seam carver object based on the given picture
    public SeamCarver(Picture picture) {
        if (picture == null) {
            throw new IllegalArgumentException("Arg is illegal");
        }
        this.pictureCopy = new Picture(picture);
        pixels = new int[width][height];
        for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++)
                pixels[i][j] = picture.getRGB(i, j);

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
        if (x < 0 || x >= height)
            throw new IllegalArgumentException("column index must be between 0 and " + (height - 1) + ": " + x);
        if (y < 0 || y >= width)
            throw new IllegalArgumentException("row index must be between 0 and " + (width - 1) + ": " + y);

    }

    // sequence of indices for horizontal seam
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

    }
}
