package lifeCoding;

public class function {

	public static void main(String[] args) {// Run Configuration���� �Ķ���͸� �� �� �ִ�.
		// TODO Auto-generated method stub
		int i = 4;
		name(i); // ���⼭�� ���ڶ�� ��
		PrintStringAry(args);
	}
	
	public static void name(int limit) { // �ż����� �Է� ���� �Ű�����, �Ķ����
		int i = 0;
		while (i < limit) {
			System.out.println(i);
			i++;
		}
	}
	public static void PrintStringAry(String[] str) { // �ż����� �Է� ���� �Ű�����, �Ķ����
		for(int i = 0; i < str.length; i++)
		System.out.println(str[i]);
	}
}
// java ���α׷��� ������ ��
// cmd
// ���α׷���
//java -cp bin ��Ű����.Ŭ������ [�Է°�1, �Է°�2...]