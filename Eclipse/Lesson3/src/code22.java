import java.util.Scanner;

public class code22 {

	static String [] wordStrings = new String [10000];
	static int [] count = new int [10000];
	static int n = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner kb = new Scanner(System.in);
		while(true) {
			System.out.print("$ ");
			String commend = kb.next();
			if(commend.equals("read")) {
				String fileName = kb.next();
				makeIndex(fileName);
			}
			else if (commend.equals("find")) {
				
			}
			else if (commend.equals("saveas")) {
				System
			}
			else if (commend.equals("exit")) {
				break;
			}
			else {
				System.out.println("Wrong commend");
			}
		}
	}

	static void makeIndex(String fileName)
}
