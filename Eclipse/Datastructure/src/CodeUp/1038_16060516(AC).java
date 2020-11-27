import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        long a = kb.nextLong();
        long b = kb.nextLong();
        System.out.println(sum(a, b));
    }
    
    public static long sum(long a, long b) {
        return a + b;
    }
}
