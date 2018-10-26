 class SupplementString {
     public static void main(String[] args) {

         String quote = "Hofstadter's Law: It you expect, even when you take into account Hofstadter's Law.";
         String substr1 = quote.substring(0, 20);
         String substr2 = quote.substring(21);
         String additionStr = " always takes longer than ";

         System.out.println(substr1 + additionStr + substr2);
     }

 }
