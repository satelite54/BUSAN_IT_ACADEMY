import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        switch(a) {
            case 1:
            case 2:
                System.out.printf("%s", "winter");
                break;
            case 3:
            case 4:
            case 5:
                System.out.printf("%s", "spring");
                break;
            case 6:
            case 7:
            case 8:
                System.out.printf("%s", "summer");
                break;
            case 9:
            case 10:
            case 11:
                System.out.printf("%s", "fall");
                break;
            case 12:
                System.out.printf("%s", "winter");
                break;
        }
    }
}
