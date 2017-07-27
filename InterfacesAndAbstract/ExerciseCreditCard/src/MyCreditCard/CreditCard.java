package MyCreditCard;

import java.util.Random;
import java.util.stream.IntStream;

public class CreditCard implements CreditCardy {
    private Random r = new Random();
    private String name;
    private int codeSumCVV;
    private String codeAccount;
    String CVV;

    public CreditCard() {
    }

    @Override
    public int getSumCVV() {
        return cumeSumCVV(codeAccount);
    }

    @Override
    public String getNameCardholder() {
        String NameCardholder = "BRANDSTADTER VIKTORIA";
        int nameHolderIndex = NameCardholder.length();
        for (int i = 0; i <= NameCardholder.length(); i++) {
            char s = NameCardholder.charAt(r.nextInt(nameHolderIndex));
            name = String.valueOf(s);
        }
        return name;
    }

    @Override
    public String getCodeAccount() {

        String codeAccount = "12764194937465289";
        int AccountIndex = 17;
        for (int i = 0; i < 17; i++) {
            char s = codeAccount.charAt(r.nextInt(AccountIndex));
            codeAccount = String.valueOf(s);
            this.codeAccount = getCodeAccount();
        }
        return codeAccount;
    }

    @Override
    public int cumeSumCVV(String codeAccount) {
        String[] help = new String[]{codeAccount};
        int[] b = new int[help.length];
        for (int i = 0; i < help.length; i++) {
            b[i] = Integer.parseInt(help[i]);
            codeSumCVV = IntStream.of(b).sum();
        }
        return codeSumCVV;
    }

    private String generateStringCVV() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(codeSumCVV);
        String CVV = sb.toString();
        this.CVV = CVV;
        return CVV;
    }

    @Override
    public String toString() {
        return "Name=" + getNameCardholder() + "  CC#=  " + getCodeAccount() + "  CVV=  " + CVV +
                "  (validated)";


    }
}
