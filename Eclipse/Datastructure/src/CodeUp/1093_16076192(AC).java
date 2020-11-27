import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner kb = new Scanner(System.in);
        int a = kb.nextInt(); // 엔터값이 남게된다.
        String str = kb.nextLine(); // 엔터값 기준으로 값을 읽기 때문에
        String str1 = kb.nextLine(); // 하나더 써줌.
        String[] strAry = str1.split(" ");
        int[] nAry = new int[23];
        for(int i = 0; i < strAry.length; i++) {
            int number = Integer.parseInt(strAry[i]);
            nAry[number - 1] += 1;
        }
        for(int i = 0; i < nAry.length; i++) {
            if(i == nAry.length - 1) {
                System.out.printf("%d", nAry[i]);
                break;
            }
            System.out.printf("%d ", nAry[i]);
        }
    }
}
