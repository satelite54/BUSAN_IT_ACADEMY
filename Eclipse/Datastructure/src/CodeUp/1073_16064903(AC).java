import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> AryL = new ArrayList<Integer>();
        while(sc.hasNext()) {
            int a = sc.nextInt();
            if(a == 0)
                break;
            AryL.add(a);
        }
        for(int i = 0; i < AryL.size(); i++) {
            int getAL = AryL.get(i);
            System.out.printf("%d\n", getAL);
        }
    }
} 

