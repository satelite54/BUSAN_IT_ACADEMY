import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class code19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileNameString = "input.txt";
		Scanner inFlie;
		// sout ��� �ڵ��ϼ�

		String[] name = new String[1000];
		String[] phonenumber = new String[1000];
		int n = 0;
		try { //
			inFlie = new Scanner(new File(fileNameString));

			while (inFlie.hasNext()) { // hasnext�� ������ ���� �����ߴ���? üũ
				name[n] = inFlie.next(); // �ϳ��� ���ڿ��� �о�´�
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
