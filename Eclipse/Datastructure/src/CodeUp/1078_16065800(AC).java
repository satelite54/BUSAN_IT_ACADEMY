import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int sum = 0;
        for(int n = 0; n <= a; n++){
            if(n % 2 == 0)
                sum += n;
        }
        System.out.println(sum);
    }
} 
