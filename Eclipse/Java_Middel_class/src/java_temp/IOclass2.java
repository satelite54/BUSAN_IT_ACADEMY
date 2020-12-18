package java_temp;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOclass2 {
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
			
			int readCount = -1;
			// read �޼���� 1byte�� �д´�. ����Ÿ���� int �������� ���� 1byte�� ����
			// byte�� retrune �ϸ� ���� ��Ÿ���� ���� ǥ���Ѵ�.
			byte[] buffer = new byte[512];
			//	512Byte �� �д´�.
			try {
				while((readCount = fis.read()) != -1) {
//					fos.write(readCount); // 1byte �� �о���� ��
					fos.write(buffer, 0 , readCount); // 512byte �� �о�´�.
					// 1byte�� �о���°� ���� ������
					// �ü������ 512byte �� �о 1byte�� �ְ� 511byte�� ������ ����.
					// �����ϸ� 512byte�� �о ó���ϴ� ���� ���� �� ����.
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
		// �ڹ� IOClass�� ����ϰ��� ������ close �޼ҵ带 ����ؾ��Ѵ�.
	}

}
