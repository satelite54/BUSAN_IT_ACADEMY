package PolymorphismOverloadingDemo;

interface I2 {
	public String A();
}
interface I3 {
	public String B();
}

class D implements I2, I3 {
	public String A() {
		return "A";
	}
	public String B() {
		return "B";
	}
	
}

public class CPolymorphismOverloadingDemo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		D obj = new D();
		I2 objI2 = new D();
		I3 objI3 = new D();
		// 인터페이스가 맴버들을 가지고 있는 클래스 처럼 사용가능
		// D에서 인터페이스를 구현해 주었기 때문
		// 이런식으로 구현하면 클래스내에 맴버가 포함되어 있고 동시에
		// 인터페이스 내에 있는 맴버들만
		// 사용가능 다른 클래스 맴버들은 없는 것 처럼 할 수 있다.
		obj.A();
		obj.B();
		
		objI2.A();
//		objI2.B();//사용안됨
//		
//		objI3.A();//사용안됨
		objI3.B();
	}
	
	//이렇게 비유하면 기억하기 편하다.
	// 꼬맹이에게 스마트폰을 주면서 이건 게임기야 이렇게 말하면
	// 꼬맹이는 그건 게임기인 줄 알고 게임만 한다.
	// 스마트폰이라는 클래스에는 전화, 게임이라는 인터페이스가 있는데 
	// 꼬맹이는 게임만 이용한 것
	
	
	//
}
