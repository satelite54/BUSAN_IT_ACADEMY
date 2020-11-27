 import java.util.Scanner;
 
 
 public class Main {
      public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        
        for(int i = 0; i < d - 1; i++){
            a *= b;
            a += c;
        }
        System.out.printf("%d", a);
    }   
 }
