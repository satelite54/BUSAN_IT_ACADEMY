import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = str.charAt(0);
        char a = 'a';
        while(a <= c) {
            System.out.printf("%c ", a);
            a++;
        }
    }
} 
