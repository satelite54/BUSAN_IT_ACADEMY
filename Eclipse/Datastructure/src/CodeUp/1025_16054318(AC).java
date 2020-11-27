import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        for(int i = 0; i < a.length(); i++) {
            String Zero = "";
            for(int j = a.length() - i - 1; j > 0; j--){
              Zero = Zero + "0";  
            } 
            System.out.println("["+ a.charAt(i) + Zero + "]");
        }
    }
}
