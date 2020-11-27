import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> AryL = new ArrayList<Integer>();
        while(sc.hasNext()) {
            int a = sc.nextInt();
            AryL.add(a);
        }
        for(int i = 0; i < AryL.size() - 1; i++) {
            int getAL = AryL.get(i + 1);
            System.out.printf("%d\n", getAL);
        }
    }
} 
