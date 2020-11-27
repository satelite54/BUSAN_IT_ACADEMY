import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String[] astr = str.split("\\:");
        int n = Integer.parseInt(astr[1]);
        System.out.println(n);
    }
}
