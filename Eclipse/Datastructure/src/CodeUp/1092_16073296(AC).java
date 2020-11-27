 import java.util.Scanner;
 
 
 public class Main {
      public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int day = 1;
        while(day%a!=0 || day%b!=0 || day %c!=0) {
         ++day;   
        }
        System.out.printf("%d", day);
    }   
 }
