import java.util.*;

public class Main_Enter {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int i = 0;
		while(sc.hasNextInt()) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			i++;
			System.out.println("Case #" + i + ": " +(a + b));
		}
	}
}
