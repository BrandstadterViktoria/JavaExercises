
public class ReverseString {
    public static void main(String[] args) {

       reverseString(".eslaf eb t'ndluow ecnetnes siht ,dehctiws erew eslaf dna eurt fo sgninaem eht" + " fI");

    }
    static String reverseString (String s){
        if (s.length() < = 1){
            return s;
        }else{

        return reverseString(s.substring(1, s.legth ))) + s.charAt(0);
    }
}


