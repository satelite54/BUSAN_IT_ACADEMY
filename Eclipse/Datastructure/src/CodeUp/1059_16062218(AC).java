import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int a = kb.nextInt();
        
        a = ~a;
        
        System.out.printf("%d", a);
    }
}
