package abstracts;

abstract class CAbstractClass { // abstract�� ����� �����ϴ� ������ ����

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
