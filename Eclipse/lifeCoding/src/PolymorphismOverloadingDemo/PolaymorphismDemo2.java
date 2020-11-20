package PolymorphismOverloadingDemo;

interface I {
	
}

class C implements I {
	
}

public class PolaymorphismDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		I obj = new C(); // C 클래스를 인스턴스화해서 I 인터페이스에 담았다.
		// 이렇게 될 수 있는 이유는 C는 I를 구현하기 때문이다.
	}
}
