package Part_II.Week2_SeamCarving;

import edu.princeton.cs.algs4.Picture;
import edu.princeton.cs.algs4.StdOut;

public class SeamCarver {

    private Picture pictureCopy;
    private int[][] energies;

    // create a seam carver object based on the given picture
    public SeamCarver(Picture picture) {
        if (picture == null) {
            throw new IllegalArgumentException("Arg is illegal");
        }
        this.pictureCopy = new Picture(picture);
        energies = createEnergieGrid();
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

    // sequence of indices for horizontal seam
    public int[] findHorizontalSeam() {
        int[] indices = new int[width()];
        int firstColSmallest = Integer.MAX_VALUE;
        int currentCol = 0;
        int currentRow = 0;
        int[][] energy = new int[height()][width()];
        for (int row = 0; row < height(); row++) {
            for (int col = 0; col < width(); col++) {
                energy[row][col] = energies[row][col];
                if (col == 1 && firstColSmallest > energy[row][col]) {
                    firstColSmallest = energy[row][col];
                    currentCol = col;
                    currentRow = row;
                }
            }
        }

        int ind = 2;
        indices[0] = currentRow;
        indices[1] = currentRow;
        while (currentCol < width() - 1) {
            if (currentCol == width() - 2) {
                indices[ind] = currentCol;
            } else {
                int dist1 = isValidPixel(energy, currentRow + 1, currentCol + 1) ? energy[currentRow + 1][currentCol + 1] : Integer.MAX_VALUE;
                int dist2 = isValidPixel(energy, currentRow, currentCol + 1) ? energy[currentRow][currentCol + 1] : Integer.MAX_VALUE;
                int dist3 = isValidPixel(energy, currentRow - 1, currentCol + 1) ? energy[currentRow - 1][currentCol + 1] : Integer.MAX_VALUE;
                int dist = Math.min((Math.min(dist1, dist2)), dist3);

                if (isValidPixel(energy, currentRow + 1, currentCol + 1) && dist == dist1) {
                    currentRow = currentRow + 1;
                }
                if (isValidPixel(energy, currentRow - 1, currentCol + 1) && dist == dist2) {
                    currentRow = currentRow - 1;
                }
            }
            currentCol++;
            indices[ind] = currentRow;
            ind++;
        }

        for (int i = 0; i < indices.length; i++) {
            System.out.println(indices[i]);
        }

        return indices;
    }

    // sequence of indices for vertical seam
    public int[] findVerticalSeam() {
        int[] indices = new int[height()];
        int firstRowSmallest = Integer.MAX_VALUE;
        int currentCol = 0;
        int currentRow = 0;
        int[][] energy = new int[height()][width()];
        for (int row = 0; row < height(); row++) {
            for (int col = 0; col < width(); col++) {
                energy[row][col] = energies[row][col];
                if (row == 1 && firstRowSmallest > energy[row][col]) {
                    firstRowSmallest = energy[row][col];
                    currentCol = col;
                    currentRow = row;
                }
            }
        }

        int ind = 2;
        indices[0] = currentCol;
        indices[1] = currentCol;
        while (currentRow < height() - 1) {
            if (currentRow == height() - 2) {
                indices[ind] = currentCol;
            } else {
                int dist1 = isValidPixel(energy, currentRow + 1, currentCol - 1) ? energy[currentRow + 1][currentCol - 1] : Integer.MAX_VALUE;
                int dist2 = isValidPixel(energy, currentRow + 1, currentCol) ? energy[currentRow + 1][currentCol] : Integer.MAX_VALUE;
                int dist3 = isValidPixel(energy, currentRow + 1, currentCol + 1) ? energy[currentRow + 1][currentCol + 1] : Integer.MAX_VALUE;
                int dist = Math.min((Math.min(dist1, dist2)), dist3);
                if (isValidPixel(energy, currentRow + 1, currentCol - 1) && dist == dist1) {
                    currentCol = currentCol - 1;
                }
                if (isValidPixel(energy, currentRow + 1, currentCol + 1) && dist == dist3) {
                    currentCol = currentCol + 1;
                }

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

    // remove horizontal seam from current picture
    public void removeHorizontalSeam(int[] seam) {
        if (pictureCopy.height() < 1) {
            throw new IllegalArgumentException("Impossible task picture height is is less than or equal to 1.");
        }
        if (seam == null || seam.length != pictureCopy.height()) {
            throw new IllegalArgumentException("Given seam isn't in the prescribed range.");
        }
        for (int i = 0; i < seam.length; i++) {
            if (i > 0 && Math.abs(seam[i] - seam[i - 1]) != 1) {
                throw new IllegalArgumentException("Given seam is doesn't decrease by 1.");
            }
            if (seam[i] < 0 || seam[i] >= pictureCopy.height()) {
                throw new IllegalArgumentException();
            }
        }

        int[][] energieRemoveH = new int[pictureCopy.height() - 1][pictureCopy.width()];
        Picture removeHPicture = new Picture(pictureCopy.width(), pictureCopy.height() - 1);
        int index = 0;
        for (int col = 0; col < width(); col++) {
            for (int row = 0; row < height(); row++) {
                if (seam[index] == index) {
                    index++;
                }
                energieRemoveH[row][col] = energieRemoveH[index][col];
                removeHPicture.setRGB(col, row, pictureCopy.getRGB(col, index++));
            }
        }

        pictureCopy = removeHPicture;

        for (int i = 0; i < energieRemoveH[0].length; i++) {
            if (seam[i] > 0) {
                energieRemoveH[seam[i] - 1][i] = (int) energy(i, seam[i] - 1);
            }
            energieRemoveH[seam[i]][i] = (int) energy(i, seam[i]);
        }

        energies = energieRemoveH;
    }

    // remove vertical seam from current picture

    public void removeVerticalSeam(int[] seam) {
        if (pictureCopy.width() < 1) {
            throw new IllegalArgumentException("Impossible task picture width is is less than or equal to 1.");
        }
        if (seam == null || seam.length != pictureCopy.width()) {
            throw new IllegalArgumentException("Given seam isn't in the prescribed range.");
        }
        for (int i = 0; i < seam.length; i++) {
            if (i > 0 && seam[i] - seam[i - 1] != 1) {
                throw new IllegalArgumentException("Given seam is doesn't decrease by 1.");
            }
            if (seam[i] < 0 || seam[i] >= pictureCopy.width()) {
                throw new IllegalArgumentException();
            }
        }

        int[][] energieRemoveV = new int[pictureCopy.height()][pictureCopy.width() - 1];
        Picture removeVPicture = new Picture(pictureCopy.width() - 1, pictureCopy.height());
        int index = 0;
        for (int row = 0; row < height(); row++) {
            for (int col = 0; col < width() - 1; col++) {
                if (seam[index] == index) {
                    index++;
                }
                energieRemoveV[row][col] = energieRemoveV[row][index];
                removeVPicture.setRGB(col, row, pictureCopy.getRGB(index++, row));
            }
        }

        for (int i = 0; i < energieRemoveV.length; i++) {
            if (seam[i] > 0) {
                energieRemoveV[i][seam[i] - 1] = (int) energy(seam[i] - 1, i);
            }
            energieRemoveV[i][seam[i]] = (int) energy(seam[i], i);
        }

        energies = energieRemoveV;
    }

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

    private boolean isValidPixel(int[][] matrix, int x, int y) {
        return !(x < 0 || x >= matrix.length || y < 0 || y >= matrix.length) && (matrix[x][y] != '0');
    }

    private int[][] createEnergieGrid() {
        int[][] energy = new int[height()][width()];
        for (int row = 0; row < height(); row++) {
            for (int col = 0; col < width(); col++) {
                energy[row][col] = (int) energy(col, row);
            }

        }
        return energy;
    }


    public static void main(String[] args) {
        Picture picture = new Picture(args[0]);
        StdOut.printf("image is %d pixels wide by %d pixels high.\n", picture.width(), picture.height());

        SeamCarver sc = new SeamCarver(picture);

        // StdOut.printf("Printing energy calculated for each pixel.\n");

       /* for (int row = 0; row < sc.height(); row++) {
            for (int col = 0; col < sc.width(); col++)
                StdOut.printf("%9.0f ", sc.energy(col, row));
            StdOut.println();
        }*/
        sc.findHorizontalSeam();
    }
}
