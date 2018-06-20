import edu.princeton.cs.algs4.Picture;

public class SeamCarver {

    private Picture pictureCopy;
    
    // create a seam carver object based on the given picture
    public SeamCarver(Picture picture) {
        this.pictureCopy = picture;
    }

    // current picture
    public Picture picture() {
        return pictureCopy;
    }

    // width of current picture
    public     int width() {
        return pictureCopy.width();

    }

    // height of current picture
    public     int height() {
        return pictureCopy.height();

    }

    // energy of pixel at column x and row y
    public  double energy(int x, int y) {

    }

    // sequence of indices for horizontal seam
    public   int[] findHorizontalSeam() {

    }

    // sequence of indices for vertical seam
    public   int[] findVerticalSeam()  {

    }

    // remove horizontal seam from current picture
    public    void removeHorizontalSeam(int[] seam)  {

    }

    // remove vertical seam from current picture
    public    void removeVerticalSeam(int[] seam)   {

    }
}
