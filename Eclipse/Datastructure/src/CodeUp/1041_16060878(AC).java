import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char a = str.charAt(0);
        
        int b = (int)a + 1;
        char c = (char)b;
        System.out.printf("%c", c);
    }
}
