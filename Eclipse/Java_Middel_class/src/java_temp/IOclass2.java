package java_temp;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOclass2 {
// Byte 는 inputStream 과 OutPutStream 추상클래스 상속해서 만들어짐
// Char 는 Reader 와 Writer 추상클래스 상속해서 만들어짐
// 어디로 부터 입력을 받을 건지 쓸것인지 나타내는 클래스는 1byte나 1char단위로 입력하거나 byte 배열, Char 배열로 입출력 한다.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// FileInput Stream OutputStream FileReader FileWriter
		// ByteArrayInputStream ByteArrayOutputSteam CharReader, CharWriter
		// 위 클래스들을 장식 대상 클래스라고 부른다.
		// DataInputStream DataOutputStream BufferedReader PrintWriter
		// 장식하는 클래스 
		
		// 데코레이터 패턴 하나의 클래스를 장식하는 것처럼 생성자에서 감싸서 새로운 기능을 계속
		// 추가 할 수 있도록 클래스를 만드는 방식
		// 수도꼭지에 다른 샤워기를 꽂을 수 있는 것처럼
		// 한 클래스에 여러 클래스를 생성자로 입력해 기능을 추가하는 방식을
		// 데코레이션 패턴이라고 한다.
		
		//Byte 단위 입출력
		FileInputStream fis = null; // 파일을 읽기 위한 객체
		FileOutputStream fos = null; // 파일을 쓰기 위한 객체
		
		try {
			fis = new FileInputStream("src/java_temp/IOclass.java");
			fos = new FileOutputStream("byte.txt");// 내가 파일을 쓰고 싶은 위치;
			
			int readCount = -1;
			// read 메서드는 1byte씩 읽는다. 리턴타입은 int 마지막에 읽은 1byte를 저장
			// byte를 retrune 하면 끝을 나타내는 값을 표현한다.
			byte[] buffer = new byte[512];
			//	512Byte 씩 읽는다.
			try {
				while((readCount = fis.read()) != -1) {
//					fos.write(readCount); // 1byte 씩 읽어오는 것
					fos.write(buffer, 0 , readCount); // 512byte 씩 읽어온다.
					// 1byte씩 읽어오는게 느린 이유는
					// 운영체제에서 512byte 씩 읽어서 1byte만 주고 511byte는 버리기 때문.
					// 가능하면 512byte씩 읽어서 처리하는 것이 성능 상 좋다.
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 자바 IOClass는 사용하고나면 무조건 close 메소드를 사용해야한다.
	}

}
