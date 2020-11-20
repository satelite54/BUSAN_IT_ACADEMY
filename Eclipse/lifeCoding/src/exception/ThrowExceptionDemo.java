package exception;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class B{
	void run() throws FileNotFoundException, IOException { // run 메소드는 FileNotFoundException이 발생할 수 있다~~
		// 그러니까 이 메소드 사용하는 분은 예외처리하세요~
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
//		b.run(); // 아 나도 예외처리하기 싫어!!!! 나도 넘길래
//	}
	void run() {
		B b = new B();
		try {// 내가 처리할껭.. ㅠㅠ 담에는 니가해줘
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
