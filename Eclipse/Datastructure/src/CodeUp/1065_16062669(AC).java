import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int a = kb.nextInt();
        int b = kb.nextInt();        
        int c = kb.nextInt();
        
        if(a % 2 == 0)
            System.out.println(a);
        if(b % 2 == 0)
            System.out.println(b);
        if(c % 2 == 0)
            System.out.println(c);
    }
}
