import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        for(int i = 0; i < c - 1; i++) {
            a *= b;
            if(i == c - 2)
                System.out.printf("%d", a);
        }
    }
}
