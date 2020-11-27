import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        char c = 'p';
        if(a >= 90 && a <= 100)
            c = 'A';
        else if(a >= 70)
            c = 'B';
        else if(a >= 40)
            c = 'C';
        else if(a < 40)
            c = 'D';
            
        System.out.printf("%c", c);
    }
}
