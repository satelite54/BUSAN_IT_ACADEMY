import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = str.charAt(0);
        int nB = Integer.parseInt(str, 16);
        for(int i = 1; i < 16; i++) {
            System.out.printf("%c*%X=%X\n", c, i, nB*i);
        }
    }
}
