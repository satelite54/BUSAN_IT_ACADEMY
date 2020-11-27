import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String data = kb.next();
        String[] strdata = data.split("\\.");
        
        System.out.printf("%s\n%s", strdata[0], strdata[1]);
    }
}
