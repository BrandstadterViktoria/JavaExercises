
public class Sharpie {
    private String color;
    private float widht;
    private float inkAmount;

    public Sharpie(String color, float widht){
        this.color = color;

        this.widht = widht;
        this.inkAmount = 100;
    }

    public String getColor() {
        return color;
    }

    public float getWidht() {
        return widht;
    }

    public float getInkAmount() {
        return inkAmount;
    }

    public void use(){
        this.inkAmount--;
    }
}


