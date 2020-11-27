import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int a = kb.nextInt();
        int b = kb.nextInt();
        if(a == b)
            System.out.printf("%d", 1);
        else
            System.out.printf("%d", 0);
    }
}
