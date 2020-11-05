import java.io.File;
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
				break;
			}
			else if (commend.equals("find")) {
				String str = kb.next();
				int index = findWord(str);
				if(index > -1) {
					System.out.println("The word" + str + "doesn't appears");
				}
			}
			else if (commend.equals("saveas")) {
				
			}
			else if (commend.equals("exit")) {
				break;
			}
			else {
				System.out.println("Wrong commend");
			}
		}
		kb.close();
		
		for(int i = 0; i < n; i++) {
			System.out.println(wordStrings[i] + "" + count[i]);
		}
	}

	static void makeIndex(String fileName) {
		try {
			Scanner inFileScanner = new Scanner(new File(fileName));
			while(inFileScanner.hasNext()) {
				String str = inFileScanner.next();
				addword(str);
			}
			
			inFileScanner.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	static void addword(String str) {
		int index = findWord(str);
		if(index != -1) { //found
			
		}
		else { // not found
			wordStrings[n] = str;
			count[n] = 1;
			n++;
		}
	}
	static int findWord(String str) {
		for(int i = 0; i < n; i++)
			if(wordStrings[i].equals(str))
				return 1;
		return -1;
	}
}
