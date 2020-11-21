package OverLoading;

public class OverLoadingDemo2 extends OverLoadingDemo {

	void A (String arg1, String arg2) { // 
		System.out.println("sub class : void A (String arg1, String arg2)");
	}
	void A () {// 인자가 없는 매소드 부모클래스가 존재하기 때문에 오버로딩된다
		System.out.println("sub class : void A ()"); // 매개변수 X
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
//오버로딩이라는 것은 같은 이름 다른 매소드
// 오버라이딩이라는 것은 부모클래스의 동일한 입력값과 이름을 가진 매소드를 자식클래스에서 재정의 하는것
	// 오버라이딩 올라탄다
	// 오버로딩 같은이름 하지만 다른 매개변수를 가진 매소드를 여러 클래스에 로딩한다.
}
