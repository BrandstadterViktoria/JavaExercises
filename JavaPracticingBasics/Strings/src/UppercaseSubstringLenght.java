
import java.util.Scanner;

public class UppercaseSubstringLenght {
    public static void main(String[] args) {
        System.out.println("Type me strings");
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine();
        String B = sc.nextLine();
        int lenght = A.length() + B.length();
        char[] chars = {Character.toUpperCase(A.charAt(0)),
                Character.toUpperCase(B.charAt(0))};
        String a1 = chars[0] + A.substring(1);
        String b1 = chars[1] + B.substring(1);
        System.out.println(lenght);
        if  (A.compareTo(B) > B.compareTo(A)){
            System.out.println("Yes");
        }
        else System.out.println("NO");
        System.out.println(a1 + " " + b1);
    }
}



