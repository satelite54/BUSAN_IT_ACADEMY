package PolymorphismOverloadingDemo;
// 클래스의 다형성
class A{
	public String x() {
		return "A.x";
	}
}
class B extends A{
	public String x() {
		return "B.x";
	}
	public String y() {
		return "y";
	}
}
class B2 extends A{
	public String x() {
		return "B2.x";
	}
}

public class CPolymorphismOverloadingDemoclass { // 클래스와 다형성

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A obj = new B(); // B라는 객체를 인스턴스화 시키고 obj라는 변수에 담았는데 obj는 A라는 데이터 타입을 가진다.
		System.out.println(obj.x());
		A obj2 = new B2(); // 부모의 행세를 하기 때문에 자식클래스에 담긴 메소드는 호출이 불가능하다.
		System.out.println(obj.x()); // 자식클래스에서 오버라이딩한 B.x를 출력
		System.out.println(obj2.x());// 부모클래스에 있는 B2.x를 출력
	}
	// 1. 어떠한 클래스를 인스턴스화 시킬때 부모클래스를 사용할 수 도 있다.
	// 2. 
}
