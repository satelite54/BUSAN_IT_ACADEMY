import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.xml.crypto.Data;

public class code20 {

	static String[] name = new String[1000];
	static String[] phonenumber = new String[1000];
	static int n = 0;
	// class�� �������� ���ٰ���, Ŭ���� �ɹ�
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileNameString = "input.txt";
		Scanner inFlie;
		// sout ��� �ڵ��ϼ�


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
		
		bubblesort();
		
		for(int i = 0; i < n; i++) {
			System.out.println(name[i] + ": " + phonenumber[i]);
		}
	}

//	static void bubblesort(int n, String[] name, String[] phonenumber) {
	static void bubblesort() {
		for (int i = n - 1; i > 0; i--) {
			for(int j = 0; j < i; j++) {
				if(name[j].compareTo(name[j+1]) > 0) { // name[j]�� name[j+1] ���� Ŭ��� ��� ��ȯ
					String tmp = name[j];
					name[j] = name[j+1];
					name[j+1] = tmp;
					
					tmp = phonenumber[j];
					phonenumber[j] = phonenumber[j+1];
					phonenumber[j+1] = tmp;
				}
			}
		}
	}

}
