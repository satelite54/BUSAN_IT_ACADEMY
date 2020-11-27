import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
    int a;

    String b;



    Scanner sc = new Scanner(System.in);

    b=sc.nextLine();

    a=Integer.valueOf(b, 8);

    sc.close();

    

    System.out.format("%d\n", a);
    }
}

