
public class SearchAlgortihms {

    public static void main(String[] args) {

        int [] intArray = {20, 35, -15, 7, 55, 1, -22};
        System.out.println(linearSearch(intArray, 55));
    }

    public static int linearSearch(int [] input, int value){
        for (int i = 0; i < input.length -1; i++) {
            if(input[i] == value){
                return i;
            }
        }
        return -1;
    }
}
