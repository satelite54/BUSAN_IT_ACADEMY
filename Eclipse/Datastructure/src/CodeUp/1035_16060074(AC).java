import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str1 = kb.next();
        int Hex = Integer.parseInt(str1, 16);// 입력할 수를 16진수에서 10진수로 바꿈
        System.out.printf("%o", Hex);
    }
}
