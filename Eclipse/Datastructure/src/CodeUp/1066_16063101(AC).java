import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int a = kb.nextInt();
        int b = kb.nextInt();        
        int c = kb.nextInt();
        
        if(a % 2 == 0) {
            System.out.println("even");
        }
        else {
            System.out.println("odd");
        }
        if(b % 2 == 0) {
            System.out.println("even");
        }
        else {
            System.out.println("odd");
        }
        if(c % 2 == 0) {
            System.out.println("even");
        }
        else {
            System.out.println("odd");
        }
    }
}

