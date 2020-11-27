import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String[] astr = str.split("\\.");
        int y = Integer.parseInt(astr[0]);
        int m = Integer.parseInt(astr[1]);
        int d = Integer.parseInt(astr[2]);
        System.out.printf("%02d-%02d-%d", d, m, y);
    }
}
