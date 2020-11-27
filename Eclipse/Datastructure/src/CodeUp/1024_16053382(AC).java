import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String data = kb.next();
        for(int i = 0; i < data.length(); i++) {
            System.out.printf("\'%c\'\n", data.charAt(i));	
        }
    }
}
