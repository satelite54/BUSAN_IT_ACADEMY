import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double num = sc.nextDouble();
        String str = String.format("%.11f", num);
        System.out.print(str);
    }
}

