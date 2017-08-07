
public class Cuboid {
    private int firstSide;
    private int secondSide;
    private int thirdSide;
    private int surface;
    private int volume;

    public Cuboid (int firstSide, int secondSide, int thirdSide){
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
    }

    public int getSurface (){
        int surface;
        surface = 2 *(firstSide * secondSide + secondSide * thirdSide + thirdSide * firstSide);
        return surface;
    }

    public int getVolume (){
        int volume;
        volume = firstSide * secondSide * thirdSide;
        this.volume = volume;
        return volume;
    }


}
