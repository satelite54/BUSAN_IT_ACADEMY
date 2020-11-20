package Interface;

public class InterfaceEx3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

interface I1 {
	public void x();
}
interface I2 { 
	public void z();
}

class B implements I1, I2 { // 하나의 클래스는 복수개의 인터페이스를 구현할 수 있다.
	public void x() {
		
	}
	public void z() {
		
	}
}

interface I3 {
	void x();
}
interface I4 extends I3, I1 {// 인터페이스도 상속이 가능하다. 클래스와 차이가 있다. 하위 클래스는 하나의 부모클래스만을 상속할수 있다.
	// 인터페이스는 다중 상속이 가능하다.
}

//abstract와 interface는 비슷하지만 다르다.
//abstract class는 하위 클래스가 미구현된 메소드를 구현하기를 기대하면서 자기도 구현된 메소드를 가지고있다.
//interface는 무조건 클래스가 메소드를 구현해야함.