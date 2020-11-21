package Interface;

public class CInterface {
	// 어떤 객체가 있고 그 객체가 특정한 인터페이스를 사용한다면 그 객체는 반드시 인터페이스의 메소드들을
	// 구현해야 한다.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}

interface I {
	public void z();
}

class A implements I {// 클래스 A는 인터페이스 I를 구현한다.
	public void z() {
		
	}
}
