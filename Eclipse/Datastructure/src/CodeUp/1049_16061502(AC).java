import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int a = kb.nextInt();
        int b = kb.nextInt();
        int c;
        if(a > b)
            c = 1;
        else
            c = 0;
        System.out.printf("%d", c);
    }
}
