package java_temp;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOclass {
// Byte �� inputStream �� OutPutStream �߻�Ŭ���� ����ؼ� �������
// Char �� Reader �� Writer �߻�Ŭ���� ����ؼ� �������
// ���� ���� �Է��� ���� ���� �������� ��Ÿ���� Ŭ������ 1byte�� 1char������ �Է��ϰų� byte �迭, Char �迭�� ����� �Ѵ�.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// FileInput Stream OutputStream FileReader FileWriter
		// ByteArrayInputStream ByteArrayOutputSteam CharReader, CharWriter
		// �� Ŭ�������� ��� ��� Ŭ������� �θ���.
		// DataInputStream DataOutputStream BufferedReader PrintWriter
		// ����ϴ� Ŭ���� 
		
		// ���ڷ����� ���� �ϳ��� Ŭ������ ����ϴ� ��ó�� �����ڿ��� ���μ� ���ο� ����� ���
		// �߰� �� �� �ֵ��� Ŭ������ ����� ���
		// ���������� �ٸ� �����⸦ ���� �� �ִ� ��ó��
		// �� Ŭ������ ���� Ŭ������ �����ڷ� �Է��� ����� �߰��ϴ� �����
		// ���ڷ��̼� �����̶�� �Ѵ�.
		
		//Byte ���� �����
		FileInputStream fis = null; // ������ �б� ���� ��ü
		FileOutputStream fos = null; // ������ ���� ���� ��ü
		
		try {
			fis = new FileInputStream("src/java_temp/IOclass.java");
			fos = new FileOutputStream("byte.txt");// ���� ������ ���� ���� ��ġ;
			
			int readData = -1;
			// read �޼���� 1byte�� �д´�. ����Ÿ���� int �������� ���� 1byte�� ����
			// byte�� retrune �ϸ� ���� ��Ÿ���� ���� ǥ���Ѵ�.
			try {
				while((readData = fis.read()) != -1) {
					fos.write(readData);
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
	}

}
