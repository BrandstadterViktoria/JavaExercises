package MyCreditCard;

import java.util.Random;
import java.util.stream.IntStream;

public class CreditCard implements CreditCardy {
    private Random r = new Random();
    private String name;
    private int SumCVV;
    private String codeAccount;
    String CVV;

    public CreditCard() {



    }

    @Override
    public int getSumCVV() {
        return SumCVV;
    }

    @Override
    public String getNameCardholder() {
        char[] charname = {'B', 'R', 'A', 'N', 'D', 'S', 'T', 'A', 'D', 'T', 'E', 'R', 'V', 'I', 'K', 'T', 'O', 'R', 'I', 'A'};
        char[] result = new char[30];
        for (int i = 0; i <result.length; i++) {
            result[i] = charname[r.nextInt(charname.length)];
        }
        String name = " ";
        for(Character c: result)
            name +=c.toString();
        return name;
    }

    @Override
    public String getCodeAccount() {
        String codeAccount = "12764194937465289";
        int AccountIndex = codeAccount.length();
        for (int i = 0; i < codeAccount.length(); i++) {
            char s = codeAccount.charAt(r.nextInt(AccountIndex));
            codeAccount = String.valueOf(s);

        }
        return codeAccount;
    }

    @Override
    public int cumeSumCVV(String codeAccount) {
        String[] help = new String[]{codeAccount};
        int[] b = new int[help.length];
        for (int i = 0; i < help.length; i++) {
            b[i] = Integer.parseInt(help[i]);
            SumCVV = IntStream.of(b).sum();
        }
        return SumCVV;
    }

    private String generateStringCVV() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(SumCVV);
        String CVV = sb.toString();
        return CVV;
    }

    @Override
    public String toString() {
        return "Name=" + getNameCardholder() + "  CC#=  " + getCodeAccount() + "  CVV=  " + CVV +
                "  (validated)";
    }
}
