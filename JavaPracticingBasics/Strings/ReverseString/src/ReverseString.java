
public class ReverseString {
    public static void main(String[] args) {

       reverseString(".eslaf eb t'ndluow ecnetnes siht ,dehctiws erew eslaf dna eurt fo sgninaem eht" + " fI");

    }
    static String reverseString (String s){
        String reversed = "";
        for(int i = s.length() - 1; i >= 0; i--) {
            reversed = String.valueOf(s.charAt(i));
            System.out.print(reversed);
        }
        return reversed;
    }
}


