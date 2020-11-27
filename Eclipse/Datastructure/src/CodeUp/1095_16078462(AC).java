import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String LineEnterRemover = sc.nextLine();
        String[] strAray = sc.nextLine().split(" ");
        int[] nAry = new int[a];
        for(int i = 0; i < strAray.length; i++) {
            nAry[i] = Integer.parseInt(strAray[i]);
        }
        for(int j = nAry.length - 1; j >= 0; j--) {
            for(int k = 0; k < j; k++) {
                if(nAry[k] > nAry[k+1]) {
                    int temp = nAry[k];
                    nAry[k] = nAry[k+1];
                    nAry[k+1] = temp;
                }
            }
        }
        System.out.printf("%d", nAry[0]);
    }
}
