package java_temp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExam {//����ȭ�� ���� ����� ���� ���� jdk 1.0 ���� �־���
	public static void main(String[] args) { 
		// TODO Auto-generated method stub
		Date date = new Date();
		System.out.println(date.toString());
		
		SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd 'at' hh:mm:ss a zzz");// �������� ���ڿ� ǥ���ϰ� ���� ���� �ָ��
		// ���� MM �빮�� ����� a�� ���� ���� ǥ�� // zzz�� ǥ�ؽð� ǥ��
		
		System.out.println(ft.format(date));
		System.out.println(date.getTime());//long���� �ð��� ����
		long today = System.currentTimeMillis();
		System.out.println(today);//long���� ���� �ý��� �ð��� ����
		
		System.out.println(today - date.getTime());//�ð��� ���� ���굵 ����
	}
}
