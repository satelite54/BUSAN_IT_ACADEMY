import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int a = kb.nextInt();
        int b = kb.nextInt();        
        int c = kb.nextInt();
        System.out.printf("%d", (a<b?a:b)<c?(a<b?a:b):c);
    }
}
