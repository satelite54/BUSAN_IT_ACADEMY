import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int a = kb.nextInt();
        
        if(a < 0) {
            System.out.println("minus");
            if(a % 2 == 0) {
                System.out.println("even");
            }
            else {
                System.out.println("odd");
            }
        }
        else {
            System.out.println("plus");
            if(a % 2 == 0) {
                System.out.println("even");
            }
            else {
                System.out.println("odd");
            }
        }
    }
}

