import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int a = kb.nextInt();
        int b = kb.nextInt();
        int c = kb.nextInt();
        
        long d = a + b + c;
        double e = (double)d/3;
        System.out.println(d);
        System.out.printf("%.1f", e);
    }
}
