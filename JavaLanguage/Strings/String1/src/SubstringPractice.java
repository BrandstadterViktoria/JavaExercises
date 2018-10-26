
import java.util.*;

public class SubstringPractice {

    public static void main(String[] args) {
        System.out.println("Give me what I want");
        Scanner in = new Scanner(System.in);
        String S = in.next();
        int start = in.nextInt();
        int end = in.nextInt();
        System.out.println(S.substring(start, end));

    }
}
