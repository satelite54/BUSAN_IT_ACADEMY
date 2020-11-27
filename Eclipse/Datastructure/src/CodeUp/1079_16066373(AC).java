import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        for(int n = 0; n < str.length(); n++) {
            if(n % 2 == 1)
                continue;
            System.out.println(str.charAt(n));
            if(str.charAt(n) == 'q')
                break;
        }
    }
} 
