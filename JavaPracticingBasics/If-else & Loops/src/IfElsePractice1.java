import java.util.Scanner;

public class IfElsePractice1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String ans = "";
        if (n % 2 == 1) {
            ans = "Weird";
        } else if (n <= 5 && n >= 2)
            ans = "Not Weird";
        else if (n <= 20 && n >= 6)
            ans = "Weird";
        else if (n > 20)
            ans = "Not Weird";
        {
            System.out.println(ans);
        }
    }
}

