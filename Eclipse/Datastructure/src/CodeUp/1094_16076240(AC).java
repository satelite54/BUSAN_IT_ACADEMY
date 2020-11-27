import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner kb = new Scanner(System.in);
        int a = kb.nextInt(); // 엔터값이 남게된다.
        String str = kb.nextLine(); // 엔터값 기준으로 값을 읽기 때문에
        String str1 = kb.nextLine(); // 하나더 써줌.
        String[] strAry = str1.split(" ");
        for(int i = 0; i < strAry.length; i++) {
            if(i == strAry.length - 1) {
                System.out.printf("%s", strAry[0]);
                break;
            }
            System.out.printf("%s ", strAry[strAry.length - i - 1]);
        }
    }
}
