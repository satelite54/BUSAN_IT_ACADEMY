package PolymorphismOverloadingDemo;

class O{ // 오버라이딩, 오버로딩 대표적인 다형성
	public void a(int param) {
		System.out.println("숫자출력");
		System.out.println(param);
	}
	public void a(String param) {
		System.out.println("문자출력");
		System.out.println("param");		
	}
}
public class CPolymorphismOverloadingDemo {	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		O o = new O();
		o.a(1);
		o.a("one");
	}
}
