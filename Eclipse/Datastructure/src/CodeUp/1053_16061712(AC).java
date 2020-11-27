import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int a = kb.nextInt();
        if(a == 0)
            a = 1;
        else if(a == 1)
            a = 0;
        System.out.printf("%d", a);
    }
}
