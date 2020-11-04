import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class code19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileNameString = "input.txt";
		Scanner inFlie;
		// sout 출력 자동완성

		String[] name = new String[1000];
		String[] phonenumber = new String[1000];
		int n = 0;
		try { //
			inFlie = new Scanner(new File(fileNameString));

			while (inFlie.hasNext()) { // hasnext는 파일의 끝에 도달했는지? 체크
				name[n] = inFlie.next(); // 하나의 문자열을 읽어온다
				phonenumber[n] = inFlie.next();
				n++;
			}
			inFlie.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("No file");
//			return;
			System.exit(0);
		}
		
		for(int i = 0; i < n; i++) {
			System.out.println(name[i] + ": " + phonenumber[i]);
		}
	}

}
