
public class ReverseString {
    public static void main(String[] args) {

        String result = reverseString(".eslaf eb t'ndluow ecnetnes siht ,dehctiws erew eslaf dna eurt fo sgninaem eht" +
                " fI");
        System.out.println(result);
    }
    static String reverseString (String s){
        String reversed = "";
        for(int i = s.length() - 1; i >= 0; i--) {
            reversed = String.valueOf(s.charAt(i));
        }
        return reversed;
    }
}


