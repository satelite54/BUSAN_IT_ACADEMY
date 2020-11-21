package OverLoading;

public class OverLoadingDemo { // 오버로딩

	void A () {System.out.println("Void A()");}
	void A (int arg1) {System.out.println("void A (int arg1)");}
//	void A (int param1) {System.out.println("void A (int arg1)");} // 매개변수 이름을 바꿔도 안된다. 자바에서는 어떤 매소드를 사용할지 알지 못한다. 매개변수이름을 밖에서 인자를 줄때 모른다.
	void A (String arg1) {System.out.println("void A (String arg1)");}
//	int A () {System.out.println("void A()");} 이거는 안됨
	// 오버로딩 제약조건
	// 매소드 이름은 같고 매개변수는 달라야한다. 리턴값은 같아야한다.
	
	public static void main(String[] args) {
		OverLoadingDemo od = new OverLoadingDemo();
		od.A();
		od.A(1);
		od.A("coiding everybody");
	}
	
}
