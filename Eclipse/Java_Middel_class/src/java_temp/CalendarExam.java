package java_temp;
import java.util.Calendar;

public class CalendarExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance(); // Calender�� �� �ϼ��� �߻�Ŭ����
		// Calendar�� �׷����� Calendar��� �ڽ� Ŭ������ ������ ����.
		// getInstance()�ϸ� �׷����� Calendar�� ���� �� �� �ִ�.
		// �̷��� ������ ������ ���߿� �޷� ������ �ٲ� �� ���� ����Ѱ���.
		// �ڹ� ���׷��̵� �� �� �޷� ������ �ٲ�� �ִٸ� ���� �׷����� ��� �ٸ� �޷� ������
		// �ν��Ͻ�ȭ�ϸ� �Ǵϱ�.
		System.out.println(cal.get(Calendar.YEAR));// Ŭ���� ����� �̿��ؼ� ���� ������
		System.out.println(cal.get(Calendar.MONTH) + 1);
		System.out.println(cal.get(Calendar.DATE));
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));
		System.out.println(cal.get(Calendar.MINUTE));
		
		cal.add(Calendar.HOUR, 5);//���ϴ� �ð����� �ð��� �ٲ� �� �ִ�.
		// ����ð����� 5�ð� ���ķ� ����
		System.out.println(cal.get(Calendar.HOUR));
	}

}
