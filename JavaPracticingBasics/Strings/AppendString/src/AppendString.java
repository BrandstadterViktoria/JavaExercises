public class AppendString {

    public static void main(String[] args) {
        String todoText = " - Buy milk\n";
        String a = "My todo:";
        String b = " - Download games \n";
        String c = "- Diablo";
        String newStr = new StringBuffer(a).append(todoText).append(b).append(c).toString();
        System.out.println(newStr);

    }
}




