package lifeCoding;

public class CScope2 {

	int age = this.age;
	
	static int i; // ���� ����(global variables)
	static void a() {
		i = 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (i = 0; i < 5; i++) {
			a();
			System.out.println(i);
		}
	}
	// ������Ʈ���� �ڹ� ���� ���� �� ������ Ŭ�� -> Compare With -> Each other
	// �ΰ� ������ ��������?? �����ش�.
}
