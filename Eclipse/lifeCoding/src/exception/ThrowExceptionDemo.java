package exception;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class B{
	void run() throws FileNotFoundException, IOException { // run �޼ҵ�� FileNotFoundException�� �߻��� �� �ִ�~~
		// �׷��ϱ� �� �޼ҵ� ����ϴ� ���� ����ó���ϼ���~
		BufferedReader bReader = null;
		String input = null;
//		try {
//			bReader = new BufferedReader(new FileReader("out.txt"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		try {
//			input = bReader.readLine();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		bReader = new BufferedReader(new FileReader("out.txt"));
		input = bReader.readLine();
		System.out.println(input);
		bReader.close();
	}
}
class C{
//	void run() throws FileNotFoundException {
//		B b = new B();
//		b.run(); // �� ���� ����ó���ϱ� �Ⱦ�!!!! ���� �ѱ淡
//	}
	void run() {
		B b = new B();
		try {// ���� ó���Ҳ�.. �Ф� �㿡�� �ϰ�����
			b.run();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}

public class ThrowExceptionDemo {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C c = new C();
		c.run();
	}
}
