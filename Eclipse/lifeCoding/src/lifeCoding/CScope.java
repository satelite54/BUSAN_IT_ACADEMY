package lifeCoding;

public class CScope { // ��ȿ ����

	public static void a() {
		int i = 0; // i�� �޼ҵ� �ȿ����� ��밡���� ����
		// ���� ����(local variables)
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			a();
			System.out.println(i);
		}
	}
}
