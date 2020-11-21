package abstracts;

abstract class CAbstractClass { // abstract는 상속을 강제하는 일종의 규제
	// 메소드의 시스니처만 정의해놓고 그 메소드의 실제 동작 방법은 하위클래스에서 오버라이딩해야함

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

abstract public class CAbstract { // abstract는 상속을 강제하는 일종의 규제

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		B obj = new b();
	}
	
}
