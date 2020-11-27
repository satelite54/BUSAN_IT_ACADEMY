import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String makestr = "";
        for(int i = 1; i <= n; i++) {
            if(i % 3 == 0) {
                System.out.print(" X");
                continue;
            }
            if(i == 1)
                System.out.printf("%d", i);
            else 
                System.out.printf(" %d", i);
        }
    }
}
