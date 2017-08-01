
public class ReverseString {
    public static void main(String[] args) {
        reverseString(".eslaf eb t'ndluow ecnetnes siht ,dehctiws erew eslaf dna eurt fo sgninaem eht fI");
    }
    static void reverseString (String reversed){
        char [] result;
        for(int i=reversed.length()-1;i>=0;i--) {
            System.out.print(reversed.charAt(i));
        }
    }
}


