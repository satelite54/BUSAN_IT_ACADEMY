package abstracts;

abstract class CAbstractClass { // abstract�� ����� �����ϴ� ������ ����
	// �޼ҵ��� �ý���ó�� �����س��� �� �޼ҵ��� ���� ���� ����� ����Ŭ�������� �������̵��ؾ���

	public abstract int b();
	public void d() {
		System.out.println("world");
	}
	
}

class B extends CAbstractClass {
	public int b() {
		return 1;
	}
}

abstract public class CAbstract { // abstract�� ����� �����ϴ� ������ ����

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		B obj = new b();
	}
	
}
